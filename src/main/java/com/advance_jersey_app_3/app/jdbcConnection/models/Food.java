package com.advance_jersey_app_3.app.jdbcConnection.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Food {


    private int food_id;
    private String food_name;
    private String available_meal;
    private int price;
    private String ingrediants;

    public Food() {
    }

    public Food(String food_name, String available_meal, int price, String ingrediants) {
        this.food_name = food_name;
        this.available_meal = available_meal;
        this.price = price;
        this.ingrediants = ingrediants;
    }

    public Food(int food_id, String food_name, String available_meal, int price, String ingrediants) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.available_meal = available_meal;
        this.price = price;
        this.ingrediants = ingrediants;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getAvailable_meal() {
        return available_meal;
    }

    public void setAvailable_meal(String available_meal) {
        this.available_meal = available_meal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIngrediants() {
        return ingrediants;
    }

    public void setIngrediants(String ingrediants) {
        this.ingrediants = ingrediants;
    }
}
