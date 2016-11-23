package com.HBV501.touristEvents.service;

import com.HBV501.touristEvents.model.Booking;
import com.HBV501.touristEvents.model.Event;
import com.HBV501.touristEvents.model.User;


/**
 * Created by Siggigauti on 22/11/2016.
 */
public class BookingServiceImpl implements BookingService {
    @Override
    public void bookEvent(Event event, User user) {
        Booking booking = new Booking();
        booking.setCapacity(1);
        booking.setEvent(event);
        booking.setUser(user);

    }
}
