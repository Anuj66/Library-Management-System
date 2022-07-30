package com.lms.demo.exceptionHandler;

public class ObjectAlreadyExists extends RuntimeException{

    private String message;

    public ObjectAlreadyExists() {}

    public ObjectAlreadyExists(String msg) {
        super(msg);
        this.message = msg;
    }
}
