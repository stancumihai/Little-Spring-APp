package com.stancumihai.dao.location;

import com.stancumihai.dao.Dao;
import com.stancumihai.mapper.CountryRowMapper;
import com.stancumihai.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CountryDao")
public class CountryDataAccessService implements Dao<Country> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Country update(Long id, Country country) {
        String sql = "UPDATE country set location=? where id=?";
        jdbcTemplate.update(sql, country.getLocation(), country.getId());

        return country;
    }

    @Override
    public int create(Country country) {
        String sql = "INSERT into country(location) values (?)";
        return jdbcTemplate.update(sql, country.getLocation());
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
            return jdbcTemplate.update(sql, new CountryRowMapper(), id);
        }
        return -1;
    }

    @Override
    public List<Country> selectAll() {
        String sql = "Select *from country";
        return jdbcTemplate.query(sql, new CountryRowMapper());
    }
}
