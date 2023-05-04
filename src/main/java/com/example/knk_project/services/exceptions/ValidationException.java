package com.example.knk_project.services.exceptions;

public class ValidationException extends Exception{
    public ValidationException(String errorMessage){
        super(errorMessage);
    }
}
