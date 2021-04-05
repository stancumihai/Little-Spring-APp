package com.stancumihai.service;

import com.stancumihai.dao.Dao;
import com.stancumihai.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final Dao<Location> dao;

    public LocationService(Dao<Location> dao) {
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
        Location location1 = new Location(id, location.getName());
        System.out.println(location1.getName());
        return dao.update(id, location1);
    }
}
