package com.advance_jersey_app_3.app.jdbcConnection.services;

import java.sql.SQLException;
import java.util.List;

import com.advance_jersey_app_3.app.jdbcConnection.DAO.EmployeeDAO;
import com.advance_jersey_app_3.app.jdbcConnection.models.Employee;

public class EmployeeService {
	
	EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException{
		return employeeDAO.getAllEmployees();
	}
	
	public Employee getEmployee(int emp_id) throws ClassNotFoundException, SQLException{
		return employeeDAO.getEmployee(emp_id);
	}
	
	public boolean setEmployee(Employee emp) throws ClassNotFoundException, SQLException{
		return employeeDAO.addEmployee(emp);
	}
	
	public int updateEmployee(Employee emp,int emp_id) throws ClassNotFoundException, SQLException{
		return employeeDAO.updateEmployee(emp,emp_id);
	}
	
	public int deleteEmployee(int emp_id) throws ClassNotFoundException, SQLException{
		return employeeDAO.deleteEmployee(emp_id);
	}

	public Employee getEmployeeFromName (String name) throws SQLException, ClassNotFoundException {
		return employeeDAO.getEmployeeFromName(name);
	}
}
