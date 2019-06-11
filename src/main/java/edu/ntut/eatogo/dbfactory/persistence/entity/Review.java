package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;
    @Column(name = "review_time", nullable = false)
    private Date reviewTime;
    @Column(name = "review_comment")
    private String reviewComment;

    @ManyToOne
    @JoinColumn(name = "review_user", nullable = false, foreignKey = @ForeignKey(name = "FK_reviews_users"))
    private User user;

    @OneToOne
    @JoinColumn(name = "review_order", nullable = false, foreignKey = @ForeignKey(name = "FK_reviews_orders"))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "review_food", foreignKey = @ForeignKey(name = "FK_reviews_foods"))
    private Food food;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
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
