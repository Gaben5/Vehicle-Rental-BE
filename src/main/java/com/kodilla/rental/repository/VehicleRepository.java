package com.kodilla.rental.repository;

import com.kodilla.rental.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    @Override
    void deleteById(Long id);

    @Override
    Vehicle save(Vehicle vehicle);

    @Override
    Optional<Vehicle> findById(Long id);

    @Override
    List<Vehicle> findAll();
}

