package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private Integer favoriteId;

    @ManyToOne
    @JoinColumn(name = "favorite_food", nullable = false, foreignKey = @ForeignKey(name = "FK_favorites_foods"))
    private Food food;

    @ManyToOne
    @JoinColumn(name = "favorite_user", nullable = false, foreignKey = @ForeignKey(name = "FK_favorites_users"))
    private User user;

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
