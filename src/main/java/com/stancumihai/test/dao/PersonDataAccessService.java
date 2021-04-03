package com.stancumihai.test.dao;

import com.stancumihai.test.mapper.PersonRowKeyMapper;
import com.stancumihai.test.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PersonRepo")
public class PersonDataAccessService implements PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Person insertPerson(Person person) {

        return person;
    }

    @Override
    public List<Person> selectAllPeople() {

        String sqlQuery = "SELECT * FROM person.person;";
        return jdbcTemplate.query(sqlQuery, new PersonRowKeyMapper());
    }

    @Override
    public Person findPersonById(Long id) {
        String sqlQuery = "SELECT * FROM person.person WHERE id=?";
        return jdbcTemplate.queryForObject(sqlQuery, new PersonRowKeyMapper(), id);
    }

    @Override
    public int deletePersonById(Long id) {
        String sqlQuery = "DELETE FROM person.person WHERE id=?";
        return jdbcTemplate.update(sqlQuery, new PersonRowKeyMapper(), id);
    }

    @Override
    public int updatePerson(Long id, Person update) {
        String sqlQuery = "update person set name=? where id=?";
        return jdbcTemplate.update(sqlQuery, update.getId(), update.getName());
    }
}
