package com.advance_jersey_app_3.app.jdbcConnection.Resources;

import com.advance_jersey_app_3.app.jdbcConnection.services.FoodService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("food/{meal}")
public class FoodResource {

    @PathParam("meal") private String meal;
    @QueryParam("price") private String price;

    FoodService foodService = new FoodService();

   @GET
    public Response displayFoodDetails() throws SQLException, ClassNotFoundException {
       int newPrice = 0;
       try{
           newPrice =  Integer.parseInt(price);
       } catch (Exception e ) {
           JsonObject jsonObject = Json.createObjectBuilder().add("Data type - price ","miss match").build();
           return Response.ok(jsonObject).build();
       }
       return Response.ok(foodService.getFoodDetails(meal,newPrice)).build();
      /* JsonObject jsonObject = Json.createObjectBuilder().add("type",type).add("price",price).build();
       return Response.ok(jsonObject).build();*/
   }

}
