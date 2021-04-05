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
        this.locationService = locationService;

    }

    public Local findById(Long id) {
        return dao.findById(id);
    }

    public Local create(Local local) {
        Local createdLocal = dao.create(local);
        createdLocal.setLocation(locationService.findById(createdLocal.getLocation().getId()));
        return createdLocal;
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

    public Location getLocationByLocalId(Long id) {
        for (Local local : selectAll()) {
            if (local.getLocation().getId().equals(id)) {
                return locationService.findById(local.getLocation().getId());
            }
        }
        return null;
    }
}
