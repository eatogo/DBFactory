package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer food_id;
    @Column(nullable = false, length = 50)
    private String food_name;
    private Integer food_price;
    private String food_intro;
    private String food_pic_hdpi;
    private String food_pic_ldpi;
    private String food_pic_mdpi;
    private String food_pic;
    @Column(columnDefinition = "INT NOT NULL DEFAULT '1000'")
    private Integer food_limit;
    @Column(columnDefinition = "VARCHAR(20) NOT NULL DEFAULT 'logging'")
    private String food_status;

    @ManyToOne
    @JoinColumn(name = "food_type", nullable = false, foreignKey = @ForeignKey(name = "FK_foods_food_types"))
    private FoodType foodType;

    @ManyToOne
    @JoinColumn(name = "food_store", nullable = false, foreignKey = @ForeignKey(name = "FK_foods_stores"))
    private Store store;

    @OneToMany(mappedBy = "food")
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @OneToMany(mappedBy = "food")
    private Set<Favorite> favorites = new HashSet<>();

    @OneToMany(mappedBy = "food")
    private Set<Review> reviews = new HashSet<>();

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Integer getFood_price() {
        return food_price;
    }

    public void setFood_price(Integer food_price) {
        this.food_price = food_price;
    }

    public String getFood_intro() {
        return food_intro;
    }

    public void setFood_intro(String food_intro) {
        this.food_intro = food_intro;
    }

    public String getFood_pic_hdpi() {
        return food_pic_hdpi;
    }

    public void setFood_pic_hdpi(String food_pic_hdpi) {
        this.food_pic_hdpi = food_pic_hdpi;
    }

    public String getFood_pic_ldpi() {
        return food_pic_ldpi;
    }

    public void setFood_pic_ldpi(String food_pic_ldpi) {
        this.food_pic_ldpi = food_pic_ldpi;
    }

    public String getFood_pic_mdpi() {
        return food_pic_mdpi;
    }

    public void setFood_pic_mdpi(String food_pic_mdpi) {
        this.food_pic_mdpi = food_pic_mdpi;
    }

    public String getFood_pic() {
        return food_pic;
    }

    public void setFood_pic(String food_pic) {
        this.food_pic = food_pic;
    }

    public Integer getFood_limit() {
        return food_limit;
    }

    public void setFood_limit(Integer food_limit) {
        this.food_limit = food_limit;
    }

    public String getFood_status() {
        return food_status;
    }

    public void setFood_status(String food_status) {
        this.food_status = food_status;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
    }

    public void removeOrderDetail(OrderDetail orderDetail) {
        orderDetails.remove(orderDetail);
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }

    public void addFavorite(Favorite favorite) {
        favorites.add(favorite);
    }

    public void removeFavorite(Favorite favorite) {
        favorites.remove(favorite);
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReviews(Review review) {
        reviews.add(review);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
    }
}
