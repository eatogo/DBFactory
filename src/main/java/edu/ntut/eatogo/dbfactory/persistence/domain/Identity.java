package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "identities")
public class Identity {

    @Id
    private String identity_type;
    @Column(nullable = false)
    private String identity_description;

    @OneToMany(mappedBy = "identity")
    private Set<StoreAuthorization> storeAuthorizations;

    public String getIdentity_type() {
        return identity_type;
    }

    public void setIdentity_type(String identity_type) {
        this.identity_type = identity_type;
    }

    public String getIdentity_description() {
        return identity_description;
    }

    public void setIdentity_description(String identity_description) {
        this.identity_description = identity_description;
    }

    public Set<StoreAuthorization> getStoreAuthorizations() {
        return storeAuthorizations;
    }

    public void setStoreAuthorizations(Set<StoreAuthorization> storeAuthorizations) {
        this.storeAuthorizations = storeAuthorizations;
    }
}
