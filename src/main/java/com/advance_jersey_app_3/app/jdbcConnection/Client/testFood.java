package com.advance_jersey_app_3.app.jdbcConnection.Client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class testFood {

    public static void main(String[]args){

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://localhost:8081/webapi/food")
                                     .path("{meal}")
                                     .resolveTemplate("meal", "breakfast")
                                     .queryParam("price", "100");

        System.out.println(myResource.request(MediaType.APPLICATION_JSON).get(String.class));
    }
}
