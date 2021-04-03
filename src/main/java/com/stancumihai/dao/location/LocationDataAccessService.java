package com.stancumihai.dao.location;

import com.stancumihai.dao.Dao;
import com.stancumihai.mapper.LocationRowMapper;
import com.stancumihai.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("LocationDao")
public class LocationDataAccessService implements Dao<Location> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Location update(Long id, Location location) {
        String sql = "UPDATE location set name=? where id=?";
        jdbcTemplate.update(sql, location.getName(), location.getId());

        return location;
    }

    @Override
    public int create(Location element) {
        String sql = "INSERT into location(name) values (?)";
        return jdbcTemplate.update(sql, element.getName());
    }

    @Override
    public Location findById(Long id) {
        String sql = "SELECT * from aplicatie.location where id =?";
        return jdbcTemplate.queryForObject(sql, new LocationRowMapper(), id);
    }

    @Override
    public int deleteById(Long id) {
        if (findById(id) != null) {
            String sql = "delete from location where id=?";
            return jdbcTemplate.update(sql, new LocationRowMapper(), id);
        }
        return -1;
    }

    @Override
    public List<Location> selectAll() {
        String sql = "SELECT * FROM aplicatie.location ";
        return jdbcTemplate.query(sql, new LocationRowMapper());
    }
}
