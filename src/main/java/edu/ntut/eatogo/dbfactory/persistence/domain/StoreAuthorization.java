package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "store_authorizations")
public class StoreAuthorization {

    @Id
    private Integer store_auth_id;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false, foreignKey = @ForeignKey(name = "FK_store_authorizations_stores"))
    private Store store;

    @ManyToOne
    @JoinColumn(name = "store_auth_user", nullable = false, foreignKey = @ForeignKey(name = "FK_store_authorizations_users"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_auth", nullable = false, foreignKey = @ForeignKey(name = "FK_store_authorizations_identities"))
    private Identity identity;

    public Integer getStore_auth_id() {
        return store_auth_id;
    }

    public void setStore_auth_id(Integer store_auth_id) {
        this.store_auth_id = store_auth_id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
}
