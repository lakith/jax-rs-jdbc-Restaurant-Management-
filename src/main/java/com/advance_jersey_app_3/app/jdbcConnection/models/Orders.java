package com.advance_jersey_app_3.app.jdbcConnection.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Orders {

    @Id
    @GeneratedValue
    int orderID=0;
    String orderName;
    String contactNumber;
    String location;

    @ManyToMany
    String customer;


    public Orders() {
    }

    public Orders(String orderName, String contactNumber, String location, String customer) {
        this.orderName = orderName;
        this.contactNumber = contactNumber;
        this.location = location;
        this.customer = customer;
    }

    public Orders(int orderID, String orderName, String contactNumber, String location, String customer) {
        this.orderID = orderID;
        this.orderName = orderName;
        this.contactNumber = contactNumber;
        this.location = location;
        this.customer = customer;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getEmployeeHandle() {
        return contactNumber;
    }

    public void setEmployeeHandle(String employeeHandle) {
        this.contactNumber = employeeHandle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
