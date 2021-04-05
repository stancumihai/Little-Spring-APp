package com.stancumihai.dao.sportLocations;

import com.stancumihai.model.Location;
import com.stancumihai.model.Sport;
import com.stancumihai.model.SportLocations;

import java.util.List;

public interface SportLocationsDao {

    List<Sport> getSportsByLocation(Location location);

    List<Location> getLocationsBySport(Sport sport);

    SportLocations update(Long id,SportLocations element);

    SportLocations create(SportLocations element);

    SportLocations findById(Long id);

    int deleteById(Long id);

    List<SportLocations> selectAll();
}
