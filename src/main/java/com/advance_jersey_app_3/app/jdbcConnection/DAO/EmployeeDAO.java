package com.advance_jersey_app_3.app.jdbcConnection.DAO;

import java.util.Collection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.transaction.Transactional;

import com.advance_jersey_app_3.app.jdbcConnection.DatabaseCon.DBConnection;
import com.advance_jersey_app_3.app.jdbcConnection.Redis.RedisImpl;
import com.advance_jersey_app_3.app.jdbcConnection.models.Employee;

public class EmployeeDAO {

	RedisImpl redis = new RedisImpl();

	@Transactional
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException
	{

		if(redis.checkData("employees"))
		{
			List<Employee> emmnew = new ArrayList<Employee>();
			emmnew.addAll((Collection<? extends Employee>) redis.getObjectValue("employees"));
			return  emmnew;
		}
		else {
			Connection conn = DBConnection.getDBConnection().getConnection();
			Statement stm = conn.createStatement();
			ResultSet rst = stm.executeQuery("Select * From employee");
			ArrayList<Employee> emp = new ArrayList<Employee>();
			redis.setRadies("employees",emp);

			while (rst.next()) {
				Employee employee = new Employee(rst.getString("name"), rst.getString("email"), rst.getString("tel_no"), rst.getString("Address"), rst.getInt("age"));
				emp.add(employee);
			}
			return emp;
		}
	}
	
	@Transactional
	public Employee getEmployee(int emp_id) throws ClassNotFoundException, SQLException{
		Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        String sql = "Select * From employee where emp_id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setObject(1, emp_id);
		ResultSet rst = preparedStatement.executeQuery();
		
		if(rst.next()){
			Employee emp = new Employee(rst.getString("name"),rst.getString("email"),rst.getString("tel_no"),rst.getString("Address"),rst.getInt("age"));
			return emp;
		}else{
			return null;
		}	
	}
	
	@Transactional
	public boolean addEmployee(Employee emp) throws SQLException, ClassNotFoundException{
		Connection conn=DBConnection.getDBConnection().getConnection();
		String sql = "Insert into employee (name,email,age,Address,tel_no)"
					 + " values (?,?,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setObject(1, emp.getName());
		preparedStatement.setObject(2, emp.getEmail());
		preparedStatement.setObject(3, emp.getAge());
		preparedStatement.setObject(4, emp.getAddress());
		preparedStatement.setObject(5, emp.getTel_no());
		return preparedStatement.execute();
	}
	
	@Transactional
	public int updateEmployee(Employee emp,int emp_id) throws ClassNotFoundException, SQLException{
		Connection conn=DBConnection.getDBConnection().getConnection();
		String sql = "Update employee set name = ?,email=?,age=?,Address=?,tel_no=? where emp_id=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setObject(1, emp.getName());
		preparedStatement.setObject(2, emp.getEmail());
		preparedStatement.setObject(3, emp.getAge());
		preparedStatement.setObject(4, emp.getAddress());
		preparedStatement.setObject(5, emp.getTel_no());
		preparedStatement.setObject(6, emp_id);
		return preparedStatement.executeUpdate();
	}
	
	@Transactional
	public int deleteEmployee(int emp_id) throws ClassNotFoundException, SQLException{
		Connection conn=DBConnection.getDBConnection().getConnection();
		String sql = "Delete From employee where emp_id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setObject(1, emp_id);
		return preparedStatement.executeUpdate();
	}

	@Transactional
	public Employee getEmployeeFromName(String name) throws SQLException, ClassNotFoundException {
		Connection conn = DBConnection.getDBConnection().getConnection();
		String sql = "Select * From employee where name= ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setObject(1,name);
		ResultSet rst = preparedStatement.executeQuery();

		if(rst.next()){
			Employee emp = new Employee(rst.getString("name"),rst.getString("email"),rst.getString("tel_no"),rst.getString("Address"),rst.getInt("age"));
			return emp;
		}else{
			return null;
		}
	}

}
