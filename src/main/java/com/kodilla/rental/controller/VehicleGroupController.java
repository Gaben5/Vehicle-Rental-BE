package com.kodilla.rental.controller;

import com.kodilla.rental.domain.VehicleGroup;
import com.kodilla.rental.domain.VehicleGroupDto;
import com.kodilla.rental.exception.VehicleGroupNotFoundException;
import com.kodilla.rental.mapper.VehicleGroupMapper;
import com.kodilla.rental.service.VehicleGroupDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/vehicleGroups")
public class VehicleGroupController {
    private final VehicleGroupMapper mapper;
    private final VehicleGroupDbService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createVehicleGroup(@RequestBody VehicleGroupDto vehicleGroupDto) throws VehicleGroupNotFoundException {
        VehicleGroup vehicleGroup = mapper.mapToVehicleGroup(vehicleGroupDto);
        service.saveVehicleGroup(vehicleGroup);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{vehicleGroupId}")
    public ResponseEntity<Void> removeVehicleGroup(@PathVariable long vehicleGroupId){
        service.deleteVehicleGroup(vehicleGroupId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<VehicleGroupDto>> getVehicleGroupsDto(){
        List<VehicleGroup> vehicleGroupList = service.getAllVehicleGroups();
        List<VehicleGroupDto> vehicleGroupDtoList = mapper.mapToVehicleGroupDtoList(vehicleGroupList);
        return ResponseEntity.ok(vehicleGroupDtoList);
    }
    @PutMapping
    public ResponseEntity<VehicleGroupDto> updateVehicleGroup(@RequestBody VehicleGroupDto vehicleGroupDto) throws VehicleGroupNotFoundException {
        VehicleGroup vehicleGroup = mapper.mapToVehicleGroup(vehicleGroupDto);
        VehicleGroup savedVehicleGroup = service.saveVehicleGroup(vehicleGroup);
        return ResponseEntity.ok(mapper.mapToVehicleGroupDto(savedVehicleGroup));
    }

    @GetMapping(value = "{vehicleGroupId}")
    public ResponseEntity<VehicleGroupDto> getVehicle(@PathVariable Long vehicleGroupId) throws VehicleGroupNotFoundException {
        return ResponseEntity.ok(mapper.mapToVehicleGroupDto(service.getVehicleGroup(vehicleGroupId)));
    }


}
