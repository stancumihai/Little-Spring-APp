package com.stancumihai.service;


import com.stancumihai.dao.Dao;
import com.stancumihai.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {

    private final Dao<Sport> dao;

    @Autowired
    public SportService(@Qualifier("SportDao") Dao<Sport> dao) {
        this.dao = dao;
    }


    public Sport update(Long id, Sport sport) {
        return dao.update(id, sport);
    }


    public int create(Sport element) {
        return dao.create(element);
    }


    public Sport findById(Long id) {
        return dao.findById(id);
    }


    public int deleteById(Long id) {
        return dao.deleteById(id);
    }


    public List<Sport> selectAll() {
        return dao.selectAll();
    }
}
