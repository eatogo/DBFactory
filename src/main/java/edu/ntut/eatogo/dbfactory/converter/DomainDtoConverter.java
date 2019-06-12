package edu.ntut.eatogo.dbfactory.converter;

import edu.ntut.eatogo.dbfactory.dto.*;
import edu.ntut.eatogo.dbfactory.persistence.entity.*;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class DomainDtoConverter {

    public AreaDto convertToDto(Area area) {
        AreaDto dto = new AreaDto();
        dto.setAreaId(area.getAreaId());
        dto.setAreaDescription(area.getAreaDescription());
        dto.setAreaCity(area.getAreaCity());
        return dto;
    }

    public FoodTypeDto convertToDto(FoodType foodType) {
        FoodTypeDto dto = new FoodTypeDto();
        dto.setFoodType(foodType.getFoodType());
        dto.setFoodDescription(foodType.getFoodDescription());
        return dto;
    }

    public OperateTypeDto convertToDto(OperateType operateType) {
        OperateTypeDto dto = new OperateTypeDto();
        dto.setOperateTypeId(operateType.getOperateTypeId());
        dto.setOperateType(operateType.getOperateType());
        dto.setOperateTypeDescription(operateType.getOperateTypeDescription());
        return dto;
    }

    public PeriodDto convertToDto(Period period) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        PeriodDto dto = new PeriodDto();
        dto.setPeriodId(period.getPeriodId());
        dto.setPeriod(period.getPeriod());
        dto.setPeriodStart(period.getPeriodStart().toString());
        dto.setPeriodEnd(period.getPeriodEnd().format(formatter));
        return dto;
    }

    public PermissionDto convertToDto(Permission permission) {
        PermissionDto dto = new PermissionDto();
        dto.setPermissionId(permission.getPermissionId());
        dto.setPermission(permission.getPermission());
        return dto;
    }

    public RoleDto convertToDto(Role role) {
        RoleDto dto = new RoleDto();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());
        return dto;
    }

    public UserStatusDto convertToDto(UserStatus userStatus) {
        UserStatusDto dto = new UserStatusDto();
        dto.setStatusType(userStatus.getStatusType());
        dto.setStatusDescription(userStatus.getStatusDescription());
        return dto;
    }

    public StoreDto convertToDto(Store store) {
        StoreDto dto = new StoreDto();
        Optional.ofNullable(store.getStoreId()).ifPresent(dto::setStoreId);
        Optional.ofNullable(store.getStoreName()).ifPresent(dto::setStoreName);
        Optional.ofNullable(store.getStorePhone()).ifPresent(dto::setStorePhone);
        Optional.ofNullable(store.getStoreAddress()).ifPresent(dto::setStoreAddress);
        Optional.ofNullable(store.getStoreEmail()).ifPresent(dto::setStoreEmail);
        Optional.ofNullable(store.getStoreLogo()).ifPresent(dto::setStoreLogo);
        Optional.ofNullable(store.getStoreOpenHour()).ifPresent(dto::setStoreOpenHour);
        Optional.ofNullable(store.getStoreIntro()).ifPresent(dto::setStoreIntro);
        Optional.ofNullable(store.getStoreLatitude()).ifPresent(dto::setStoreLatitude);
        Optional.ofNullable(store.getStoreLongitude()).ifPresent(dto::setStoreLongitude);
        Optional.ofNullable(store.getStoreStatus()).ifPresent(dto::setStoreStatus);
        Optional.ofNullable(store.getArea()).ifPresent(area -> {
            Optional.ofNullable(area.getAreaId()).ifPresent(dto::setStoreAreaId);
            Optional.ofNullable(area.getAreaDescription()).ifPresent(dto::setStoreAreaDescription);
            Optional.ofNullable(area.getAreaCity()).ifPresent(dto::setStoreAreaCity);
        });
        return dto;
    }

    public Store convertToDomain(StoreDto dto) {
        Store store = new Store();
        Optional.ofNullable(dto.getStoreId()).ifPresent(store::setStoreId);
        Optional.ofNullable(dto.getStoreName()).ifPresent(store::setStoreName);
        Optional.ofNullable(dto.getStorePhone()).ifPresent(store::setStorePhone);
        Optional.ofNullable(dto.getStoreAddress()).ifPresent(store::setStoreAddress);
        Optional.ofNullable(dto.getStoreEmail()).ifPresent(store::setStoreEmail);
        Optional.ofNullable(dto.getStoreLogo()).ifPresent(store::setStoreLogo);
        Optional.ofNullable(dto.getStoreOpenHour()).ifPresent(store::setStoreOpenHour);
        Optional.ofNullable(dto.getStoreIntro()).ifPresent(store::setStoreIntro);
        Optional.ofNullable(dto.getStoreLatitude()).ifPresent(store::setStoreLatitude);
        Optional.ofNullable(dto.getStoreLongitude()).ifPresent(store::setStoreLongitude);
        Optional.ofNullable(dto.getStoreStatus()).ifPresent(store::setStoreStatus);
        Area storeArea = new Area();
        Optional.ofNullable(dto.getStoreAreaId()).ifPresent(storeArea::setAreaId);
        Optional.ofNullable(dto.getStoreAreaDescription()).ifPresent(storeArea::setAreaDescription);
        Optional.ofNullable(dto.getStoreAreaCity()).ifPresent(storeArea::setAreaCity);
        store.setArea(storeArea);
        return store;
    }
}
