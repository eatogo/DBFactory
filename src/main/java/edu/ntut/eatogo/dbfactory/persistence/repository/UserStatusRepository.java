package edu.ntut.eatogo.dbfactory.persistence.repository;

import edu.ntut.eatogo.dbfactory.persistence.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, String> {
}
