// Controller
package com.emergencyservices.controller;

import com.emergencyservices.entity.FireStation;
import com.emergencyservices.service.FireStationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fireStations")
public class FireStationController {

    private final FireStationService fireStationService;

    public FireStationController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @GetMapping
    public ResponseEntity<List<FireStation>> getAllFireStations() {
        return ResponseEntity.ok(fireStationService.getAllFireStations());
    }
}