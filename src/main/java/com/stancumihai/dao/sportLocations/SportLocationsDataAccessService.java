package com.stancumihai.dao.sportLocations;

import com.stancumihai.dao.Dao;
import com.stancumihai.model.SportLocations;

import java.util.List;

public class SportLocationsDataAccessService implements Dao<SportLocations> {
    @Override
    public SportLocations update(Long id, SportLocations element) {
        return null;
    }

    @Override
    public int create(SportLocations element) {
        return 0;
    }

    @Override
    public SportLocations findById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<SportLocations> selectAll() {
        return null;
    }
}
