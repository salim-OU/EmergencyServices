package com.emergencyservices.controller;

import com.emergencyservices.entity.MedicalRecord;
import com.emergencyservices.service.MedicalRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/medicalRecords")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    // Create or Update a MedicalRecord
    @PostMapping
    public ResponseEntity<MedicalRecord> saveMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return ResponseEntity.ok(medicalRecordService.saveMedicalRecord(medicalRecord));
    }

    // Retrieve all MedicalRecords
    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {
        log.info("Retrieving all medical records");
        return ResponseEntity.ok(medicalRecordService.getAllMedicalRecords());
    }

   // Retrieve a MedicalRecord by ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable Long id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordService.getMedicalRecordById(id);
        return medicalRecord.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a MedicalRecord by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return ResponseEntity.noContent().build();
    }
}