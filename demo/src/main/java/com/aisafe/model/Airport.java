package com.aisafe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;
import jakarta.persistence.ElementCollection;
import java.util.List;

@Entity
@Data
public class Airport {

    @Id
    @Column(length = 3)
    private String iataCode; // Ex: LIS, OPO

    private String name;
    private String city;
    private String country;
    private String timezone;
    private String status; // OPERATIONAL, CLOSED, UNDER_MAINTENANCE
    private String coordinates; // Ex: "38.7742° N, 9.1342° W"
    private String runwayName;
    private double runwayLength;
    private String runwayOrientation;

    @ElementCollection // O Spring cria uma tabela extra na base de ddados automaticamente para esta lista!
    private List<String> certifiedAircraftModels;
}