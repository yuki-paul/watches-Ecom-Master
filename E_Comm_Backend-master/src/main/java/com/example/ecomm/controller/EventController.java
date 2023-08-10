package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.Event;
import com.example.ecomm.repository.EventRepository;

@RestController
@CrossOrigin
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    
    //for deleting the event from the db
    @DeleteMapping("/deleteEvent/{id}")
    public String delete(@PathVariable int id) {
    	eventRepository.deleteById(id);
        return "Event Deleted";
    }
    
    
    @GetMapping("/getallevent")
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.ok(eventRepository.findAll());
    }

    @PostMapping("/Addevent")
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return ResponseEntity.ok("Event Added");
    }

}
