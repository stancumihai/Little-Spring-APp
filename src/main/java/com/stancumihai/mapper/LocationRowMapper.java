package com.stancumihai.mapper;

import com.stancumihai.model.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper<Location> {
    @Override
    public Location mapRow(ResultSet resultSet, int i) throws SQLException {
        Location location = new Location();
        location.setId(resultSet.getLong("id"));
        location.setName(resultSet.getString("name"));
        return location;
    }
}
