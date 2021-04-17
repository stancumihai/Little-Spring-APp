package com.stancumihai.dao.location;


import com.stancumihai.dao.Dao;
import com.stancumihai.mapper.RegionRowMapper;
import com.stancumihai.model.Region;
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

@Repository("RegionDao")
public class RegionDataAccessService implements Dao<Region> {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Region update(Long id, Region region) {
        String sql = "UPDATE region set location=? where id=?";
        jdbcTemplate.update(sql, region.getLocation().getId(), region.getId());

        return region;
    }

    @Override
    public Region create(Region region) {
        String sql = "INSERT into region(location) values (:location)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("location", region.getLocation().getId());
        namedParameterJdbcTemplate.update(sql, parameters, holder);
        region.setId(Objects.requireNonNull(holder.getKey()).longValue());
        return region;
    }

    @Override
    public Region findById(Long id) {
        String sql = "SELECT * from aplicatie.region where id =?";
        return jdbcTemplate.queryForObject(sql, new RegionRowMapper(), id);
    }

    @Override
    public int deleteById(Long id) {
        if (findById(id) != null) {
            String sql = "delete from region where id=?";
            return jdbcTemplate.update(sql, id);
        }
        return -1;
    }

    @Override
    public List<Region> selectAll() {
        String sql = "Select *from region";
        return jdbcTemplate.query(sql, new RegionRowMapper());
    }
}
