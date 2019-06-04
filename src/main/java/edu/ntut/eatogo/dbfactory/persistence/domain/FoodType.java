package edu.ntut.eatogo.dbfactory.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "food_types")
public class FoodType {

    @Id
    private String food_type;
    @Column(nullable = false, length = 50)
    private String food_description;

    @OneToMany(mappedBy = "foodType")
    private Set<Food> foods;

    public FoodType() {
    }

    public FoodType(String food_type) {
        this.food_type = food_type;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getFood_description() {
        return food_description;
    }

    public void setFood_description(String food_description) {
        this.food_description = food_description;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
}
