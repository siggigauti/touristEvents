package com.HBV501.touristEvents.service;

import com.HBV501.touristEvents.model.Event;

import java.util.List;

/**
 * Created by Siggigauti on 31/10/2016.
 */
public interface EventService {
    void save(Event event);
    void delete(Event event);
    List<Event> findAll();
    Event findById(Long id);
    Event findByCategory(String category);
    Event findByName(String name);
}
