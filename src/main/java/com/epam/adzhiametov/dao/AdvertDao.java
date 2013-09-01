package com.epam.adzhiametov.dao;

import com.epam.adzhiametov.model.Advert;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@Repository
public class AdvertDao extends JpaDao<Advert> {
    @Override
    public Class<Advert> getEntityClass() {
        return Advert.class;
    }

    public List<Advert> findRange(int page, int count) {
        Query query = getSession().createQuery("from " + getEntityClass().getName() + " a order by a.time desc");
        query.setMaxResults(count);
        query.setFirstResult((page-1)*count);
        return (List<Advert>) query.list();
    }

    public List<Advert> find(String phone) {
        Query query = getSession().createQuery("from " + getEntityClass().getName() + " a where a.phone = :param order by a.time desc");
        query.setString("param", phone);
        return (List<Advert>) query.list();
    }
}
