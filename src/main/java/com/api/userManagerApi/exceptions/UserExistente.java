package com.api.userManagerApi.exceptions;

public class UserExistente extends RuntimeException{
    public UserExistente(String message){
        super(message);
    }
}

