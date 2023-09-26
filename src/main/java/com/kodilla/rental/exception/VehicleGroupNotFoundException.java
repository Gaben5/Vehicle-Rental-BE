package com.kodilla.rental.exception;

public class VehicleGroupNotFoundException extends Exception{
    public VehicleGroupNotFoundException(long id) {
        super(String.format("Vehicle group with id %s not found", id));
    }
}
