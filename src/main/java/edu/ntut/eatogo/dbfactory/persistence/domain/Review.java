package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer review_id;
    @Column(nullable = false)
    private Date review_time;
    private String review_comment;

    @ManyToOne
    @JoinColumn(name = "review_user", nullable = false, foreignKey = @ForeignKey(name = "FK_reviews_users"))
    private User user;

    @OneToOne
    @JoinColumn(name = "review_order", nullable = false, foreignKey = @ForeignKey(name = "FK_reviews_orders"))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "review_food", foreignKey = @ForeignKey(name = "FK_reviews_foods"))
    private Food food;

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }

    public Date getReview_time() {
        return review_time;
    }

    public void setReview_time(Date review_time) {
        this.review_time = review_time;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
