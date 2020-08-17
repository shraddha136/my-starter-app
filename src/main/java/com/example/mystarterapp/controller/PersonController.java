package com.example.mystarterapp.controller;

import com.example.mystarterapp.model.Person;
import com.example.mystarterapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * This is the entry point for all the endpoints of this application
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/getAllPerson")
    public ResponseEntity<List<Person>> getAllPerson(){
        return new ResponseEntity<>(personService.getAllPerson(), HttpStatus.OK);
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity(personService.insertPerson(person),HttpStatus.CREATED);
    }

    @PutMapping("/updatePerson")
    public void updatePerson(Person person){
        personService.updatePerson(person);
    }

    @GetMapping("/getPersonById/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id);
    }

    @DeleteMapping("/deletePersonById")
    public void deletePersonById(@RequestParam("id") UUID id){
        personService.deletePersonById(id);
    }
}
