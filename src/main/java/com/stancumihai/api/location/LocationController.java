package com.stancumihai.api.location;


import com.stancumihai.model.Country;
import com.stancumihai.model.Local;
import com.stancumihai.model.Location;
import com.stancumihai.model.Region;
import com.stancumihai.service.CountryService;
import com.stancumihai.service.LocalService;
import com.stancumihai.service.LocationService;
import com.stancumihai.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("location/api")
public class LocationController {

    private final LocationService locationService;
    private final CountryService countryService;
    private final LocalService localService;
    private final RegionService regionService;

    @Autowired
    public LocationController(LocationService locationService,
                              CountryService countryService,
                              LocalService localService,
                              RegionService regionService) {
        this.locationService = locationService;
        this.countryService = countryService;
        this.localService = localService;
        this.regionService = regionService;
    }


    @PostMapping
    public int create(@RequestBody Location location) {
        return locationService.create(location);
    }

    @GetMapping
    public List<Location> selectAll() {
        return locationService.selectAll();
    }

    @GetMapping("{id}")
    public Location findById(@PathVariable("id") Long id) {
        return locationService.findById(id);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id) {
        return locationService.delete(id);
    }

    @PutMapping("{id}")
    public Location update(@PathVariable("id") Long id, @RequestBody Location location) {
        return locationService.update(id, location);
    }

    @GetMapping("local/{id}")
    public Local getLocalByLocationId(@PathVariable("id") Long id) {
        return localService.getLocalByLocationId(id);
    }

    @GetMapping("region/{id}")
    public Country getCountryByLocationId(@PathVariable("id") Long id) {
        return countryService.getCountryByLocationId(id);
    }

    @GetMapping("country/{id}")
    public Region getRegionByLocationId(@PathVariable("id") Long id) {
        return regionService.getRegionByLocationId(id);
    }
}
