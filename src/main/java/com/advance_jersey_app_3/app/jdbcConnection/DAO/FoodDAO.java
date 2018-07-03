package com.advance_jersey_app_3.app.jdbcConnection.DAO;

import com.advance_jersey_app_3.app.jdbcConnection.DatabaseCon.DBConnection;
import com.advance_jersey_app_3.app.jdbcConnection.models.Food;
import com.advance_jersey_app_3.app.jdbcConnection.models.Orders;

import java.sql.*;

public class FoodDAO {


    public Food getFoodDetails (String meal, int price) throws SQLException, ClassNotFoundException {

        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        String sql = "Select * From food where available_meal = ? AND price = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setObject(1,meal);
        preparedStatement.setObject(2,price);
        ResultSet rst = preparedStatement.executeQuery();

        if(rst.next()){
            Food food = new Food(
                    rst.getString("food_name"),
                    rst.getString("available_meal"),
                    rst.getInt("price"),
                    rst.getString("ingrediants")
            );
            return food;
        } else {
            return null;
        }
    }

}
