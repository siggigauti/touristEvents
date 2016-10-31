package com.HBV501.touristEvents.web.controller;

import com.HBV501.touristEvents.model.Event;
import com.HBV501.touristEvents.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Siggigauti on 15/10/2016.
 */
@Controller
public class eventController {

    @Autowired
    private EventService eventService;

    @SuppressWarnings("unchecked")
    @RequestMapping("/")
    public String listEvents(Model model) {
        // TODO: Get all events
        List<Event> events = eventService.findAll();

        model.addAttribute("events",events);
        return "home";
    }

    @RequestMapping("/test")
    public String testPage() {
        //Þetta home er nafn á html skjali undir resources/templates. Öll html skjöl verða þar.
        return "testFile";
    }
}
