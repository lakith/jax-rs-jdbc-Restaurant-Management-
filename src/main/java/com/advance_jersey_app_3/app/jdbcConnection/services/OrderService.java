package com.advance_jersey_app_3.app.jdbcConnection.services;

import com.advance_jersey_app_3.app.jdbcConnection.DAO.OrdersDAO;
import com.advance_jersey_app_3.app.jdbcConnection.models.Orders;

import java.sql.SQLException;
import java.util.List;

public class OrderService {

    OrdersDAO ordersDAO = new OrdersDAO();

    public List<Orders> getAllOrders (int emp_id) throws SQLException, ClassNotFoundException {
        return ordersDAO.getAllOrders(emp_id);
    }

    public Orders getOrder(int emp_id,int orderId) throws SQLException, ClassNotFoundException {
        return ordersDAO.getOrder(emp_id,orderId);
    }

}
