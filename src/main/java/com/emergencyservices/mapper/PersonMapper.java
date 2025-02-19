package com.emergencyservices.mapper;
import com.emergencyservices.dto.PersonInfoDTO;
import com.emergencyservices.entity.Person;
import com.emergencyservices.entity.MedicalRecord;
import org.springframework.stereotype.Component;
@Component
public class PersonMapper {
    public PersonInfoDTO toDTO(Person person, MedicalRecord medicalRecord) {
        PersonInfoDTO dto = new PersonInfoDTO();

        // Mapping des informations de la personne
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setCity(person.getCity());
        dto.setZip(person.getZip());
        dto.setPhone(person.getPhone());

        // Mapping des informations médicales si disponibles
        if (medicalRecord != null) {
            dto.setMedications(medicalRecord.getMedications());
            dto.setAllergies(medicalRecord.getAllergies());
            dto.setPrescription(medicalRecord.getPrescription());
        }

        return dto;
    }
}
