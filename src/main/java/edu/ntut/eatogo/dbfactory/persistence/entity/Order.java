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
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_note")
    private String orderNote;
    @Column(name = "order_time", nullable = false)
    private Date orderTime;
    @Column(name = "order_reserve_date")
    private Date orderReserveDate;
    @Column(name = "order_confirm_time")
    private Date orderConfirmTime;
    @Column(name = "order_status", columnDefinition = "VARCHAR(20) NOT NULL DEFAULT 'ordered'")
    private String orderStatus;
    @Column(name = "order_finished_time")
    private Date orderFinishedTime;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderReserveDate() {
        return orderReserveDate;
    }

    public void setOrderReserveDate(Date orderReserveDate) {
        this.orderReserveDate = orderReserveDate;
    }

    public Date getOrderConfirmTime() {
        return orderConfirmTime;
    }

    public void setOrderConfirmTime(Date orderConfirmTime) {
        this.orderConfirmTime = orderConfirmTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderFinishedTime() {
        return orderFinishedTime;
    }

    public void setOrderFinishedTime(Date orderFinishedTime) {
        this.orderFinishedTime = orderFinishedTime;
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
