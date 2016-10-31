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

    }

    @Override
    public void delete(Event event) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> findAll() {
        // Open a session
        Session session = sessionFactory.openSession();

        // DEPRECATED as of Hibernate 5.2.0
        // List<Category> categories = session.createCriteria(Category.class).list();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Event> criteria = builder.createQuery(Event.class);

        // Specify criteria root
        criteria.from(Event.class);

        // Execute query
        List<Event> events = session.createQuery(criteria).getResultList();

        // Close session
        session.close();

        return events;
    }

    @Override
    public Event findById(Long id) {
        return null;
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
