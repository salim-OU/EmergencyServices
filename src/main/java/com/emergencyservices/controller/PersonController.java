package com.emergencyservices.controller;

import com.emergencyservices.dto.PersonInfoDTO;
import com.emergencyservices.entity.Person;
import com.emergencyservices.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // READ (All)
    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
    // READ (By ID)
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    // CREATE
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }
    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        Person person = personService.updatePerson(id, updatedPerson);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // Dto
    @GetMapping("/info/{id}")
    public ResponseEntity<PersonInfoDTO> getPersonWithMedicalInfo(@PathVariable Long id) {
        PersonInfoDTO personInfo = personService.getPersonInfo(id);
        return ResponseEntity.ok(personInfo);
    }

    @GetMapping("/info")
    public ResponseEntity<List<PersonInfoDTO>> getAllPersonsWithMedicalInfo() {
        List<PersonInfoDTO> persons = personService.getAllPersonsInfo();
        return ResponseEntity.ok(persons);
    }

}
