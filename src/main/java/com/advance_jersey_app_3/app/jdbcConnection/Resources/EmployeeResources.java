package com.advance_jersey_app_3.app.jdbcConnection.Resources;

import com.advance_jersey_app_3.app.jdbcConnection.Client.RedisClient;
import com.advance_jersey_app_3.app.jdbcConnection.Redis.RedisImpl;
import com.advance_jersey_app_3.app.jdbcConnection.models.Employee;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.advance_jersey_app_3.app.jdbcConnection.services.EmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResources {

    private EmployeeService employeeService = new EmployeeService();

    @GET
    public Response displayEmployees() throws ClassNotFoundException, SQLException {
        List<Employee> emp = employeeService.getAllEmployees();
        RedisImpl redisimpl = new RedisImpl();
        redisimpl.setRadies("employees",emp);
        List<Employee> emmnew = new ArrayList<Employee>();
        emmnew.addAll((Collection<? extends Employee>) redisimpl.getObjectValue("Employees"));
        return Response.ok(emmnew).build();
    }

    @GET
    @Path("/{emp_id}")
    public Response displayEmployee(@PathParam("emp_id") int emp_id) throws ClassNotFoundException, SQLException {
        Employee emp = employeeService.getEmployee(emp_id);
        return Response.ok(emp).build();

    }

    @GET
    @Path("/name/{empName: [a-zA-Z][a-zA-Z_0-9]*}")
    public Response displayEmployeeFromName(@PathParam("empName") String name) throws SQLException, ClassNotFoundException {
        Employee emp = employeeService.getEmployeeFromName(name);
        return Response.ok(emp).build();
    }

    @POST
    public Response createEmployee(Employee emp) throws ClassNotFoundException, SQLException {
        boolean result = employeeService.setEmployee(emp);
        if (!result) {
            return Response.ok(emp).build();
        } else {
            JsonObject jsonObject = Json.createObjectBuilder().add("Error", "Employee Creation failed").build();
            return Response.ok(jsonObject).build();
        }
    }

    @PUT
    @Path("/{emp_id}")
    public Response updateEmployee(Employee emp, @PathParam("emp_id") int emp_id) throws ClassNotFoundException, SQLException {
        int result = employeeService.updateEmployee(emp, emp_id);
        if (result == 1) {
            return Response.ok(emp).build();
        } else {
            JsonObject jsonObject = Json.createObjectBuilder().add("Error", "Employee Updation failed").build();
            return Response.ok(jsonObject).build();
        }
    }

    @DELETE
    @Path("/{emp_id}")
    public Response deleteEmployee(@PathParam("emp_id") int emp_id) throws ClassNotFoundException, SQLException {
        Employee emp = employeeService.getEmployee(emp_id);
        int result = employeeService.deleteEmployee(emp_id);
        if (result == 1) {
            return Response.ok(emp).build();
        } else {
            JsonObject jsonObject = Json.createObjectBuilder().add("Error", "Employee Deletion failed").build();
            return Response.ok(jsonObject).build();
        }
    }

    @GET
    @Path("/url")
    @Produces(MediaType.TEXT_PLAIN)
    public String displayUriInfo(@Context UriInfo uriInfo) {
        String path = uriInfo.getAbsolutePath().toString();
        RedisClient rsc = new RedisClient();
        System.out.println(rsc.getCache("namre"));
        return path;
    }


    @GET
    @Path("httpheaders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(@Context HttpHeaders headers) {
        System.out.println("ALL headers -- " + headers.getRequestHeaders().toString());
        System.out.println("'Accept' header -- " + headers.getHeaderString("Accept"));
        //System.out.println("'TestCookie' value -- " + headers.getCookies().get("TestCookie").getValue());
        JsonObject jsonObject = Json.createObjectBuilder().add("heder ", "httpHedderCall success").build();
        return Response.ok(jsonObject).build();
    }



    @GET
    @Path("testpath/{param1}/{param2}/{param3}")
    public Response displayDetails(@Context UriInfo ui){
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        System.out.println(pathParams.get("param1"));
        return  Response.ok().entity(pathParams).build();
    }

    @Path("/{emp_id}/order")
    public OrderResources getOrderDetails() {
        return new OrderResources();
    }


}
