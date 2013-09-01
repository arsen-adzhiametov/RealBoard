package com.epam.adzhiametov.dao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public abstract class JpaDao<T> extends HibernateDaoSupport implements GenericDao<T> {

    @Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

    @Override
    public void create(T newInstance) {
        getHibernateTemplate().save(newInstance);
    }

    @Override
    public T read(long id) {
        T t = getHibernateTemplate().get(getEntityClass(), id);
        return t;
    }

    @Override
    public void delete(T persistentObject) {
        getHibernateTemplate().delete(persistentObject);
    }

    @Override
    public List<T> findAll() {
        return getHibernateTemplate().find("from " + getEntityClass().getName() + " a order by a.time desc");
    }

    public abstract Class<T> getEntityClass();

}
