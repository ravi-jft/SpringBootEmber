package com.goGame.controller;

import com.goGame.commands.Dataparam;
import com.goGame.domain.Event;
import com.goGame.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ravi on 27/6/17.
 */
@RequestMapping("/event")
@CrossOrigin
@RestController
public class EventController {

    @Autowired
    private EventService eventService;


    @RequestMapping(value = "/create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrUpdate(@RequestBody Event event){
        eventService.addEvent(event);
    }

    @RequestMapping(value = "/create11",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrUpdate12(@RequestBody Dataparam dataparam){
        System.out.println("===attribute===="+dataparam.getAttribute());
        eventService.addAttribute(dataparam.getAttribute());
    }

    @RequestMapping(value = "/getAllData",method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public List<Event> getAll(){
        return eventService.getAllData();
    }

    @RequestMapping(value = "/getOneRecord/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Event getOneData(@PathVariable(value = "id") Long id){
        return eventService.findRecord(id);
    }

    @RequestMapping(value = "/deleteOneRecord/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteData(@PathVariable(value = "id") Long id){
        eventService.deleteData(id);
    }
}
