package com.example.demo.controllers;

import com.example.demo.dtos.VehicleDto;
import com.example.demo.services.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class VehicleController {

    private final VehicleService vehicleService;
    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> allVehicles() {
        return ResponseEntity.ok(vehicleService.allVehicles());
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> getVehicle(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicle(id));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleDto> createVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
        VehicleDto createdVehicle = vehicleService.createVehicle(vehicleDto);
        System.out.println("INPUT REQUEST: " + vehicleDto);
        return ResponseEntity.created(URI.create("/vehicles/" + createdVehicle.getId())).body(createdVehicle);
    }
}
