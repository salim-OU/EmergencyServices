package com.emergencyservices.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import java.util.List;

@Data
@Entity
@Table(name = "medical_record")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private List<String> medications;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private List<String> allergies;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private String prescription;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}