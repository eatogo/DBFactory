package edu.ntut.eatogo.dbfactory.service.data;

import edu.ntut.eatogo.dbfactory.converter.DomainDtoConverter;
import edu.ntut.eatogo.dbfactory.dto.FoodTypeDto;
import edu.ntut.eatogo.dbfactory.persistence.dao.DefaultDataDao;
import edu.ntut.eatogo.dbfactory.persistence.repository.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodTypeService {

    @Autowired
    private DefaultDataDao dataDao;

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    private DomainDtoConverter domainDtoConverter;

    @Transactional
    public void insertDefaultFoodType() throws IOException {
        foodTypeRepository.saveAll(dataDao.getDefaultFoodType());
    }

    public List<FoodTypeDto> getFoodTypes() {
        return foodTypeRepository.findAll().stream().map(domainDtoConverter::convertToDto).collect(Collectors.toList());
    }
}
