package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "store_name", nullable = false)
    private String storeName;
    @Column(name = "store_address", nullable = false)
    private String storeAddress;
    @Column(name = "store_phone", nullable = false)
    private String storePhone;
    @Column(name = "store_email")
    private String storeEmail;
    @Column(name = "store_logo", columnDefinition = "VARCHAR(255) DEFAULT 'defaultStore.png'")
    private String storeLogo;
    @Column(name = "store_open_hour")
    private String storeOpenHour;
    @Column(name = "store_intro", columnDefinition = "TEXT")
    private String storeIntro;
    @Column(name = "store_latitude", nullable = false)
    private Double storeLatitude;
    @Column(name = "store_longitude", nullable = false)
    private Double storeLongitude;
    @Column(name = "store_status", columnDefinition = "VARCHAR(10) DEFAULT 'rest'")
    private String storeStatus;

    @ManyToOne
    @JoinColumn(name = "store_operate_type", nullable = false, foreignKey = @ForeignKey(name = "FK_stores_operate_types"))
    private OperateType operateType;

    @ManyToOne
    @JoinColumn(name = "store_area", nullable = false, foreignKey = @ForeignKey(name = "FK_stores_operate_areas"))
    private Area area;

    @ManyToMany
    @JoinTable(
            name = "stores_users",
            joinColumns = {@JoinColumn(name = "store_id", foreignKey = @ForeignKey(name = "FK_stores_stores_users"))},
            inverseJoinColumns = {@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_users_stores_users"))}
    )
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<Food> foods = new HashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<Order> orders = new HashSet<>();

    public Store() {
    }

    public Store(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreOpenHour() {
        return storeOpenHour;
    }

    public void setStoreOpenHour(String storeOpenHour) {
        this.storeOpenHour = storeOpenHour;
    }

    public String getStoreIntro() {
        return storeIntro;
    }

    public void setStoreIntro(String storeIntro) {
        this.storeIntro = storeIntro;
    }

    public Double getStoreLatitude() {
        return storeLatitude;
    }

    public void setStoreLatitude(Double storeLatitude) {
        this.storeLatitude = storeLatitude;
    }

    public Double getStoreLongitude() {
        return storeLongitude;
    }

    public void setStoreLongitude(Double storeLongitude) {
        this.storeLongitude = storeLongitude;
    }

    public String getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
