package com.advance_jersey_app_3.app.jdbcConnection.Exeption;

import com.advance_jersey_app_3.app.jdbcConnection.models.ErrorMessage;

import javax.transaction.Status;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * mapper vclass of the custom method
 * author:dhananjaya
 */
@Provider
public class CustomExeptionMapper implements ExceptionMapper<CustomExeption> {
    @Override
    public Response toResponse(CustomExeption customExeption) {
        ErrorMessage customError = new ErrorMessage(customExeption.getMessage(),300,"https://www.google.com");
        return Response.status(300).type(MediaType.APPLICATION_JSON).entity(customError).build();
    }
}
