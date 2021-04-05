package com.stancumihai.service;

import com.stancumihai.dao.Dao;
import com.stancumihai.model.Local;
import com.stancumihai.model.Location;
import com.stancumihai.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final Dao<Region> dao;
    private final LocationService locationService;


    @Autowired
    public RegionService(@Qualifier("RegionDao") Dao<Region> dao, LocationService locationService) {
        this.dao = dao;
        this.locationService = locationService;
    }

    public Region findById(Long id) {
        return dao.findById(id);
    }

    public Region create(Region region) {
        Region createdRegion = dao.create(region);
        createdRegion.setLocation(locationService.findById(createdRegion.getLocation().getId()));
        return createdRegion;
    }

    public int delete(Long id) {
        return dao.deleteById(id);
    }

    public List<Region> selectAll() {
        return dao.selectAll();
    }

    public Region update(Long id, Region region) {
        return dao.update(id, region);
    }

    public Location getLocationByRegionId(Long id) {
        for (Region region : selectAll()) {
            if (region.getLocation().getId().equals(id)) {
                return locationService.findById(region.getLocation().getId());
            }
        }
        return null;
    }
}
