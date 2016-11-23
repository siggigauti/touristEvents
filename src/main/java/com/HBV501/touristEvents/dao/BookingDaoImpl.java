package com.HBV501.touristEvents.dao;

import com.HBV501.touristEvents.model.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Siggigauti on 22/11/2016.
 */
@Repository
public class BookingDaoImpl implements BookingDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Booking booking) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(booking);
        session.getTransaction().commit();
        session.close();
    }
}
