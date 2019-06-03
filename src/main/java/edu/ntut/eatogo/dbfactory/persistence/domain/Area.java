package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "areas")
public class Area {

    @Id
    private Integer area_id;
    @Column(nullable = false, length = 50)
    private String area_description;
    @Column(nullable = false, length = 50)
    private String area_city;

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getArea_description() {
        return area_description;
    }

    public void setArea_description(String area_description) {
        this.area_description = area_description;
    }

    public String getArea_city() {
        return area_city;
    }

    public void setArea_city(String area_city) {
        this.area_city = area_city;
    }
}
