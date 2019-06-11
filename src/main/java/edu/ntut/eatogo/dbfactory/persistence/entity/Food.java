package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Integer foodId;
    @Column(name = "food_name", nullable = false, length = 50)
    private String foodName;
    @Column(name = "food_price")
    private Integer foodPrice;
    @Column(name = "food_intro")
    private String foodIntro;
    @Column(name = "food_pic_hdpi")
    private String foodPicHdpi;
    @Column(name = "food_pic_ldpi")
    private String foodPicLdpi;
    @Column(name = "food_pic_mdpi")
    private String foodPicMdpi;
    @Column(name = "food_pic")
    private String foodPic;
    @Column(name = "food_limit", columnDefinition = "INT NOT NULL DEFAULT '1000'")
    private Integer foodLimit;
    @Column(name = "food_status", columnDefinition = "VARCHAR(20) NOT NULL DEFAULT 'logging'")
    private String foodStatus;

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

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Integer foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodIntro() {
        return foodIntro;
    }

    public void setFoodIntro(String foodIntro) {
        this.foodIntro = foodIntro;
    }

    public String getFoodPicHdpi() {
        return foodPicHdpi;
    }

    public void setFoodPicHdpi(String foodPicHdpi) {
        this.foodPicHdpi = foodPicHdpi;
    }

    public String getFoodPicLdpi() {
        return foodPicLdpi;
    }

    public void setFoodPicLdpi(String foodPicLdpi) {
        this.foodPicLdpi = foodPicLdpi;
    }

    public String getFoodPicMdpi() {
        return foodPicMdpi;
    }

    public void setFoodPicMdpi(String foodPicMdpi) {
        this.foodPicMdpi = foodPicMdpi;
    }

    public String getFoodPic() {
        return foodPic;
    }

    public void setFoodPic(String foodPic) {
        this.foodPic = foodPic;
    }

    public Integer getFoodLimit() {
        return foodLimit;
    }

    public void setFoodLimit(Integer foodLimit) {
        this.foodLimit = foodLimit;
    }

    public String getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(String foodStatus) {
        this.foodStatus = foodStatus;
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
