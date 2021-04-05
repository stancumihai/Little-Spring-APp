package com.stancumihai.dao.location;

import com.stancumihai.dao.Dao;
import com.stancumihai.mapper.LocalRowMapper;
import com.stancumihai.model.Local;
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

@Repository("LocalDao")
public class LocalDataAccessService implements Dao<Local> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Local update(Long id, Local country) {
        String sql = "UPDATE local set location=? where id=?";
        jdbcTemplate.update(sql, country.getLocation(), country.getId());

        return country;
    }

    @Override
    public Local create(Local local) {
        String sql = "INSERT into local(location) values (:location)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("location", local.getLocation());
        namedParameterJdbcTemplate.update(sql, parameters, holder);
        local.setId(Objects.requireNonNull(holder.getKey()).longValue());
        return local;
    }

    @Override
    public Local findById(Long id) {
        String sql = "SELECT * from aplicatie.local where id =?";
        return jdbcTemplate.queryForObject(sql, new LocalRowMapper(), id);
    }

    @Override
    public int deleteById(Long id) {
        if (findById(id) != null) {
            String sql = "delete from local where id=?";
            return jdbcTemplate.update(sql, id);
        }
        return -1;
    }

    @Override
    public List<Local> selectAll() {
        String sql = "Select *from local";
        return jdbcTemplate.query(sql, new LocalRowMapper());
    }

}
