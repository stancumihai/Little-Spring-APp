package com.stancumihai.api.sportLocations;


import com.stancumihai.model.Location;
import com.stancumihai.model.Sport;
import com.stancumihai.service.SportLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sportLocations/api")
public class sportLocationsController {

    private final SportLocationsService sportLocationsService;

    @Autowired
    public sportLocationsController(SportLocationsService sportLocationsService) {
        this.sportLocationsService = sportLocationsService;
    }

    @GetMapping
    public List<Sport> getSportsByLocation(@RequestBody Location location) {
        return sportLocationsService.getSportsByLocation(location);
    }

    @GetMapping
    public List<Location> getLocationsBySport(@RequestBody Sport sport) {
        return sportLocationsService.getLocationsBySport(sport);
    }
}
