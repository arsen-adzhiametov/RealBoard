package com.epam.adzhiametov.dao;

import java.util.List;

public interface GenericDao<T> {

    void create(T newInstance);

    T read(long id);

    void delete(T persistentObject);

    List<T> findAll();

}