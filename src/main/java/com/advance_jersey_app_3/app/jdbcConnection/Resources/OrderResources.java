package com.advance_jersey_app_3.app.jdbcConnection.Resources;

import com.advance_jersey_app_3.app.jdbcConnection.models.Orders;
import com.advance_jersey_app_3.app.jdbcConnection.services.OrderService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/")
public class OrderResources {

    OrderService orderService = new OrderService();

    @GET
    public Response getAllOrders(@PathParam("emp_id") int emp_id) throws SQLException, ClassNotFoundException {
        return Response.ok().entity(orderService.getAllOrders(emp_id)).build();
    }

    @GET
    @Path("{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders(@PathParam("emp_id") int emp_id,@PathParam("orderId") int orderID) throws SQLException, ClassNotFoundException {
        return  Response.ok().entity(orderService.getOrder(emp_id,orderID)).build();
    }

    @POST
    public Response addAOrder(@PathParam("emp_id") int emp_id){
        
    }


}
