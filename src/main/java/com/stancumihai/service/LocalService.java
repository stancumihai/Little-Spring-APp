package com.stancumihai.service;

import com.stancumihai.dao.Dao;
import com.stancumihai.model.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {

    private final Dao<Local> dao;

    @Autowired
    public LocalService(@Qualifier("LocalDao") Dao<Local> dao) {
        this.dao = dao;
    }

    public Local findById(Long id) {
        return dao.findById(id);
    }

    public int create(Local local) {
        return dao.create(local);
    }

    public int delete(Long id) {
        return dao.deleteById(id);
    }

    public List<Local> selectAll() {
        return dao.selectAll();
    }

    public Local update(Long id, Local local) {
        return dao.update(id, local);
    }
}
