package com.stancumihai.mapper;

import com.stancumihai.model.Location;
import com.stancumihai.model.Sport;
import com.stancumihai.model.SportLocations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SportLocationsRowMapper implements RowMapper<SportLocations> {


    @Override
    public SportLocations mapRow(ResultSet resultSet, int i) throws SQLException {
        SportLocations sportLocations = new SportLocations();
        sportLocations.setId(resultSet.getLong("id"));
        Sport sport = new Sport();
        sport.setId(resultSet.getLong("sport"));
        Location location = new Location();
        location.setId(resultSet.getLong("location"));
        sportLocations.setLocation(location);
        sportLocations.setSport(sport);
        return sportLocations;
    }
}
