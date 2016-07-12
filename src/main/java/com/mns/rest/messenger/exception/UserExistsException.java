package com.mns.rest.messenger.exception;

public class UserExistsException extends RuntimeException{

    private String specifics;
    public UserExistsException() {
        super();
        this.specifics="";
    }

    public UserExistsException(String s) {
        this.specifics = s;
    }

    @Override
    public String getMessage() {
        return "The user resource already exists { " + this.specifics+" }";
    }

    public String getErrorCode(){
        return "002";
    }

    public String getMoreInfo(){
        return null;
    }
}
