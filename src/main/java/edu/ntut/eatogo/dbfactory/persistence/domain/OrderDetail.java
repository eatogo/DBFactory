package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_detail_id;
    @Column(nullable = false)
    private Integer order_id;
    @Column(nullable = false)
    private Integer order_food;
    @Column(columnDefinition = "INT NOT NULL DEFAULT '1'")
    private Integer order_quantity;

    public Integer getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(Integer order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getOrder_food() {
        return order_food;
    }

    public void setOrder_food(Integer order_food) {
        this.order_food = order_food;
    }

    public Integer getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(Integer order_quantity) {
        this.order_quantity = order_quantity;
    }
}
