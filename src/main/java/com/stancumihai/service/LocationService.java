package com.stancumihai.service;

import com.stancumihai.dao.Dao;
import com.stancumihai.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final Dao<Location> dao;

    @Autowired
    public LocationService(@Qualifier("LocationDao") Dao<Location> dao) {
        this.dao = dao;
    }

    public Location findById(Long id) {
        return dao.findById(id);
    }

    public int create(Location location) {
        return dao.create(location);
    }

    public int delete(Long id) {
        return dao.deleteById(id);
    }

    public List<Location> selectAll() {
        return dao.selectAll();
    }

    public Location update(Long id, Location location) {
        return dao.update(id, location);
    }

}
