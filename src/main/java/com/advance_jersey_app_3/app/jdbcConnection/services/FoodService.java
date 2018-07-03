package com.advance_jersey_app_3.app.jdbcConnection.services;

import com.advance_jersey_app_3.app.jdbcConnection.DAO.FoodDAO;
import com.advance_jersey_app_3.app.jdbcConnection.models.Food;

import java.sql.SQLException;

public class FoodService {

    FoodDAO foodDAO = new FoodDAO();

    public Food getFoodDetails(String mealS,int price) throws SQLException, ClassNotFoundException {

        return foodDAO.getFoodDetails(mealS,price);
    }

}
