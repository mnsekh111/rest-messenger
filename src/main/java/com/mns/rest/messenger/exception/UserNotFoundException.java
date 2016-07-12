package com.mns.rest.messenger.exception;


public class UserNotFoundException extends RuntimeException{

    private String specifics;

    public UserNotFoundException(){
        super();
        this.specifics="";
    }
    public UserNotFoundException(String s) {
        this.specifics = s;
    }

    @Override
    public String getMessage() {
        return "The user resource doesn't exist { " + this.specifics+" }";
    }

    public String getErrorCode(){
        return "001";
    }

    public String getMoreInfo(){
        return null;
    }
}
