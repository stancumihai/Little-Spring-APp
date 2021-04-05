package com.stancumihai.service;

import com.stancumihai.dao.sportLocations.SportLocationsDataAccessService;
import com.stancumihai.model.Location;
import com.stancumihai.model.Sport;
import com.stancumihai.model.SportLocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportLocationsService {

    private final SportLocationsDataAccessService sportLocationsDataAccessService;
    private final SportService sportService;

    @Autowired
    public SportLocationsService(@Qualifier("SportLocationRepo") SportLocationsDataAccessService sportLocationsDataAccessService
            , SportService sportService) {
        this.sportLocationsDataAccessService = sportLocationsDataAccessService;
        this.sportService = sportService;
    }

    public List<Sport> getSportLocationsStartPeriods(String startDate) {
        List<Sport> toBeAdded = new ArrayList<>();
        List<Sport> sportList = sportService.selectAll();
        for (Sport sport : sportList) {
            if (sport.getStartPeriod().equals(startDate)) {
                toBeAdded.add(sport);
            }
        }
        return toBeAdded;
    }

    public List<Sport> getSportLocationsEndPeriods(String endDate) {
        List<Sport> toBeAdded = new ArrayList<>();
        List<Sport> sportList = sportService.selectAll();
        for (Sport sport : sportList) {
            if (sport.getEndPeriod().equals(endDate)) {
                toBeAdded.add(sport);
            }
        }

        return toBeAdded;
    }

    public List<Sport> getSportsByLocation(Location location) {
        return sportLocationsDataAccessService.getSportsByLocation(location);
    }

    public List<Location> getLocationsBySport(Sport sport) {
        return sportLocationsDataAccessService.getLocationsBySport(sport);
    }


    public SportLocations update(Long id,SportLocations element) {

        return sportLocationsDataAccessService.update(id,element);
    }


    public int create(SportLocations element) {
        return sportLocationsDataAccessService.create(element);
    }


    public SportLocations findById(Long id) {
        return sportLocationsDataAccessService.findById(id);
    }


    public int deleteById(Long id) {
        return sportLocationsDataAccessService.deleteById(id);
    }


    public List<SportLocations> selectAll() {
        return sportLocationsDataAccessService.selectAll();
    }
}
