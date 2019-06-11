package edu.ntut.eatogo.dbfactory.persistence.repository;

import edu.ntut.eatogo.dbfactory.persistence.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, String> {
}
