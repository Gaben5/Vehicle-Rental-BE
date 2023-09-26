package com.kodilla.rental.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "VEHICLE")
public class Vehicle {
    @Id
    @GeneratedValue
    @Column(name = "VEHICLE_ID", unique = true)
    private Long id;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "PRODUCTION_YEAR")
    private int productionYear;

    @Column(name = "HORSE_POWER")
    private int horsePower;

    @Column(name = "PRICE_PER_DAY")
    private double pricePerDay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_GROUP_ID")
    private VehicleGroup vehicleGroup;

    public Vehicle(String brand, String color, int productionYear, int horsePower,
                   VehicleGroup vehicleGroup, double pricePerDay) {
        this.brand = brand;
        this.color = color;
        this.productionYear = productionYear;
        this.horsePower = horsePower;
        this.vehicleGroup = vehicleGroup;
        this.pricePerDay = pricePerDay;
    }
}
