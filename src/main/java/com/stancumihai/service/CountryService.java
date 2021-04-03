package com.stancumihai.service;

import com.stancumihai.dao.Dao;
import com.stancumihai.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final Dao<Country> dao;

    @Autowired
    public CountryService(@Qualifier("CountryDao") Dao<Country> dao) {
        this.dao = dao;
    }

    public Country findById(Long id) {
        return dao.findById(id);
    }

    public int create(Country location) {
        return dao.create(location);
    }

    public int delete(Long id) {
        return dao.deleteById(id);
    }

    public List<Country> selectAll() {
        return dao.selectAll();
    }

    public Country update(Long id, Country country) {
        return dao.update(id, country);
    }
}
