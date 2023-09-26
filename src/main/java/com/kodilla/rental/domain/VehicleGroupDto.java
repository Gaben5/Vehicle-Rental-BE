package com.kodilla.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VehicleGroupDto {
    private Long id;
    private String name;
}
