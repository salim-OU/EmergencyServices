package com.emergencyservices.service;

import com.emergencyservices.dto.PersonInfoDTO;
import com.emergencyservices.entity.MedicalRecord;
import com.emergencyservices.entity.Person;
import com.emergencyservices.exception.ResourceNotFoundException;
import com.emergencyservices.mapper.PersonMapper;
import com.emergencyservices.repository.MedicalRecordRepository;
import com.emergencyservices.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, MedicalRecordRepository medicalRecordRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.medicalRecordRepository = medicalRecordRepository;
        this.personMapper = personMapper;
    }
    // READ (All)
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    // CREATE
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
    // READ (By ID)
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }
    // UPDATE
    public Person updatePerson(Long id, Person updatedPerson) {
        Person existingPerson = getPersonById(id);
        existingPerson.setFirstName(updatedPerson.getFirstName());
        existingPerson.setLastName(updatedPerson.getLastName());
        existingPerson.setAddress(updatedPerson.getAddress());
        existingPerson.setCity(updatedPerson.getCity());
        existingPerson.setZip(updatedPerson.getZip());
        existingPerson.setPhone(updatedPerson.getPhone());
        existingPerson.setEmail(updatedPerson.getEmail());
        existingPerson.setBirthDate(updatedPerson.getBirthDate());
        return personRepository.save(existingPerson);
    }

    // DELETE
    public void deletePerson(Long id) {
        Person person = getPersonById(id);
        personRepository.delete(person);
    }
    // Nouvelles méthodes DTO
    public PersonInfoDTO getPersonInfo(Long id) {
        Person person = getPersonById(id);
        MedicalRecord medicalRecord = medicalRecordRepository.findByPersonId(id)
                .orElse(null);
        return personMapper.toDTO(person, medicalRecord);
    }

    public List<PersonInfoDTO> getAllPersonsInfo() {
        return personRepository.findAll().stream()
                .map(person -> personMapper.toDTO(
                        person,
                        medicalRecordRepository.findByPersonId(person.getId()).orElse(null)
                ))
                .collect(Collectors.toList());
    }
}