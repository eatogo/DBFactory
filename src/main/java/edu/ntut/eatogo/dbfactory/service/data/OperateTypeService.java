package edu.ntut.eatogo.dbfactory.service.data;

import edu.ntut.eatogo.dbfactory.converter.DomainDtoConverter;
import edu.ntut.eatogo.dbfactory.dto.OperateTypeDto;
import edu.ntut.eatogo.dbfactory.persistence.dao.DefaultDataDao;
import edu.ntut.eatogo.dbfactory.persistence.repository.OperateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperateTypeService {

    @Autowired
    private DefaultDataDao dataDao;

    @Autowired
    private OperateTypeRepository operateTypeRepository;

    @Autowired
    private DomainDtoConverter domainDtoConverter;

    @Transactional
    public void insertDefaultOperateType() throws IOException {
        operateTypeRepository.saveAll(dataDao.getDefaultOperateType());
    }

    public List<OperateTypeDto> getOperateTypes() {
        return operateTypeRepository.findAll().stream().map(domainDtoConverter::convertToDto).collect(Collectors.toList());
    }
}
