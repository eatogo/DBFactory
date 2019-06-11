package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;
    private String order_note;
    @Column(nullable = false)
    private Date order_time;
    private Date order_reserve_date;
    private Date order_confirm_time;
    @Column(columnDefinition = "VARCHAR(20) NOT NULL DEFAULT 'ordered'")
    private String order_status;
    private Date order_finished_time;

    @ManyToOne
    @JoinColumn(name = "order_user", nullable = false, foreignKey = @ForeignKey(name = "FK_orders_users"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_confirm_user", foreignKey = @ForeignKey(name = "FK_orders_confirm_users"))
    private User confirmUser;

    @ManyToOne
    @JoinColumn(name = "order_store", nullable = false, foreignKey = @ForeignKey(name = "FK_orders_stores"))
    private Store store;

    @ManyToOne
    @JoinColumn(name = "order_takeout_period", foreignKey = @ForeignKey(name = "FK_orders_periods"))
    private Period takeoutPeriod;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @OneToOne(mappedBy = "order")
    private Review review;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Date getOrder_reserve_date() {
        return order_reserve_date;
    }

    public void setOrder_reserve_date(Date order_reserve_date) {
        this.order_reserve_date = order_reserve_date;
    }

    public Date getOrder_confirm_time() {
        return order_confirm_time;
    }

    public void setOrder_confirm_time(Date order_confirm_time) {
        this.order_confirm_time = order_confirm_time;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Date getOrder_finished_time() {
        return order_finished_time;
    }

    public void setOrder_finished_time(Date order_finished_time) {
        this.order_finished_time = order_finished_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(User confirmUser) {
        this.confirmUser = confirmUser;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Period getTakeoutPeriod() {
        return takeoutPeriod;
    }

    public void setTakeoutPeriod(Period takeoutPeriod) {
        this.takeoutPeriod = takeoutPeriod;
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

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
