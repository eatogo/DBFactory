package edu.ntut.eatogo.dbfactory.service.data;

import edu.ntut.eatogo.dbfactory.converter.DomainDtoConverter;
import edu.ntut.eatogo.dbfactory.dto.AreaDto;
import edu.ntut.eatogo.dbfactory.persistence.dao.DefaultDataDao;
import edu.ntut.eatogo.dbfactory.persistence.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaService {

    @Autowired
    private DefaultDataDao dataDao;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private DomainDtoConverter domainDtoConverter;

    @Transactional
    public void insertDefaultArea() throws IOException {
        areaRepository.saveAll(dataDao.getDefaultArea());
    }

    public List<AreaDto> getAreas() {
        return areaRepository.findAll().stream().map(domainDtoConverter::convertToDto).collect(Collectors.toList());
    }
}
