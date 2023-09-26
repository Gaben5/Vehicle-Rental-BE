package com.kodilla.rental.controller;

import com.kodilla.rental.domain.Vehicle;
import com.kodilla.rental.domain.VehicleDto;
import com.kodilla.rental.exception.VehicleGroupNotFoundException;
import com.kodilla.rental.exception.VehicleNotFoundException;
import com.kodilla.rental.mapper.VehicleMapper;
import com.kodilla.rental.service.VehicleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleMapper mapper;
    private final VehicleDbService service;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createVehicle(@RequestBody VehicleDto vehicleDto) throws VehicleGroupNotFoundException {
        Vehicle vehicle = mapper.mapToVehicle(vehicleDto);
        service.saveVehicle(vehicle);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{vehicleId}")
    public ResponseEntity<Void> removeVehicle(@PathVariable long vehicleId) throws VehicleNotFoundException {
        service.deleteVehicle(vehicleId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getVehicles(){
        return ResponseEntity.ok(mapper.mapToVehicleDtoList(service.getAllVehicles()));
    }

    @PutMapping
    public ResponseEntity<VehicleDto> updateVehicle(@RequestBody VehicleDto vehicleDto) throws VehicleGroupNotFoundException {
        Vehicle vehicle = mapper.mapToVehicle(vehicleDto);
        Vehicle savedVehicle = service.saveVehicle(vehicle);
        return ResponseEntity.ok(mapper.mapToVehicleDto(savedVehicle));
    }

    @GetMapping(value = "{vehicleId}")
    public ResponseEntity<VehicleDto> getVehicle(@PathVariable Long vehicleId) throws VehicleNotFoundException {
        return ResponseEntity.ok(mapper.mapToVehicleDto(service.getVehicle(vehicleId)));
    }
}
