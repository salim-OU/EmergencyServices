package com.emergencyservices.service;


import com.emergencyservices.entity.FireStation;
import com.emergencyservices.repository.FireStationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FireStationService {

    private final FireStationRepository fireStationRepository;

    public FireStationService(FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }

    public List<FireStation> getAllFireStations() {
        return fireStationRepository.findAll();
    }
}