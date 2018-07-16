package com.advance_jersey_app_3.app.jdbcConnection.Resources;

import com.advance_jersey_app_3.app.jdbcConnection.Exeption.CustomExeption;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("Exeption")
@Produces("application/json")
public class UseExeptionResource {

    @GET
    public String throwex(){
        if(true){
            System.out.println("success");
            return "success";
        }else {
            throw new CustomExeption("Demo Exeption message");
        }
    }

    /**
     * if u want to write exeption in console use this
     */
    @GET
    @Path("catchex")
    public void Catchex(){
        try{
            throw new CustomExeption("catched exeption");
        }catch (CustomExeption e){
            System.out.println(e);
        }

    }

    /**
     * if u want to display exeption in web browser use his type
     * @throws CustomExeption
     */
    @GET
    @Path("throwsex")
    public void Throwex(){
        throw new CustomExeption("throws");
    }
}
