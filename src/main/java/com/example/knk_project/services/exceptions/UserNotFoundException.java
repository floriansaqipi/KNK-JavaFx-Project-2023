package com.example.knk_project.services.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
