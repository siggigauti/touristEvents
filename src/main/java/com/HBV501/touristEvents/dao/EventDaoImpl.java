package com.HBV501.touristEvents.dao;

import com.HBV501.touristEvents.model.Event;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


/**
 * Created by Siggigauti on 31/10/2016.
 */
@Repository
public class EventDaoImpl implements EventDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Event event) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(event);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Event event) {
        //Not implemented in this iteration
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Event> criteria = builder.createQuery(Event.class);
        criteria.from(Event.class);
        List<Event> events = session.createQuery(criteria).getResultList();
        session.close();
        return events;
    }

    @Override
    public Event findById(Long id) {
        Session session = sessionFactory.openSession();
        Event event = session.get(Event.class,id);
        Hibernate.initialize(event.getBookings());
        session.close();
        return event;
    }

    @Override
    public Event findByCategory(String category) {
        return null;
    }

    @Override
    public Event findByName(String name) {
        return null;
    }
}
