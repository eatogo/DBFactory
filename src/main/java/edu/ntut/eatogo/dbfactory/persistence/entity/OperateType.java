package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "operate_types")
public class OperateType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operate_type_id")
    private Integer operateTypeId;
    @Column(name = "operate_type")
    private String operateType;
    @Column(name = "operate_type_description")
    private String operateTypeDescription;

    @ManyToMany
    @JoinTable(
            name = "operate_types_periods",
            joinColumns = {@JoinColumn(name = "operate_type_id", foreignKey = @ForeignKey(name = "FK_operate_types_operate_types_periods"))},
            inverseJoinColumns = {@JoinColumn(name = "period_id", foreignKey = @ForeignKey(name = "FK_periods_operate_types_periods"))}
    )
    private Set<Period> periods = new HashSet<>();

    @OneToMany(mappedBy = "operateType")
    private Set<Store> stores = new HashSet<>();

    public OperateType() {
    }

    public OperateType(String operateType) {
        this.operateType = operateType;
    }

    public Integer getOperateTypeId() {
        return operateTypeId;
    }

    public void setOperateTypeId(Integer operateTypeId) {
        this.operateTypeId = operateTypeId;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperateTypeDescription() {
        return operateTypeDescription;
    }

    public void setOperateTypeDescription(String operateTypeDescription) {
        this.operateTypeDescription = operateTypeDescription;
    }

    public Set<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(Set<Period> periods) {
        this.periods = periods;
    }

    public void addPeriod(Period period) {
        periods.add(period);
    }

    public void removePeriod(Period period) {
        periods.remove(period);
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void removeStore(Store store) {
        stores.remove(store);
    }
}
