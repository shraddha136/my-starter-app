package com.example.mystarterapp.dao;

import com.example.mystarterapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class implements the PersonDao interface
 * and describes logic for actions to be performed on the database
 */
@Repository("myPerson")
public class PersonDaoImpl implements PersonDao {

    private static final String SQL_GET_ALL_PERSON = "SELECT id, name FROM person";
    private static final String SQL_INSERT_PERSON = "INSERT INTO PERSON (ID,NAME) VALUES (uuid_generate_v4(), ?)";
    private static final String SQL_GET_PERSON_BY_ID = "SELECT id, name FROM person where ID = ?";
    private static final String SQL_DELETE_PERSON = "DELETE FROM person WHERE id = ?";
    private static final String SQL_UPDATE_PERSON = "UPDATE person SET name = ? " +
            "WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;
    private static List<Person> personList = new ArrayList<>();

    @Autowired
    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UUID insertPerson(UUID id, Person person) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PERSON, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, person.getName());
                return ps;
            }, keyHolder);
            return (UUID) keyHolder.getKeys().get("ID");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Person> getAllPerson() {
        return jdbcTemplate.query(SQL_GET_ALL_PERSON, personRowMapper);
    }

    @Override
    public void updatePerson(Person person) {
        jdbcTemplate.update(SQL_UPDATE_PERSON, new Object[]{person.getName(), person.getId()});
    }

    @Override
    public void deletePersonById(UUID id) {
        jdbcTemplate.update(SQL_DELETE_PERSON, new Object[]{id});
    }

    @Override
    public Person selectPersonById(UUID id) {
        return jdbcTemplate.queryForObject(SQL_GET_PERSON_BY_ID, new Object[]{id}, personRowMapper);
    }

    private RowMapper<Person> personRowMapper = ((rs, rowNum) -> {
        return new Person(UUID.fromString(rs.getString("ID")),
                rs.getString("NAME"));
    });
}
