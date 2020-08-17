package com.example.mystarterapp.dao;

import com.example.mystarterapp.exceptions.PBadRequestException;
import com.example.mystarterapp.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * This interface describes a blue print for actions to be performed on the database
 */
@Repository("myPerson")
public interface PersonDao {

    UUID insertPerson(UUID id, Person person) throws PBadRequestException;

    default UUID insertPerson(Person person) throws PBadRequestException{
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> getAllPerson();

    void updatePerson(Person person);

    void deletePersonById(UUID id);

    Person selectPersonById(UUID id);
}
