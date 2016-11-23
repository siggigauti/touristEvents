package com.HBV501.touristEvents.service;

import com.HBV501.touristEvents.model.Booking;
import com.HBV501.touristEvents.model.Event;
import com.HBV501.touristEvents.model.User;

/**
 * Created by Siggigauti on 22/11/2016.
 */
public interface BookingService {
    void bookEvent(Event event, User user);
    void save(Booking booking);
}
