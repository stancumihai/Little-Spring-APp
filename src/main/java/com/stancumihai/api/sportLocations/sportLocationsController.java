package com.stancumihai.api.sportLocations;


import com.stancumihai.model.Location;
import com.stancumihai.model.Sport;
import com.stancumihai.model.SportLocations;
import com.stancumihai.service.SportLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sportLocations/api")
public class sportLocationsController {

    private final SportLocationsService sportLocationsService;

    @Autowired
    public sportLocationsController(SportLocationsService sportLocationsService) {
        this.sportLocationsService = sportLocationsService;
    }

    /**
     * It works
     */
    @GetMapping("sportLoc")
    public List<Sport> getSportsByLocation(@RequestBody Location location) {
        return sportLocationsService.getSportsByLocation(location);
    }

    /**
     * It works
     */
    @GetMapping("locSport")
    public List<Location> getLocationsBySport(@RequestBody Sport sport) {
        return sportLocationsService.getLocationsBySport(sport);
    }

    @PutMapping("{id}")
    public SportLocations update(@PathVariable("id") Long id, @RequestBody SportLocations element) {
        return sportLocationsService.update(id, element);
    }

    // TODO: 4/5/2021 Fix This
    @PostMapping
    public int create(@RequestBody SportLocations element) {
        return sportLocationsService.create(element);
    }

    /**
     * It works
     */
    @GetMapping("{id}")
    public SportLocations findById(@PathVariable Long id) {
        return sportLocationsService.findById(id);
    }

    /**
     * It works
     */
    @DeleteMapping("{id}")
    public int deleteById(@PathVariable("id") Long id) {
        return sportLocationsService.deleteById(id);
    }

    /**
     * It works
     */
    @GetMapping
    public List<SportLocations> selectAll() {
        return sportLocationsService.selectAll();
    }
}
