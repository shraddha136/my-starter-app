package com.example.mystarterapp.service;

import com.example.mystarterapp.dao.PersonDao;
import com.example.mystarterapp.exceptions.PBadRequestException;
import com.example.mystarterapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This class describes the services layer actions performed.
 * it also holds the basic business logic to be performed
 */
@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("myPerson") PersonDao personDao) {
        this.personDao = personDao;
    }

    public UUID insertPerson(Person person) throws PBadRequestException {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPerson() {
        return personDao.getAllPerson();
    }

    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    public Person getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public void deletePersonById(UUID id) {
        personDao.deletePersonById(id);
    }
}
