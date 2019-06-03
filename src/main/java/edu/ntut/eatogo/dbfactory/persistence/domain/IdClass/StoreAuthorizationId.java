package edu.ntut.eatogo.dbfactory.persistence.domain.IdClass;

import java.io.Serializable;
import java.util.Objects;

public class StoreAuthorizationId implements Serializable {

    private static final long serialVersionUID = -1150748296324106430L;
    private Integer store_auth_id;
    private Integer store_auth_user;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreAuthorizationId that = (StoreAuthorizationId) o;
        return Objects.equals(store_auth_id, that.store_auth_id) &&
                Objects.equals(store_auth_user, that.store_auth_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(store_auth_id, store_auth_user);
    }
}
