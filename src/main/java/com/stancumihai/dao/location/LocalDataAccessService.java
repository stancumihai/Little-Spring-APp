package com.stancumihai.dao.location;

import com.stancumihai.dao.Dao;
import com.stancumihai.mapper.LocalRowMapper;
import com.stancumihai.model.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("LocalDao")
public class LocalDataAccessService implements Dao<Local> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Local update(Long id, Local country) {
        String sql = "UPDATE local set location=? where id=?";
        jdbcTemplate.update(sql, country.getLocation(), country.getId());

        return country;
    }

    @Override
    public int create(Local country) {
        String sql = "INSERT into local(location) values (?)";
        return jdbcTemplate.update(sql, country.getLocation());
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
            return jdbcTemplate.update(sql, new LocalRowMapper(), id);
        }
        return -1;
    }

    @Override
    public List<Local> selectAll() {
        String sql = "Select *from local";
        return jdbcTemplate.query(sql, new LocalRowMapper());
    }

}
