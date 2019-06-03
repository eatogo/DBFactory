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
    private Integer review_user;
    @Column(nullable = false)
    private Integer review_order;
    private Integer review_food;
    @Column(nullable = false)
    private Date review_time;
    private String review_comment;

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }

    public Integer getReview_user() {
        return review_user;
    }

    public void setReview_user(Integer review_user) {
        this.review_user = review_user;
    }

    public Integer getReview_order() {
        return review_order;
    }

    public void setReview_order(Integer review_order) {
        this.review_order = review_order;
    }

    public Integer getReview_food() {
        return review_food;
    }

    public void setReview_food(Integer review_food) {
        this.review_food = review_food;
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
}
