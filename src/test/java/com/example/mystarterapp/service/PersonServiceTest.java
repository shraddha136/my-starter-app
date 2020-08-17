package com.example.mystarterapp.service;

import com.example.mystarterapp.dao.PersonDao;
import com.example.mystarterapp.model.Person;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonServiceTest {

    private final PersonDao personDao = Mockito.mock(PersonDao.class);
    @Test
    void getAllPerson() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(UUID.randomUUID(),"Danny"));
        personList.add(new Person(UUID.randomUUID(),"Doe"));
        when(personDao.getAllPerson()).thenReturn(personList);
        assertEquals(personDao.getAllPerson().size(), 2);
    }

}