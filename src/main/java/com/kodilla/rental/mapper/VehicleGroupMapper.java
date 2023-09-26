package com.kodilla.rental.mapper;

import com.kodilla.rental.domain.Vehicle;
import com.kodilla.rental.domain.VehicleGroup;
import com.kodilla.rental.domain.VehicleGroupDto;
import com.kodilla.rental.exception.VehicleGroupNotFoundException;
import com.kodilla.rental.service.VehicleDbService;
import com.kodilla.rental.service.VehicleGroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleGroupMapper {
    @Autowired
    private VehicleMapper vehicleMapper;

    public VehicleGroup mapToVehicleGroup(VehicleGroupDto vehicleGroupDto) throws VehicleGroupNotFoundException {
        return new VehicleGroup(vehicleGroupDto.getId(), vehicleGroupDto.getName());
    }

    public VehicleGroupDto mapToVehicleGroupDto(VehicleGroup vehicleGroup){
        return new VehicleGroupDto(vehicleGroup.getId(), vehicleGroup.getName());
    }

    public List<VehicleGroupDto> mapToVehicleGroupDtoList(List<VehicleGroup> vehicleGroups){
        return vehicleGroups.stream()
                .map(this::mapToVehicleGroupDto)
                .collect(Collectors.toList());
    }

}
