package com.emergencyservices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fire_station")
public class FireStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_number")
    private Integer stationNumber;

    private String address;
    private String city;
    private String zip;

    @ManyToMany
    @JoinTable(
            name = "fire_station_personnel",
            joinColumns = @JoinColumn(name = "fire_station_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> personnel;
}