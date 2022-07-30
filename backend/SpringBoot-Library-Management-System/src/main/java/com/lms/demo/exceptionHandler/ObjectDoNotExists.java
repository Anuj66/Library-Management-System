package com.lms.demo.exceptionHandler;

public class ObjectDoNotExists extends RuntimeException{

    private String message;

    public ObjectDoNotExists() {}

    public ObjectDoNotExists(String msg) {
        super(msg);
        this.message = msg;
    }

}
