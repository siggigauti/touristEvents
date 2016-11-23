package com.HBV501.touristEvents.service;

import com.HBV501.touristEvents.dao.BookingDao;
import com.HBV501.touristEvents.model.Booking;
import com.HBV501.touristEvents.model.Event;
import com.HBV501.touristEvents.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Siggigauti on 22/11/2016.
 */
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDao bookingDao;
    @Override
    public void bookEvent(Event event, User user) {
        Booking booking = new Booking();
        booking.setCapacity(1);
        booking.setEvent(event);
        booking.setUser(user);
        save(booking);
    }

    @Override
    public void save(Booking booking){
        bookingDao.save(booking);
    }
}
