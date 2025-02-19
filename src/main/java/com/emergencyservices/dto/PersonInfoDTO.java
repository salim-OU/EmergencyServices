package com.emergencyservices.dto;


import lombok.Data;
import java.util.List;

@Data
public class PersonInfoDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;

    // Informations médicales
    private List<String> medications;
    private List<String> allergies;
    private String prescription;
}

