package com.shop.SV_TASK.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message){
        super(message);
    }
}
