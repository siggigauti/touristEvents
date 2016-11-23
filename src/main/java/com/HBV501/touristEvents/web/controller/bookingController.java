package com.HBV501.touristEvents.web.controller;

import com.HBV501.touristEvents.model.Booking;
import com.HBV501.touristEvents.model.Event;
import com.HBV501.touristEvents.model.User;
import com.HBV501.touristEvents.service.BookingService;
import com.HBV501.touristEvents.service.EventService;
import com.HBV501.touristEvents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Siggigauti on 22/11/2016.
 */
public class bookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;

    // to be continued: Booking an event.

    @RequestMapping(value = "/event/{eventId}/book", method = RequestMethod.POST)
    public String bookNewEvent(Model model, HttpSession session, @PathVariable Long eventId) {
        User user = userService.findById((Long)session.getAttribute("userId"));
        Event event = eventService.findById(eventId);
        bookingService.bookEvent(event, user);

        return "event/booked";
    }
}
