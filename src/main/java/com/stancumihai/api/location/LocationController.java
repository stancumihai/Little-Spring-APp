package com.stancumihai.api.location;


import com.stancumihai.model.Location;
import com.stancumihai.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("location/api")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public int create(@RequestBody Location location) {
        return locationService.create(location);
    }

    @GetMapping
    public List<Location> selectAll(){
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
}
