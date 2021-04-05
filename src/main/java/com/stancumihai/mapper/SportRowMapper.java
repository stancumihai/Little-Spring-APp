package com.stancumihai.mapper;

import com.stancumihai.model.Sport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SportRowMapper implements RowMapper<Sport> {
    @Override
    public Sport mapRow(ResultSet resultSet, int i) throws SQLException {
        Sport sport = new Sport();
        sport.setId(resultSet.getLong("id"));
        sport.setName(resultSet.getString("name"));
        sport.setStartPeriod(resultSet.getString("startPeriod"));
        sport.setEndPeriod(resultSet.getString("endPeriod"));
        sport.setPrice(resultSet.getFloat("price"));
        return sport;
    }
}
