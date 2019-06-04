package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "authentications")
public class Authentication {

    @Id
    private Integer auth_id;
    @Column(nullable = false)
    private String user_uuid;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_authentications_users"))
    private User user;

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
    }

    public String getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
