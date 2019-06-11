package edu.ntut.eatogo.dbfactory.persistence.repository;

import edu.ntut.eatogo.dbfactory.persistence.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}
