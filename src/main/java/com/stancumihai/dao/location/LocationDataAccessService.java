package com.stancumihai.dao.location;

import com.stancumihai.dao.Dao;
import com.stancumihai.mapper.LocationRowMapper;
import com.stancumihai.model.Location;
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

@Repository("LocationDao")
public class LocationDataAccessService implements Dao<Location> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Location update(Long id, Location location) {
        String sql = "UPDATE location set name=? where id=?";
        jdbcTemplate.update(sql, location.getName(), location.getId());

        return location;
    }

    @Override
    public Location create(Location element) {
        String sql = "INSERT into location(name) values (:name)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", element.getName());
        namedParameterJdbcTemplate.update(sql, parameters, holder);
        element.setId(Objects.requireNonNull(holder.getKey()).longValue());
        return element;
    }

    @Override
    public Location findById(Long id) {
        String sql = "SELECT * from location where id =?";
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
        String sql = "SELECT * FROM location ";
        return jdbcTemplate.query(sql, new LocationRowMapper());
    }
}
