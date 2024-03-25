package com.example.demo.services;

import com.example.demo.dtos.VehicleDto;
import com.example.demo.entities.Vehicle;
import com.example.demo.exceptions.AppException;
import com.example.demo.mappers.VehicleMapper;
import com.example.demo.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;


    public List<VehicleDto> allVehicles() {
        List<Vehicle> all = vehicleRepository.findAll();
        return vehicleMapper.toVehicleDtos(all);
    }

    public VehicleDto getVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(()-> new AppException("Vehicle not found", HttpStatus.NOT_FOUND));
        return vehicleMapper.toVehicleDto(vehicle);
    }

    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleDto);

        System.out.println("AZ ATMAPPELT VEHICLE:" + vehicle.getId());

        Vehicle createdVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toVehicleDto(createdVehicle);
    }
}
