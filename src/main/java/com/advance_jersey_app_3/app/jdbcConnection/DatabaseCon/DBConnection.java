package com.advance_jersey_app_3.app.jdbcConnection.DatabaseCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	Connection conn;
	private static DBConnection dbConnection;
	
	private DBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/resturent", "root", "");//"phpmyadmin", "some_pass"
	}
	
	public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException {
        if(dbConnection==null){
        	dbConnection=new DBConnection();
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return conn;
    }

}
