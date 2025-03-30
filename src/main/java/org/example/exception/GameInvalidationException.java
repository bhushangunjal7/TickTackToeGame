package org.example.exception;

public class GameInvalidationException extends Exception{
    public GameInvalidationException(String message){
        super(message);
    }
}
