package com.stancumihai.service;

import com.stancumihai.dao.Dao;
import com.stancumihai.model.Local;
import com.stancumihai.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {

    private final Dao<Local> dao;
    private final LocationService locationService;

    @Autowired
    public LocalService(@Qualifier("LocalDao") Dao<Local> dao, LocationService locationService) {
        this.dao = dao;
        this.locationService=locationService;
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

    public Local getLocalByLocationId(Long id) {
        Local local = findById(id);
        Location location = locationService.findById(id);
        local.setLocation(location);
        return local;
    }
}
