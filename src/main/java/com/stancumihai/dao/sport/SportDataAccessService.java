package com.stancumihai.dao.sport;

import com.stancumihai.dao.Dao;
import com.stancumihai.mapper.SportRowMapper;
import com.stancumihai.model.Sport;
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

@Repository("SportDao")
public class SportDataAccessService implements Dao<Sport> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Sport update(Long id, Sport sport) {

        String sql = "UPDATE sport set startPeriod=?,endPeriod=?,name=? where id=?";
        int updated = jdbcTemplate.update(sql, sport.getStartPeriod(), sport.getEndPeriod(),
                sport.getName(), sport.getId());
        if (updated == 1) {
            return sport;
        } else return null;
    }

    @Override
    public Sport create(Sport element) {
        String sql = "INSERT into sport(startPeriod,endPeriod,name) values (:name,:startPeriod,:endPeriod)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", element.getName())
                .addValue("startPeriod", element.getStartPeriod())
                .addValue("endPeriod", element.getEndPeriod());
        namedParameterJdbcTemplate.update(sql, parameters, holder);
        element.setId(Objects.requireNonNull(holder.getKey()).longValue());
        return element;
    }

    @Override
    public Sport findById(Long id) {
        String sql = "SELECT * FROM sport where id =?";
        return jdbcTemplate.queryForObject(sql, new SportRowMapper(), id);
    }

    @Override
    public int deleteById(Long id) {
        String sql = "DELETE from sport where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Sport> selectAll() {
        String sql = "SELECT * from sport";
        return jdbcTemplate.query(sql, new SportRowMapper());
    }
}
