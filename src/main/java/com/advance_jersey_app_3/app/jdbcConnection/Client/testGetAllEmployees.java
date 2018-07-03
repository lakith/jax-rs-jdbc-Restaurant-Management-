package com.advance_jersey_app_3.app.jdbcConnection.Client;

import com.advance_jersey_app_3.app.jdbcConnection.models.Employee;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class testGetAllEmployees {

    public static void main(String[] args)
    {
        List<Employee> employees  = new ArrayList<Employee>();

        try {

            Client client = ClientBuilder.newClient();

            employees = client.target("http://localhost:8081/webapi/employees")
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Employee>>(){});

            if (employees == null) {
                System.out.println("Employee list is null");
            } else {
                System.out.println(employees.getClass().getName());
                for(Employee emp : employees){
                    System.out.println(emp.getName());
                }
            }
        }
        catch (WebApplicationException e)
        {
            System.out.println(e);
        }
    }


}
