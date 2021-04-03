package com.stancumihai.dao.sportLocations;

import com.stancumihai.model.Location;
import com.stancumihai.model.Sport;

import java.util.List;

public interface SportLocationsDao {

    List<Sport> getSportsByLocation(Location location);
    List<Location> getLocationsBySport(Sport sport);
}
