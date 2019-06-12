package edu.ntut.eatogo.dbfactory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreDto implements Serializable {

    private static final long serialVersionUID = -1903748889505027540L;
    private Integer storeId;
    private String storeName;
    private String storeAddress;
    private String storePhone;
    private String storeEmail;
    private String storeLogo;
    private String storeOpenHour;
    private String storeIntro;
    private Double storeLatitude;
    private Double storeLongitude;
    private String storeStatus;
    private Integer storeAreaId;
    private String storeAreaDescription;
    private String storeAreaCity;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreOpenHour() {
        return storeOpenHour;
    }

    public void setStoreOpenHour(String storeOpenHour) {
        this.storeOpenHour = storeOpenHour;
    }

    public String getStoreIntro() {
        return storeIntro;
    }

    public void setStoreIntro(String storeIntro) {
        this.storeIntro = storeIntro;
    }

    public Double getStoreLatitude() {
        return storeLatitude;
    }

    public void setStoreLatitude(Double storeLatitude) {
        this.storeLatitude = storeLatitude;
    }

    public Double getStoreLongitude() {
        return storeLongitude;
    }

    public void setStoreLongitude(Double storeLongitude) {
        this.storeLongitude = storeLongitude;
    }

    public String getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
    }

    public Integer getStoreAreaId() {
        return storeAreaId;
    }

    public void setStoreAreaId(Integer storeAreaId) {
        this.storeAreaId = storeAreaId;
    }

    public String getStoreAreaDescription() {
        return storeAreaDescription;
    }

    public void setStoreAreaDescription(String storeAreaDescription) {
        this.storeAreaDescription = storeAreaDescription;
    }

    public String getStoreAreaCity() {
        return storeAreaCity;
    }

    public void setStoreAreaCity(String storeAreaCity) {
        this.storeAreaCity = storeAreaCity;
    }
}
