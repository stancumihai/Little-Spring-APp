package com.stancumihai.test.dao;


import com.stancumihai.test.model.Person;

import java.util.List;

public interface PersonDao {

    Person insertPerson(Person person);

    List<Person> selectAllPeople();

    Person findPersonById(Long id);

    int deletePersonById(Long id);

    int updatePerson(Long id, Person person);
}
