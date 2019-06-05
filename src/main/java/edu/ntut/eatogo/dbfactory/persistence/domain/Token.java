package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    private Integer user_id;
    @Column(nullable = false)
    private String token;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "FK_tokens_users"))
    private User user;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
