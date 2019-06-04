package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "periods")
public class Period {

    @Id
    private String period_id;
    private String period_description;
    @Column(columnDefinition = "TIME NOT NULL")
    private Timestamp period_start;
    @Column(columnDefinition = "TIME NOT NULL")
    private Timestamp period_end;

    @OneToMany(mappedBy = "takeoutPeriod")
    private Set<Order> orders;

    public String getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(String period_id) {
        this.period_id = period_id;
    }

    public String getPeriod_description() {
        return period_description;
    }

    public void setPeriod_description(String period_description) {
        this.period_description = period_description;
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
}