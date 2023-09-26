package com.kodilla.rental.exception;

public class VehicleNotFoundException extends Exception{
    public VehicleNotFoundException(long id) {
        super(String.format("Vehicle with id %s not found", id));
    }
}
