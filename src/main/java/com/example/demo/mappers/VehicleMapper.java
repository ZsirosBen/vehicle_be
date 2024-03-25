package com.example.demo.mappers;

import com.example.demo.dtos.VehicleDto;
import com.example.demo.entities.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    Vehicle toVehicle(VehicleDto vehicleDto);

    VehicleDto toVehicleDto(Vehicle vehicle);

    List<VehicleDto> toVehicleDtos(List<Vehicle> vehicles);
}
