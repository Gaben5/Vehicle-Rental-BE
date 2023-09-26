package com.kodilla.rental.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "VEHICLE_GROUP")
public class VehicleGroup {
    @Id
    @GeneratedValue
    @Column(name = "VEHICLE_GROUP_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = Vehicle.class,
            mappedBy = "vehicleGroup",
            fetch = FetchType.EAGER
    )
    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleGroup(String name) {
        this.name = name;
    }

    public VehicleGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
