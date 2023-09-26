package com.kodilla.rental.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(Long id) {
        super(String.format("User with id %s not found", id));
    }
}
