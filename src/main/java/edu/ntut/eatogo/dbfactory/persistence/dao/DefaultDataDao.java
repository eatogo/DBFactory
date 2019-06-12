package edu.ntut.eatogo.dbfactory.persistence.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import edu.ntut.eatogo.dbfactory.dto.StoreDto;
import edu.ntut.eatogo.dbfactory.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class DefaultDataDao {

    @Autowired
    private ObjectMapper mapper;

    public List<Area> getDefaultArea() throws IOException {
        return mapper.readValue(
                getReader("/static/default_area.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, Area.class));
    }

    public List<FoodType> getDefaultFoodType() throws IOException {
        return mapper.readValue(
                getReader("/static/default_food_type.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, FoodType.class));
    }

    public List<OperateType> getDefaultOperateType() throws IOException {
        return mapper.readValue(
                getReader("/static/default_operate_type.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, OperateType.class));
    }

    public List<Period> getDefaultPeriod() throws IOException {
        return mapper.readValue(
                getReader("/static/default_period.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, Period.class));
    }

    public List<Permission> getDefaultPermission() throws IOException {
        return mapper.readValue(
                getReader("/static/default_permission.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, Permission.class));
    }

    public List<Role> getDefaultRole() throws IOException {
        return mapper.readValue(
                getReader("/static/default_role.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, Role.class));
    }

    public List<OperateTypePeriod> getDefaultOperateTypePeriod() throws IOException {
        return mapper.readValue(
                getReader("/static/default_operate_type_period.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, OperateTypePeriod.class));
    }

    public List<RolePermission> getDefaultRolePermission() throws IOException {
        return mapper.readValue(
                getReader("/static/default_role_permission.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, RolePermission.class));
    }

    public List<UserStatus> getDefaultUserStatus() throws IOException {
        return mapper.readValue(
                getReader("/static/default_user_status.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, UserStatus.class));
    }

    public List<StoreDto> getDefaultStore() throws IOException {
        return Lists.newArrayList(Iterables.concat(getDefaultTaipeiCityStore(), getDefaultNewTaipeiCityStore()));
    }

    private List<StoreDto> getDefaultNewTaipeiCityStore() throws IOException {
        return mapper.readValue(
                getReader("/static/2017_new_taipei_city_stores.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, StoreDto.class));
    }

    private List<StoreDto> getDefaultTaipeiCityStore() throws IOException {
        return mapper.readValue(
                getReader("/static/2017_taipei_city_stores.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, StoreDto.class));
    }

    private InputStreamReader getReader(String resourceLocation) {
        InputStream inputStream = this.getClass().getResourceAsStream(resourceLocation);
        return new InputStreamReader(inputStream);
    }
}
