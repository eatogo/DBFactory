package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer favorite_id;
    @Column(nullable = false)
    private Integer favorite_food;
    @Column(nullable = false)
    private Integer favorite_user;

    public Integer getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(Integer favorite_id) {
        this.favorite_id = favorite_id;
    }

    public Integer getFavorite_food() {
        return favorite_food;
    }

    public void setFavorite_food(Integer favorite_food) {
        this.favorite_food = favorite_food;
    }

    public Integer getFavorite_user() {
        return favorite_user;
    }

    public void setFavorite_user(Integer favorite_user) {
        this.favorite_user = favorite_user;
    }
}
