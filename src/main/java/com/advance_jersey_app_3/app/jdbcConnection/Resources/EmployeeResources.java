package com.advance_jersey_app_3.app.jdbcConnection.Resources;

import java.sql.SQLException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.advance_jersey_app_3.app.jdbcConnection.models.Employee;
import com.advance_jersey_app_3.app.jdbcConnection.services.EmployeeService;
import org.glassfish.jersey.server.Uri;
import org.glassfish.jersey.server.spi.Container;

@Path("employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResources {

	EmployeeService employeeService = new EmployeeService();
	
	@GET
	public Response displayEmployees() throws ClassNotFoundException, SQLException
	{	
	 List<Employee> emp = employeeService.getAllEmployees();	
	 return Response.ok(emp).build();
	}
	
	@GET
	@Path("/{emp_id}")
	public Response displayEmployee (@PathParam("emp_id") int emp_id) throws ClassNotFoundException, SQLException{
		Employee emp = employeeService.getEmployee(emp_id);
		return Response.ok(emp).build();
	}

    @GET
	@Path("/name/{empName: [a-zA-Z][a-zA-Z_0-9]*}")
	public Response displayEmployeeFromName (@PathParam("empName") String name) throws SQLException, ClassNotFoundException {
       Employee emp = employeeService.getEmployeeFromName(name);
       return Response.ok(emp).build();
	}
	
	@POST
	public Response createEmployee(Employee emp) throws ClassNotFoundException, SQLException{
		boolean result = employeeService.setEmployee(emp);
		if(!result) {
			return Response.ok(emp).build();
		} else {
			JsonObject jsonObject = Json.createObjectBuilder().add("Error","Employee Creation failed").build(); 
			return Response.ok(jsonObject).build();
		}
	}
	
	@PUT
	@Path("/{emp_id}")
	public Response updateEmployee(Employee emp,@PathParam("emp_id")int emp_id) throws ClassNotFoundException, SQLException{
		int result = employeeService.updateEmployee(emp, emp_id);
		if(result == 1){
			return Response.ok(emp).build();
		} else{
			JsonObject jsonObject = Json.createObjectBuilder().add("Error","Employee Updation failed").build(); 
			return Response.ok(jsonObject).build();
		}
	}
	
	@DELETE
	@Path("/{emp_id}")
	public Response deleteEmployee(@PathParam("emp_id")int emp_id) throws ClassNotFoundException, SQLException{
		Employee emp =  employeeService.getEmployee(emp_id);
		int result = employeeService.deleteEmployee(emp_id);
		if(result == 1){
			return Response.ok(emp).build();
		} else {
			JsonObject jsonObject = Json.createObjectBuilder().add("Error","Employee Deletion failed").build(); 
			return Response.ok(jsonObject).build();
		}
	}

    @GET
	@Path("/url")
	@Produces(MediaType.TEXT_PLAIN)
    public String displayUriInfo(@Context UriInfo uriInfo)
	{
		String path = uriInfo.getAbsolutePath().toString();
		return  path;
	}


	@Path("/{emp_id}/order")
	public OrderResources getOrderDetails()
	{
		return new OrderResources();
	}






	
}
