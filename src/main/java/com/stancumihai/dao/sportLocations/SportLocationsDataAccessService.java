package com.stancumihai.dao.sportLocations;


import com.stancumihai.mapper.LocationRowMapper;
import com.stancumihai.mapper.SportRowMapper;
import com.stancumihai.model.Location;
import com.stancumihai.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SportLocationRepo")
public class SportLocationsDataAccessService implements SportLocationsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Sport> getSportsByLocation(Location location) {
        String sql = "SELECT sport.id,sport.name,sport.startPeriod,sport.endPeriod from sport s inner join " +
                "sportLocations sL on s.id = sL.sport inner join location l on l.id=sL.location";
        return jdbcTemplate.query(sql, new SportRowMapper());
    }

    @Override
    public List<Location> getLocationsBySport(Sport sport) {
        String sql = "SELECT locattion.id,location.name from sport s inner join sportLocations sL on s.id = " +
                "sL.sport inner join location l on l.id=sL.location";
        return jdbcTemplate.query(sql, new LocationRowMapper());
    }
}
