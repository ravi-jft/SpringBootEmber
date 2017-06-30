package com.goGame.service;


import com.goGame.domain.Attribute;
import com.goGame.domain.Event;

import java.util.List;
import java.util.Set;


/**
 * Created by ravi on 27/6/17.
 */
public interface EventService {
    public void addEvent(Event event);

    public List<Event> getAllData();

    public void deleteData(Long id);

    public Event findRecord(Long id);

    public void addAttribute(Attribute attribute);
}
