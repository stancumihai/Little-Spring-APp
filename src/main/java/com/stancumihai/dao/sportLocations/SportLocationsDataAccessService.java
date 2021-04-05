package com.stancumihai.dao.sportLocations;


import com.stancumihai.mapper.LocationRowMapper;
import com.stancumihai.mapper.SportLocationsRowMapper;
import com.stancumihai.mapper.SportRowMapper;
import com.stancumihai.model.Location;
import com.stancumihai.model.Sport;
import com.stancumihai.model.SportLocations;
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
        String sql = "SELECT s.id,s.name,s.startPeriod,s.endPeriod from sport s inner join " +
                "sportLocations sL on s.id = sL.sport inner join location l on l.id=sL.location";
        return jdbcTemplate.query(sql, new SportRowMapper());
    }

    @Override
    public List<Location> getLocationsBySport(Sport sport) {
        String sql = "SELECT l.id,l.name from sport s inner join sportLocations sL on s.id = " +
                "sL.sport inner join location l on l.id=sL.location";
        return jdbcTemplate.query(sql, new LocationRowMapper());
    }

    @Override
    public SportLocations update(Long id, SportLocations element) {
        String sql = "update sportLocations set location=?,sport=? where id=?";
        int updated = jdbcTemplate.update(sql, element.getLocation(), element.getSport(), element.getId());
        if (updated != 0) {
            return element;
        } else return null;
    }

    @Override
    public int create(SportLocations element) {
        String sql = "Insert into sportLocations(location,sport) values(?,?)";
        return jdbcTemplate.update(sql, element.getId(), element.getLocation(), element.getSport());
    }

    @Override
    public SportLocations findById(Long id) {
        String sql = "Select * from aplicatie.sportlocations where id=?";
        return jdbcTemplate.queryForObject(sql, new SportLocationsRowMapper(), id);
    }

    @Override
    public int deleteById(Long id) {
        String sql = "Delete from aplicatie.sportlocations where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<SportLocations> selectAll() {
        String sql = "SELECT * FROM aplicatie.sportlocations";
        return jdbcTemplate.query(sql, new SportLocationsRowMapper());
    }
}
