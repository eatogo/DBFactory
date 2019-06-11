package edu.ntut.eatogo.dbfactory.persistence.repository;

import edu.ntut.eatogo.dbfactory.persistence.entity.OperateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperateTypeRepository extends JpaRepository<OperateType, Integer> {

    List<OperateType> findByOperateTypeIdIn(List<Integer> operateTypeIds);
}
