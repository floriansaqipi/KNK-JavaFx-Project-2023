package com.example.knk_project.services.exceptions;

public class DifferentPasswordsException extends Exception{
    public DifferentPasswordsException(String errorMessage){
        super(errorMessage);
    }
}
