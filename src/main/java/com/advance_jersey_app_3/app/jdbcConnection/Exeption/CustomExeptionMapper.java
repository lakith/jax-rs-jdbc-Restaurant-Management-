package com.advance_jersey_app_3.app.jdbcConnection.Exeption;

import com.advance_jersey_app_3.app.jdbcConnection.models.ErrorMessage;

import javax.transaction.Status;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * mapper class of the custom method
 * author:dhananjaya
 */
@Provider
public class CustomExeptionMapper implements ExceptionMapper<CustomExeption> {
    @Override
    public Response toResponse(CustomExeption customExeption) {
        ErrorMessage customError = new ErrorMessage(customExeption.getMessage(),225,"https://www.google.com");
        return Response.status(customError.getErrorCode()).type(MediaType.APPLICATION_JSON).entity(customError).build();
    }
}
