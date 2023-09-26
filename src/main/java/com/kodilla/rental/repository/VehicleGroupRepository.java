package com.kodilla.rental.repository;

import com.kodilla.rental.domain.VehicleGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface VehicleGroupRepository extends CrudRepository<VehicleGroup, Long> {
    @Override
    VehicleGroup save(VehicleGroup vehicleGroup);

    @Override
    Optional<VehicleGroup> findById(Long id);

    @Override
    List<VehicleGroup> findAll();

    @Override
    void deleteById(Long id);
}
