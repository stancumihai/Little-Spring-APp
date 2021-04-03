package com.stancumihai.test.dao;

public interface Dao<T> {

    T update(Long id);

    T create(T element);

    T findById(Long id);

    T deleteById(Long id);

    T update(T element, Long id);

}
