package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "periods")
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer period_id;
    private String period;
    @Column(columnDefinition = "TIME NOT NULL")
    private Timestamp period_start;
    @Column(columnDefinition = "TIME NOT NULL")
    private Timestamp period_end;

    @OneToMany(mappedBy = "takeoutPeriod")
    private Set<Order> orders = new HashSet<>();

    public Integer getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(Integer period_id) {
        this.period_id = period_id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Timestamp getPeriod_start() {
        return period_start;
    }

    public void setPeriod_start(Timestamp period_start) {
        this.period_start = period_start;
    }

    public Timestamp getPeriod_end() {
        return period_end;
    }

    public void setPeriod_end(Timestamp period_end) {
        this.period_end = period_end;
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
