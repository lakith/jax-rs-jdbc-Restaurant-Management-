package com.advance_jersey_app_3.app.jdbcConnection.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int emp_id=0;
	
	@Column
	String name;

	@Column
	String email;
	
	@Column
	String tel_no;
	
	@Column
	String Address;

	@Column
	int age;
	
	
	
	
	public Employee() {
		
	}
	
	public Employee(String name, String email, String tel_no, String address,
			int age) {
		
		this.name = name;
		this.email = email;
		this.tel_no = tel_no;
		Address = address;
		this.age = age;
	}
	public Employee(String name, String email, String tel_no, String address,
			int age, int emp_id) {
		
		this.name = name;
		this.email = email;
		this.tel_no = tel_no;
		Address = address;
		this.age = age;
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"emp_id=" + emp_id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", tel_no='" + tel_no + '\'' +
				", Address='" + Address + '\'' +
				", age=" + age +
				'}';
	}
}
