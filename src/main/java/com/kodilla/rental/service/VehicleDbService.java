package com.kodilla.rental.service;

import com.google.gson.Gson;
import com.kodilla.rental.domain.Vehicle;
import com.kodilla.rental.exception.VehicleNotFoundException;
import com.kodilla.rental.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleDbService {
    @Autowired
    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles(){return vehicleRepository.findAll();}

    public  Vehicle saveVehicle(Vehicle vehicle){return vehicleRepository.save(vehicle);}

    public Vehicle getVehicle(Long vehicleId)throws VehicleNotFoundException{
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException(vehicleId));
    }
    public void deleteVehicle(Long vehicleId)throws VehicleNotFoundException{
        vehicleRepository.deleteById(vehicleId);
    }
}
