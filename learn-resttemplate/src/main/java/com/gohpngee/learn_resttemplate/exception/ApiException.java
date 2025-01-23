package com.gohpngee.learn_resttemplate.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
