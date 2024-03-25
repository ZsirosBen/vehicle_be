package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String color;
    @Column
    private int year;
}
