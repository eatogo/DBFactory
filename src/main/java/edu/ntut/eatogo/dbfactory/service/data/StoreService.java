package edu.ntut.eatogo.dbfactory.service.data;

import edu.ntut.eatogo.dbfactory.converter.DomainDtoConverter;
import edu.ntut.eatogo.dbfactory.dto.StoreDto;
import edu.ntut.eatogo.dbfactory.persistence.dao.DefaultDataDao;
import edu.ntut.eatogo.dbfactory.persistence.repository.AreaRepository;
import edu.ntut.eatogo.dbfactory.persistence.repository.OperateTypeRepository;
import edu.ntut.eatogo.dbfactory.persistence.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    private DefaultDataDao dataDao;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private OperateTypeRepository operateTypeRepository;

    @Autowired
    private DomainDtoConverter domainDtoConverter;

    @Transactional
    public void insertDefaultStore() throws IOException {
        storeRepository.saveAll(dataDao.getDefaultStore().stream()
                .map(domainDtoConverter::convertToDomain)
                .peek(store -> {
                    store.setArea(areaRepository.getOne(store.getArea().getAreaId()));
                    if (store.getOperateType() == null) store.setOperateType(operateTypeRepository.getOne(1));
                })
                .collect(Collectors.toList()));
    }

    public List<StoreDto> getStores() {
        return storeRepository.findAll().stream().map(domainDtoConverter::convertToDto).collect(Collectors.toList());
    }
}
