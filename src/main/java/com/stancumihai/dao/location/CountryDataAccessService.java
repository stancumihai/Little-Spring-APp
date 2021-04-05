package com.stancumihai.dao.location;

import com.stancumihai.dao.Dao;
import com.stancumihai.mapper.CountryRowMapper;
import com.stancumihai.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CountryDao")
public class CountryDataAccessService implements Dao<Country> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Country update(Long id, Country country) {
        String sql = "UPDATE country set location=? where id=?";
        jdbcTemplate.update(sql, country.getLocation(), country.getId());

        return country;
    }

    @Override
    public Country create(Country country) {
        String sql = "INSERT into country(location) values (?)";
        jdbcTemplate.update(sql, country.getLocation());
        return country;
    }

    @Override
    public Country findById(Long id) {
        String sql = "SELECT * from aplicatie.country where id =?";

        return jdbcTemplate.queryForObject(sql, new CountryRowMapper(), id);
    }

    @Override
    public int deleteById(Long id) {
        if (findById(id) != null) {
            String sql = "delete from country where id=?";
            return jdbcTemplate.update(sql, id);
        }
        return -1;
    }

    @Override
    public List<Country> selectAll() {
        String sql = "Select *from country";
        return jdbcTemplate.query(sql, new CountryRowMapper());
    }
}
