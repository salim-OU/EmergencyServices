package com.emergencyservices.repository;


import com.emergencyservices.entity.FireStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireStationRepository extends JpaRepository<FireStation, Long> {
}
