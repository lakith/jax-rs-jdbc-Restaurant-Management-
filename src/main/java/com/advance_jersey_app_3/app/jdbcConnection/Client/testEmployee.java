package com.advance_jersey_app_3.app.jdbcConnection.Client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class testEmployee {

    public static void main(String[] args){

        Client client = ClientBuilder.newClient();

        String output = client
                              .target("http://localhost:8081/webapi/employees/1")
                              .request(MediaType.APPLICATION_JSON)
                              .get(String.class);
        System.out.println(output);
        client.close();

    }
}
