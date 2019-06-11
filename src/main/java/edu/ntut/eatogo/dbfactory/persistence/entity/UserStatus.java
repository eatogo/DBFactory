package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_statuses")
public class UserStatus {

    @Id
    @Column(name = "status_type")
    private String statusType;
    @Column(name = "status_description", nullable = false)
    private String statusDescription;

    @OneToMany(mappedBy = "userStatus")
    private Set<User> users = new HashSet<>();

    public UserStatus() {
    }

    public UserStatus(String statusType) {
        this.statusType = statusType;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
