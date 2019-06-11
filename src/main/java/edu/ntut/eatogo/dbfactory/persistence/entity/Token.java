package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(nullable = false)
    private String token;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "FK_tokens_users"))
    private User user;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
