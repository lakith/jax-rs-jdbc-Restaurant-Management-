package com.advance_jersey_app_3.app.jdbcConnection.Exeption;

public class CustomExeption extends RuntimeException {
    /**
     * this is the method that we throes when custom error happpens
     * @param message this is the message that we need to show the client
     */
    public CustomExeption(String message){
        super(message);
    }
}
