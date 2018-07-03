package com.advance_jersey_app_3.app.jdbcConnection.Client;

import com.advance_jersey_app_3.app.jdbcConnection.models.Employee;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class testEmployeePost {

    public static void main(String args[]) {
        /*Client client = ClientBuilder.newClient();
        StoreOrder order = new StoreOrder(...);
        WebTarget myResource = client.target("http://example.com/webapi/write");
        TrackingNumber trackingNumber = myResource.request(MediaType.APPLICATION_XML)
        .post(Entity.xml(order), TrackingNumber.class);*/

        Client client = ClientBuilder.newClient();
        Employee employee = new Employee("chalana", "chalana@gmai.com", "0714846641", "24/2,dahammaavatha,binthenna", 23);
        WebTarget webTarget = client.target("http://localhost:8081/webapi/employees");


        try{
            System.out.println(webTarget
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(employee),String.class));
        }catch(Exception e) {
            System.out.println(e.getMessage());

        }





    }

}
