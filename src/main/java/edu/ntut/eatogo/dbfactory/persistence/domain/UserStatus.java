package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_statuses")
public class UserStatus {

    @Id
    private String status_type;
    @Column(nullable = false)
    private String status_description;

    @OneToMany(mappedBy = "userStatus")
    private Set<User> users;

    public UserStatus() {
    }

    public UserStatus(String status_type) {
        this.status_type = status_type;
    }

    public String getStatus_type() {
        return status_type;
    }

    public void setStatus_type(String status_type) {
        this.status_type = status_type;
    }

    public String getStatus_description() {
        return status_description;
    }

    public void setStatus_description(String status_description) {
        this.status_description = status_description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
