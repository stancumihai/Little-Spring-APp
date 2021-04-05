package com.stancumihai.mapper;

import com.stancumihai.model.Country;
import com.stancumihai.model.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {


    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();
        country.setId(resultSet.getLong("id"));
        Location location = new Location();
        location.setId(resultSet.getLong("location"));
        country.setLocation(location);
        country.setName(country.getLocation().getName());
        return country;
    }
}
