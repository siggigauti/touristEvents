package com.HBV501.touristEvents.web.controller;

import com.HBV501.touristEvents.model.Booking;
import com.HBV501.touristEvents.model.Event;
import com.HBV501.touristEvents.model.User;
import com.HBV501.touristEvents.service.EventService;
import com.HBV501.touristEvents.service.UserService;
import com.HBV501.touristEvents.web.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siggigauti on 15/10/2016.
 */
@Controller
public class eventController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @SuppressWarnings("unchecked")
    @RequestMapping("/events")
    public String listEvents(Model model) {
        List<Event> events = eventService.findAll();
        model.addAttribute("events",events);

        return "event/event";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/")
    public String HomeEvents(Model model) {
        return "redirect:/events";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/event/booked")
    public String bookEvents(Model model) {
        List<Event> events = eventService.findAll();
        List<User> user = userService.findAll();
        model.addAttribute("events",events);
        model.addAttribute("user", user);

        return "event/booked";
    }


    @RequestMapping("/events/{eventId}")
    public String event(@PathVariable Long eventId, Model model){
        Event event = eventService.findById(eventId);
        model.addAttribute("event", event);

        return "event/info";
    }

    // Form for adding a new event
    @RequestMapping("/events/add")
    public String formNewCategory(Model model) {
        if(!model.containsAttribute("event")) {
            model.addAttribute("event",new Event());
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("action","/events");
        model.addAttribute("heading","New Event");
        model.addAttribute("submit","Add");

        return "eventForm";
    }

    // Add a event
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public String addCategory(@Valid Event event, BindingResult result, RedirectAttributes redirectAttributes, HttpSession session) {
        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.event",result);
            redirectAttributes.addFlashAttribute("event", event);
            return "redirect:/events/add";
        }

        //Hard coding user with ID 1 to be owner of this event
        event.setOwner(userService.findById(Long.valueOf(1)));

        //This should work if session has userId
        /*User user = userService.findById((Long)session.getAttribute("userId"));
        event.setOwner(user);*/
        eventService.save(event);

        return "redirect:/events";
    }

    // Form for editing an existing category
    @RequestMapping("events/{eventId}/edit")
    public String EditEventForm(@PathVariable Long eventId, Model model) {
        // TODO: Add model attributes needed for new form
        if(!model.containsAttribute("event")) {
            model.addAttribute("event",eventService.findById(eventId));
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("action", "/events");
        model.addAttribute("heading","Edit Event");
        model.addAttribute("submit","Update");

        return "eventForm";
    }
}
