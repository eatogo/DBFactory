package edu.ntut.eatogo.dbfactory.persistence.repository;

import edu.ntut.eatogo.dbfactory.persistence.domain.IdClass.StoreAuthorizationId;
import edu.ntut.eatogo.dbfactory.persistence.domain.StoreAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreAuthorizationRepository extends JpaRepository<StoreAuthorization, StoreAuthorizationId> {
}
