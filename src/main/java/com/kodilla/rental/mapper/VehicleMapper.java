package com.kodilla.rental.mapper;

import com.kodilla.rental.domain.Vehicle;
import com.kodilla.rental.domain.VehicleDto;
import com.kodilla.rental.domain.VehicleGroup;
import com.kodilla.rental.exception.VehicleGroupNotFoundException;
import com.kodilla.rental.repository.VehicleGroupRepository;
import com.kodilla.rental.repository.VehicleRepository;
import com.kodilla.rental.service.VehicleGroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class VehicleMapper {
    @Autowired
    private VehicleGroupDbService vehicleGroupDbService;
    public Vehicle mapToVehicle(VehicleDto vehicleDto) throws VehicleGroupNotFoundException {
        return new Vehicle(vehicleDto.getId(), vehicleDto.getBrand(), vehicleDto.getColor(), vehicleDto.getProductionYear(), vehicleDto.getHorsePower(),
                vehicleDto.getPricePerDay(), vehicleGroupDbService.getVehicleGroup(vehicleDto.getVehicleGroupId()));
    }

    public VehicleDto mapToVehicleDto(Vehicle vehicle){
        return new VehicleDto(vehicle.getId(), vehicle.getBrand(), vehicle.getColor(), vehicle.getProductionYear(), vehicle.getHorsePower(), vehicle.getVehicleGroup().getId(), vehicle.getPricePerDay());
    }

    public List<VehicleDto> mapToVehicleDtoList(final List<Vehicle> vehicleList){
        return vehicleList.stream().map(this::mapToVehicleDto).collect(Collectors.toList());
    }

    public List<Vehicle> mapToVehicleList(List<VehicleDto> vehicleDtos) throws VehicleGroupNotFoundException {
        return vehicleDtos.stream()
                .map(vehicleDto -> {
                    try {
                        VehicleGroup vehicleGroup = vehicleGroupDbService.getVehicleGroup(vehicleDto.getVehicleGroupId());

                        return new Vehicle(
                                vehicleDto.getId(),
                                vehicleDto.getBrand(),
                                vehicleDto.getColor(),
                                vehicleDto.getProductionYear(),
                                vehicleDto.getHorsePower(),
                                vehicleDto.getPricePerDay(),
                                vehicleGroup
                        );
                    } catch (VehicleGroupNotFoundException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
