package com.advance_jersey_app_3.app.jdbcConnection.DAO;

import com.advance_jersey_app_3.app.jdbcConnection.DatabaseCon.DBConnection;
import com.advance_jersey_app_3.app.jdbcConnection.models.Employee;
import com.advance_jersey_app_3.app.jdbcConnection.models.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {


    public List<Orders> getAllOrders(int emp_id) throws SQLException, ClassNotFoundException {

        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        String sql = "Select * From orders where employee = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setObject(1, emp_id);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<Orders> listOrders = new ArrayList<Orders>();

        while(rst.next())
        {
            Orders orders = new Orders(
                    rst.getString("orderName"),
                    rst.getString("contactNumber"),
                    rst.getString("location"),
                    rst.getString("customer")
            );
            listOrders.add(orders);
        }
        return  listOrders;

    }

    public Orders getOrder(int emp_id,int orderId) throws SQLException, ClassNotFoundException {

        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        String sql = "Select * FROM orders where employee = ? AND order_id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setObject(1,emp_id);
        preparedStatement.setObject(2,orderId);
        ResultSet rst = preparedStatement.executeQuery();

        if(rst.next()){
            Orders orders = new Orders(
                    rst.getString("orderName"),
                    rst.getString("contactNumber"),
                    rst.getString("location"),
                    rst.getString("customer")
            );
            return orders;
        }else   {
            return null;
        }

    }
}
