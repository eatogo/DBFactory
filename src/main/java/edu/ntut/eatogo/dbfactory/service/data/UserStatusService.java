package edu.ntut.eatogo.dbfactory.service.data;

import edu.ntut.eatogo.dbfactory.converter.DomainDtoConverter;
import edu.ntut.eatogo.dbfactory.dto.UserStatusDto;
import edu.ntut.eatogo.dbfactory.persistence.dao.DefaultDataDao;
import edu.ntut.eatogo.dbfactory.persistence.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserStatusService {

    @Autowired
    private DefaultDataDao dataDao;

    @Autowired
    private UserStatusRepository userStatusRepository;

    @Autowired
    private DomainDtoConverter domainDtoConverter;

    @Transactional
    public void insertDefaultUserStatus() throws IOException {
        userStatusRepository.saveAll(dataDao.getDefaultUserStatus());
    }

    public List<UserStatusDto> getUserStatuses() {
        return userStatusRepository.findAll().stream().map(domainDtoConverter::convertToDto).collect(Collectors.toList());
    }
}
