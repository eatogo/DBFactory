package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer favorite_id;

    @ManyToOne
    @JoinColumn(name = "favorite_food", nullable = false, foreignKey = @ForeignKey(name = "FK_favorites_foods"))
    private Food food;

    @ManyToOne
    @JoinColumn(name = "favorite_user", nullable = false, foreignKey = @ForeignKey(name = "FK_favorites_users"))
    private User user;

    public Integer getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(Integer favorite_id) {
        this.favorite_id = favorite_id;
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
