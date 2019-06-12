package edu.ntut.eatogo.dbfactory.service.data;

import edu.ntut.eatogo.dbfactory.persistence.dao.DefaultDataDao;
import edu.ntut.eatogo.dbfactory.persistence.entity.OperateType;
import edu.ntut.eatogo.dbfactory.persistence.entity.OperateTypePeriod;
import edu.ntut.eatogo.dbfactory.persistence.repository.OperateTypeRepository;
import edu.ntut.eatogo.dbfactory.persistence.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperateTypePeriodService {

    @Autowired
    private DefaultDataDao dataDao;

    @Autowired
    private OperateTypeRepository operateTypeRepository;

    @Autowired
    private PeriodRepository periodRepository;

    @Transactional
    public void insertDefaultOperateTypePeriod() throws IOException {
        List<OperateTypePeriod> operateTypePeriods = dataDao.getDefaultOperateTypePeriod();
        List<OperateType> operateTypes = operateTypeRepository.findByOperateTypeIdIn(
                operateTypePeriods.stream().mapToInt(OperateTypePeriod::getOperateTypeId).distinct().boxed().collect(Collectors.toList()));
        operateTypes.forEach(operateType -> operateTypePeriods.stream()
                .filter(operateTypePeriod -> operateTypePeriod.getOperateTypeId().equals(operateType.getOperateTypeId()))
                .forEachOrdered(operateTypePeriod -> operateType.addPeriod(periodRepository.getOne(operateTypePeriod.getPeriodId()))));
        operateTypeRepository.saveAll(operateTypes);
    }
}
