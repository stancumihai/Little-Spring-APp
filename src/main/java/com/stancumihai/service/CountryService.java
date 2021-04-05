package com.stancumihai.service;

import com.stancumihai.dao.Dao;
import com.stancumihai.model.Country;
import com.stancumihai.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final Dao<Country> dao;
    private final LocationService locationService;

    @Autowired
    public CountryService(@Qualifier("CountryDao") Dao<Country> dao, LocationService locationService) {
        this.dao = dao;
        this.locationService = locationService;
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

    public Location getLocationByCountryId(Long id) {
        for (Country country : selectAll()) {
            if (country.getLocation().getId().equals(id)) {
                System.out.println( locationService.findById(country.getLocation().getId()).getName());
                return locationService.findById(country.getLocation().getId());
            }
        }
        return null;
    }
}
