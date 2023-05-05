package com.example.knk_project.services.exceptions;

public class IncorrectPasswordException extends Exception{
    public IncorrectPasswordException(String errorMessage){
        super(errorMessage);
    }
}
