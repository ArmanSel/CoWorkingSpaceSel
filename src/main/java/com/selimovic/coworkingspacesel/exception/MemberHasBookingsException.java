package com.selimovic.coworkingspacesel.exception;

public class MemberHasBookingsException extends RuntimeException{
    public MemberHasBookingsException(String message){
        super(message);
    }
}