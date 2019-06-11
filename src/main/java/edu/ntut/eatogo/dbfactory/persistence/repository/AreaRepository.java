package edu.ntut.eatogo.dbfactory.persistence.repository;

import edu.ntut.eatogo.dbfactory.persistence.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
}
