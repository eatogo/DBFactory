package edu.ntut.eatogo.dbfactory.persistence.domain;

import edu.ntut.eatogo.dbfactory.persistence.domain.IdClass.StoreAuthorizationId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "store_authorizations")
@IdClass(StoreAuthorizationId.class)
public class StoreAuthorization {

    @Id
    private Integer store_auth_id;
    @Id
    private Integer store_auth_user;
    private String store_auth;

    public Integer getStore_auth_id() {
        return store_auth_id;
    }

    public void setStore_auth_id(Integer store_auth_id) {
        this.store_auth_id = store_auth_id;
    }

    public Integer getStore_auth_user() {
        return store_auth_user;
    }

    public void setStore_auth_user(Integer store_auth_user) {
        this.store_auth_user = store_auth_user;
    }

    public String getStore_auth() {
        return store_auth;
    }

    public void setStore_auth(String store_auth) {
        this.store_auth = store_auth;
    }
}
