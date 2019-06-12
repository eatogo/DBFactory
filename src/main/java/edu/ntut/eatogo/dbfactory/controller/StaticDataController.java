package edu.ntut.eatogo.dbfactory.controller;

import edu.ntut.eatogo.dbfactory.service.data.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("data")
public class StaticDataController {

    @Autowired
    private AreaService areaService;

    @PostMapping("area/default")
    public ResponseEntity<?> insertDefaultArea() throws IOException {
        areaService.insertDefaultArea();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("area/all")
    public ResponseEntity<?> getAreas() {
        return ResponseEntity.ok(areaService.getAreas());
    }

    @Autowired
    private FoodTypeService foodTypeService;

    @PostMapping("foodType/default")
    public ResponseEntity<?> insertDefaultFoodType() throws IOException {
        foodTypeService.insertDefaultFoodType();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("foodType/all")
    public ResponseEntity<?> getFoodTypes() {
        return ResponseEntity.ok(foodTypeService.getFoodTypes());
    }

    @Autowired
    private PeriodService periodService;

    @PostMapping("period/default")
    public ResponseEntity<?> insertDefaultPeriod() throws IOException {
        periodService.insertDefaultPeriod();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("period/all")
    public ResponseEntity<?> getPeriods() {
        return ResponseEntity.ok(periodService.getPeriods());
    }

    @Autowired
    private OperateTypeService operateTypeService;

    @PostMapping("operateType/default")
    public ResponseEntity<?> insertDefaultOperateType() throws IOException {
        operateTypeService.insertDefaultOperateType();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("operateType/all")
    public ResponseEntity<?> getOperateTypes() {
        return ResponseEntity.ok(operateTypeService.getOperateTypes());
    }

    @Autowired
    private OperateTypePeriodService operateTypePeriodService;

    @ApiOperation(value = "", notes = "Must populate operate type and period first.")
    @PostMapping("operateTypePeriod/default")
    public ResponseEntity<?> insertDefaultOperateTypePeriod() throws IOException {
        operateTypePeriodService.insertDefaultOperateTypePeriod();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Autowired
    private RoleService roleService;

    @PostMapping("role/default")
    public ResponseEntity<?> insertDefaultRole() throws IOException {
        roleService.insertDefaultRole();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("role/all")
    public ResponseEntity<?> getRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }

    @Autowired
    private PermissionService permissionService;

    @PostMapping("permission/default")
    public ResponseEntity<?> insertDefaultPermission() throws IOException {
        permissionService.insertDefaultPermission();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("permission/all")
    public ResponseEntity<?> getPermissions() {
        return ResponseEntity.ok(permissionService.getPermissions());
    }

    @Autowired
    private RolePermissionService rolePermissionService;

    @ApiOperation(value = "", notes = "Must populate role and permission first.")
    @PostMapping("rolePermission/default")
    public ResponseEntity<?> insertDefaultRolePermission() throws IOException {
        rolePermissionService.insertDefaultRolePermission();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Autowired
    private UserStatusService userStatusService;

    @PostMapping("userStatus/default")
    public ResponseEntity<?> insertDefaultUserStatus() throws IOException {
        userStatusService.insertDefaultUserStatus();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("userStatus/all")
    public ResponseEntity<?> getUserStatuses() {
        return ResponseEntity.ok(userStatusService.getUserStatuses());
    }

    @Autowired
    private StoreService storeService;

    @ApiOperation(value = "", notes = "Must populate operate type and area first.")
    @PostMapping("store/default")
    public ResponseEntity<?> insertDefaultStore() throws IOException {
        storeService.insertDefaultStore();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("store/all")
    public ResponseEntity<?> getUserStores() {
        return ResponseEntity.ok(storeService.getStores());
    }
}
