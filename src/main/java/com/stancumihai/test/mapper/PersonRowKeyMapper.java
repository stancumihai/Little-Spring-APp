package com.stancumihai.test.mapper;

import com.stancumihai.test.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowKeyMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getLong("id"));
        person.setName(resultSet.getString("name"));
        return person;
    }
}
