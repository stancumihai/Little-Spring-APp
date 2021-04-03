package com.stancumihai.mapper;

import com.stancumihai.model.Location;
import com.stancumihai.model.Region;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionRowMapper implements RowMapper<Region> {
    @Override
    public Region mapRow(ResultSet resultSet, int i) throws SQLException {
        Region region = new Region();
        region.setId(resultSet.getLong("id"));
        Location location = new Location();
        location.setId(resultSet.getLong("location"));
        region.setLocation(location);
        return region;
    }
}
