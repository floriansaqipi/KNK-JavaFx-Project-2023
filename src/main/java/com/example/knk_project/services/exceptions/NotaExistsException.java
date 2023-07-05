package com.example.knk_project.services.exceptions;

public class NotaExistsException extends Exception{
    public NotaExistsException(String errorMessage){
        super(errorMessage);
    }

}
