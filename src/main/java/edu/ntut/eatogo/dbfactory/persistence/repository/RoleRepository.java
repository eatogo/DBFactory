package edu.ntut.eatogo.dbfactory.persistence.repository;

import edu.ntut.eatogo.dbfactory.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByRoleIdIn(List<Integer> roleIds);
}
