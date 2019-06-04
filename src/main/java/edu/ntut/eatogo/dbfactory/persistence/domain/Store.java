package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer store_id;
    @Column(nullable = false)
    private String store_name;
    @Column(nullable = false)
    private String store_address;
    @Column(nullable = false)
    private String store_phone;
    private String store_email;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL DEFAULT 'defaultStore.png'")
    private String store_logo;
    private String store_open_hour;
    private String store_intro;
    @Column(nullable = false)
    private Double store_latitude;
    @Column(nullable = false)
    private Double store_longitude;
    @Column(columnDefinition = "VARCHAR(10) NOT NULL DEFAULT 'rest'")
    private String store_status;

    @ManyToOne
    @JoinColumn(name = "store_operate_type", nullable = false, foreignKey = @ForeignKey(name = "FK_stores_operate_types"))
    private OperateType operateType;

    @ManyToOne
    @JoinColumn(name = "store_area", nullable = false, foreignKey = @ForeignKey(name = "FK_stores_operate_areas"))
    private Area area;

    @OneToMany(mappedBy = "store")
    private Set<StoreAuthorization> storeAuthorizations;

    @OneToMany(mappedBy = "store")
    private Set<Food> foods;

    @OneToMany(mappedBy = "store")
    private Set<Order> orders;

    public Store() {
    }

    public Store(Integer store_id) {
        this.store_id = store_id;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public String getStore_phone() {
        return store_phone;
    }

    public void setStore_phone(String store_phone) {
        this.store_phone = store_phone;
    }

    public String getStore_email() {
        return store_email;
    }

    public void setStore_email(String store_email) {
        this.store_email = store_email;
    }

    public String getStore_logo() {
        return store_logo;
    }

    public void setStore_logo(String store_logo) {
        this.store_logo = store_logo;
    }

    public String getStore_open_hour() {
        return store_open_hour;
    }

    public void setStore_open_hour(String store_open_hour) {
        this.store_open_hour = store_open_hour;
    }

    public String getStore_intro() {
        return store_intro;
    }

    public void setStore_intro(String store_intro) {
        this.store_intro = store_intro;
    }

    public Double getStore_latitude() {
        return store_latitude;
    }

    public void setStore_latitude(Double store_latitude) {
        this.store_latitude = store_latitude;
    }

    public Double getStore_longitude() {
        return store_longitude;
    }

    public void setStore_longitude(Double store_longitude) {
        this.store_longitude = store_longitude;
    }

    public String getStore_status() {
        return store_status;
    }

    public void setStore_status(String store_status) {
        this.store_status = store_status;
    }

    public OperateType getOperateType() {
        return operateType;
    }

    public void setOperateType(OperateType operateType) {
        this.operateType = operateType;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Set<StoreAuthorization> getStoreAuthorizations() {
        return storeAuthorizations;
    }

    public void setStoreAuthorizations(Set<StoreAuthorization> storeAuthorizations) {
        this.storeAuthorizations = storeAuthorizations;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @PrePersist
    public void prePersist() {
        if (operateType == null) {
            operateType = new OperateType("wholeday");
        }
    }
}
