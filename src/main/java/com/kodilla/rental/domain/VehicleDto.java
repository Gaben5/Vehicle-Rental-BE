package com.kodilla.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VehicleDto {
    private Long id;
    private String brand;
    private String color;
    private int productionYear;
    private int horsePower;
    private Long vehicleGroupId;
    private double pricePerDay;
}
