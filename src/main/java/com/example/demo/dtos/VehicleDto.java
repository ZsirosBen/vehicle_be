package com.example.demo.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VehicleDto {

    private Long id;
    private String brand;
    private String model;
    private String color;
    private int year;
}
