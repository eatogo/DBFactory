package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "periods")
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "period_id")
    private Integer periodId;
    private String period;
    @Column(name = "period_start", columnDefinition = "TIME NOT NULL")
    private LocalTime periodStart;
    @Column(name = "period_end", columnDefinition = "TIME NOT NULL")
    private LocalTime periodEnd;

    @OneToMany(mappedBy = "takeoutPeriod")
    private Set<Order> orders = new HashSet<>();

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public LocalTime getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalTime periodStart) {
        this.periodStart = periodStart;
    }

    public LocalTime getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(LocalTime periodEnd) {
        this.periodEnd = periodEnd;
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
