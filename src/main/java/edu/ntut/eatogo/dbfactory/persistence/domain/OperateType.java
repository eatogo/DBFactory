package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "operate_types")
public class OperateType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operate_type_id;
    private String operate_type;
    private String operate_type_description;

    @ManyToMany
    @JoinTable(
            name = "operate_types_periods",
            joinColumns = {@JoinColumn(name = "operate_type_id", foreignKey = @ForeignKey(name = "FK_operate_types_operate_types_periods"))},
            inverseJoinColumns = {@JoinColumn(name = "period_id", foreignKey = @ForeignKey(name = "FK_periods_operate_types_periods"))}
    )
    private Set<Period> periods;

    @OneToMany(mappedBy = "operateType")
    private Set<Store> stores;

    public OperateType() {
    }

    public OperateType(String operate_type) {
        this.operate_type = operate_type;
    }

    public Integer getOperate_type_id() {
        return operate_type_id;
    }

    public void setOperate_type_id(Integer operate_type_id) {
        this.operate_type_id = operate_type_id;
    }

    public String getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(String operate_type) {
        this.operate_type = operate_type;
    }

    public String getOperate_type_description() {
        return operate_type_description;
    }

    public void setOperate_type_description(String operate_type_description) {
        this.operate_type_description = operate_type_description;
    }

    public Set<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(Set<Period> periods) {
        this.periods = periods;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }
}
