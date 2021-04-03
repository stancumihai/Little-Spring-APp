package com.stancumihai.test.service;

import com.stancumihai.test.dao.PersonDao;
import com.stancumihai.test.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("PersonRepo") PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person addPerson(Person person) {
        return personDao.insertPerson(person);

    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Person getPersonById(Long id) {
        return personDao.findPersonById(id);
    }

    public int deletePerson(Long id) {
        return personDao.deletePersonById(id);

    }

    public int updatePerson(Long id, Person newPerson) {
        return personDao.updatePerson(id, newPerson);
    }
}
