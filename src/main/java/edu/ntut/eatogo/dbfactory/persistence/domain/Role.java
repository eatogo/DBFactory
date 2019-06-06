package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    private String role_name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = {@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_roles_roles_permissions"))},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", foreignKey = @ForeignKey(name = "FK_permissions_roles_permissions"))}
    )
    private Set<Permission> permissions;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
