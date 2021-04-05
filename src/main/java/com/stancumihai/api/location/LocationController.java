package com.stancumihai.api.location;


import com.stancumihai.model.Location;
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
    private final LocalService localService;
    private final RegionService regionService;
    private final CountryService countryService;

    @Autowired
    public LocationController(LocationService locationService, LocalService localService,
                              RegionService regionService, CountryService countryService) {
        this.locationService = locationService;
        this.localService = localService;
        this.countryService = countryService;
        this.regionService = regionService;
    }

    /**
     * It works
     */
    @PostMapping
    public int create(@RequestBody Location location) {
        return locationService.create(location);
    }
    /**
     * It works
     */
    @GetMapping
    public List<Location> selectAll() {
        return locationService.selectAll();
    }
    /**
     * It works
     */
    @GetMapping("{id}")
    public Location findById(@PathVariable("id") Long id) {
        return locationService.findById(id);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id) {
        return locationService.delete(id);
    }
    /**
     * It works
     */
    @PutMapping("{id}")
    public Location update(@PathVariable("id") Long id, @RequestBody Location location) {
        return locationService.update(id, location);
    }

    /**
     * It works
     */
    @GetMapping("local/{id}")
    public Location getLocationByLocalId(@PathVariable("id") Long id) {
        return localService.getLocationByLocalId(id);
    }

    /**
     * It works
     */
    @GetMapping("country/{id}")
    public Location getLocationByCountryId(@PathVariable("id") Long id) {
        return countryService.getLocationByCountryId(id);
    }

    /**
     * It works
     */
    @GetMapping("region/{id}")
    public Location getLocationByRegionId(@PathVariable("id") Long id) {
        return regionService.getLocationByRegionId(id);
    }
}
