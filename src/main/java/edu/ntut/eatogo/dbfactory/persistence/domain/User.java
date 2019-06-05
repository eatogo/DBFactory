package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(nullable = false)
    private String user_password;
    @Column(nullable = false)
    private String user_cellphone;
    @Column(nullable = false)
    private String user_name;
    private String user_email;
    private String user_avatar;
    @Column(nullable = false)
    private Date user_create_time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_status", nullable = false, foreignKey = @ForeignKey(name = "FK_users_user_statuses"))
    private UserStatus userStatus;

    @OneToOne(mappedBy = "user")
    private Token token;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_users_users_roles"))},
            inverseJoinColumns = {@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_roles_users_roles"))}
    )
    private Set<Role> roles;

    @ManyToMany(mappedBy = "users")
    private Set<Store> stores;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    @OneToMany(mappedBy = "confirmUser")
    private Set<Order> confirmOrders;

    @OneToMany(mappedBy = "user")
    private Set<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_cellphone() {
        return user_cellphone;
    }

    public void setUser_cellphone(String user_cellphone) {
        this.user_cellphone = user_cellphone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public Date getUser_create_time() {
        return user_create_time;
    }

    public void setUser_create_time(Date user_create_time) {
        this.user_create_time = user_create_time;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Order> getConfirmOrders() {
        return confirmOrders;
    }

    public void setConfirmOrders(Set<Order> confirmOrders) {
        this.confirmOrders = confirmOrders;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @PrePersist
    public void prePersist() {
        if (userStatus == null) {
            userStatus = new UserStatus("unverified");
        }
    }
}
