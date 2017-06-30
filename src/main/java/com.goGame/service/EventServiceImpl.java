package com.goGame.service;

import com.goGame.Dao.AttributeDao;
import com.goGame.Dao.EventDao;
import com.goGame.domain.Attribute;
import com.goGame.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by ravi on 27/6/17.
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventDao eventDao;


    @Autowired
    private AttributeDao attributeDao;

    public void addEvent(Event event) {
        eventDao.save(event);
    }

    public List<Event> getAllData() {
        return (List<Event>) eventDao.findAll();
    }

    public void deleteData(Long id) {
        eventDao.delete(id);
    }

    public Event findRecord(Long id) {
        return eventDao.findOne(id);
    }

    public void addAttribute(Attribute attribute) {
        System.out.println("=======attribute in eventServiceImpl======="+ attribute);
        attributeDao.save(attribute);
    }
}
