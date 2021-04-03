package com.stancumihai.dao.sport;

import com.stancumihai.dao.Dao;
import com.stancumihai.mapper.SportRowMapper;
import com.stancumihai.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SportDao")
public class SportDataAccessService implements Dao<Sport> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
    public int create(Sport element) {
        String sql = "INSERT into sport(startPeriod,endPeriod,name) values (?,?,?)";
        return jdbcTemplate.update(sql, element.getStartPeriod(), element.getEndPeriod(), element.getName());
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
