package com.stancumihai.dao.sportLocations;


import com.stancumihai.mapper.LocationRowMapper;
import com.stancumihai.mapper.SportLocationsRowMapper;
import com.stancumihai.mapper.SportRowMapper;
import com.stancumihai.model.Location;
import com.stancumihai.model.Sport;
import com.stancumihai.model.SportLocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository("SportLocationRepo")
public class SportLocationsDataAccessService implements SportLocationsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
    public SportLocations create(SportLocations element) {
        String sql = "Insert into sportLocations(location,sport) values(:sport,:location)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("sport", element.getSport())
                .addValue("location", element.getLocation());
        namedParameterJdbcTemplate.update(sql,parameters,holder);
        element.setId(Objects.requireNonNull(holder.getKey()).longValue());
        return element;
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
