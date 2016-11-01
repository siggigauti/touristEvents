package com.HBV501.touristEvents.dao;

import com.HBV501.touristEvents.model.Event;
import com.HBV501.touristEvents.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Siggigauti on 01/11/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class,id);
        Hibernate.initialize(user.getBookings());
        Hibernate.initialize(user.getEvents());
        session.close();
        return user;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
