package com.asuscomm.reisin.linker.dao;

import com.asuscomm.reisin.linker.model.Group;
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
public class GroupDaoImpl implements GroupDao {

    @Autowired
    SessionFactory sessionFactory;


    public int save(Group group) {
        sessionFactory.getCurrentSession().save(group);
        return group.getId();
    }

    public Group get(int id) {
        return sessionFactory.getCurrentSession().get(Group.class, id);
    }

    public List<Group> list() {


            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Group> cq = cb.createQuery(Group.class);
            Root<Group> root = cq.from(Group.class);
            cq.select(root);
            Query<Group> query = session.createQuery(cq);
            return query.getResultList();

    }

    public void update(int id, Group group) {
        Session session = sessionFactory.getCurrentSession();
        Group group2 = session.byId(Group.class).load(id);
        group2.setName(group.getName());
        session.flush();
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Group group = session.byId(Group.class).load(id);
        session.delete(group);
    }
}
