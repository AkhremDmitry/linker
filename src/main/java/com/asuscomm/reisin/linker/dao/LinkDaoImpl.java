package com.asuscomm.reisin.linker.dao;

import com.asuscomm.reisin.linker.model.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class LinkDaoImpl implements LinkDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public int save(Link link) {
        sessionFactory.getCurrentSession().save(link);
        return link.getId();
    }

    @Override
    public Link get(int id) {
        return sessionFactory.getCurrentSession().get(Link.class, id);
    }

    @Override
    public List<Link> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Link> cq = cb.createQuery(Link.class);
        Root<Link> root = cq.from(Link.class);
        cq.select(root);
        Query<Link> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(int id, Link link) {
        Session session = sessionFactory.getCurrentSession();
        Link link2 = session.byId(Link.class).load(id);
        link2.setName(link.getName());
        session.flush();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Link link = session.byId(Link.class).load(id);
        session.delete(link);
    }
}
