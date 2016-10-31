package com.HBV501.touristEvents.service;

import com.HBV501.touristEvents.dao.EventDao;
import com.HBV501.touristEvents.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Siggigauti on 31/10/2016.
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventDao eventDao;

    @Override
    public void save(Event event) {

    }

    @Override
    public void delete(Event event) {

    }

    @Override
    public List<Event> findAll() {
        return eventDao.findAll();
    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public Event findByCategory(String category) {
        return null;
    }

    @Override
    public Event findByName(String name) {
        return null;
    }

}
