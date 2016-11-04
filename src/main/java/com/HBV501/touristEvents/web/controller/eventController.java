package com.HBV501.touristEvents.web.controller;

import com.HBV501.touristEvents.model.Event;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        // TODO: Get all events
        List<Event> events = eventService.findAll();

        model.addAttribute("events",events);
        return "home";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/")
    public String HomeEvents(Model model) {
        // TODO: Get all events
        List<Event> events = eventService.findAll();

        model.addAttribute("events",events);
        return "layout";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/evento")
    public String addEvents(Model model) {
        // TODO: Get all events
        List<Event> events = eventService.findAll();

        model.addAttribute("events",events);
        return "event/event";
    }

    @RequestMapping("/events/{eventId}")
    public String event(@PathVariable Long eventId, Model model){
        // TODO: Get the event given by eventId
        Event event = eventService.findById(eventId);

        model.addAttribute("event", event);

        return "eventDetails";
    }

    // Form for adding a new event
    @RequestMapping("/events/add")
    public String formNewCategory(Model model) {
        // TODO: Add model attributes needed for new form
        if(!model.containsAttribute("event")) {
            model.addAttribute("event",new Event());
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("action","/events");
        model.addAttribute("heading","New Event");
        model.addAttribute("submit","Add");

        return "eventForm";
    }

    // Add a category
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public String addCategory(@Valid Event event, BindingResult result, RedirectAttributes redirectAttributes) {
        // TODO: Add category if valid data was received
        if(result.hasErrors()) {
            // Include validation errors upon redirect
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.category",result);

            // Add  category if invalid was received
            redirectAttributes.addFlashAttribute("event", event);

            // Redirect back to the form
            return "redirect:/events/add";
        }

        event.setOwner(userService.findById(Long.valueOf(1)));
        eventService.save(event);

        // TODO: Redirect browser to /categories
        return "redirect:/events";
    }

    @RequestMapping("/test")
    public String testPage() {
        //Þetta home er nafn á html skjali undir resources/templates. Öll html skjöl verða þar.
        return "testFile";
    }
}
