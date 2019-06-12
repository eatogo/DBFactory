package edu.ntut.eatogo.dbfactory.service.data;

import edu.ntut.eatogo.dbfactory.persistence.dao.DefaultDataDao;
import edu.ntut.eatogo.dbfactory.persistence.entity.Role;
import edu.ntut.eatogo.dbfactory.persistence.entity.RolePermission;
import edu.ntut.eatogo.dbfactory.persistence.repository.PermissionRepository;
import edu.ntut.eatogo.dbfactory.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolePermissionService {

    @Autowired
    private DefaultDataDao dataDao;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Transactional
    public void insertDefaultRolePermission() throws IOException {
        List<RolePermission> rolePermissions = dataDao.getDefaultRolePermission();
        List<Integer> roleIds = rolePermissions.stream().mapToInt(RolePermission::getRoleId).distinct().boxed().collect(Collectors.toList());
        List<Role> roles = roleRepository.findByRoleIdIn(roleIds);
        roles.forEach(role -> rolePermissions.stream()
                .filter(rolePermission -> rolePermission.getRoleId().equals(role.getRoleId()))
                .forEachOrdered(rolePermission -> role.addPermission(permissionRepository.getOne(rolePermission.getPermissionId()))));
        roleRepository.saveAll(roles);
    }
}
