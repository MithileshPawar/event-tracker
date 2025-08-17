package com.example.controllers;

import com.example.models.Event;
import com.example.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping(path = "{eventId}")
    public Event getEventById(@PathVariable("eventId") Integer eventId) {
        return eventService.getEventById(eventId);
    }


    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "{eventId}")
    public Event updateEvent(@PathVariable("eventId") Integer eventId, @RequestParam(required = false) String name) {
        return eventService.updateEvent(eventId, name);
    }

    @DeleteMapping(path = "{eventId}")
    public void deleteEvent(@PathVariable("eventId") Integer eventId) {
        eventService.deleteEvent(eventId);

    }
}
