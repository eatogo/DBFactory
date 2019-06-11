package edu.ntut.eatogo.dbfactory.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food_types")
public class FoodType {

    @Id
    @Column(name = "food_type")
    private String foodType;
    @Column(name = "food_description", nullable = false, length = 50)
    private String foodDescription;

    @OneToMany(mappedBy = "foodType")
    private Set<Food> foods = new HashSet<>();

    public FoodType() {
    }

    public FoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }
}
