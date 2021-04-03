package com.stancumihai.dao;

import java.util.List;


public interface Dao<T> {

    T update(Long id,T element);

    int create(T element);

    T findById(Long id);

    int deleteById(Long id);

    List<T> selectAll( );

}
