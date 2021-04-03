package com.stancumihai.mapper;

import com.stancumihai.model.Local;
import com.stancumihai.model.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalRowMapper implements RowMapper<Local> {
    @Override
    public Local mapRow(ResultSet resultSet, int i) throws SQLException {
        Local local = new Local();
        local.setId(resultSet.getLong("id"));
        Location location = new Location();
        location.setId(resultSet.getLong("location"));
        local.setLocation(location);
        return local;
    }
}
