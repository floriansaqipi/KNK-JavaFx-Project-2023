package com.example.knk_project.services.exceptions;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
