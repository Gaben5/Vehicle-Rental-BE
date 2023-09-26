package com.kodilla.rental.service;

import com.kodilla.rental.domain.VehicleGroup;
import com.kodilla.rental.exception.VehicleGroupNotFoundException;
import com.kodilla.rental.repository.VehicleGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleGroupDbService {
    @Autowired
    private VehicleGroupRepository repository;

    public List<VehicleGroup> getAllVehicleGroups(){return repository.findAll();}

    public VehicleGroup saveVehicleGroup(VehicleGroup vehicleGroup){return repository.save(vehicleGroup);}

    public VehicleGroup getVehicleGroup(Long vehicleGroupId) throws VehicleGroupNotFoundException {
        return repository.findById(vehicleGroupId)
                .orElseThrow(() -> new VehicleGroupNotFoundException(vehicleGroupId));
    }

    public void deleteVehicleGroup(Long vehicleGroupId){
        repository.deleteById(vehicleGroupId);
    }
}
