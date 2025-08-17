package com.example.services;

import com.example.models.Event;
import com.example.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Integer eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("EventId not found : " + eventId));
    }

    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEvent(Integer eventId) {
        System.out.println("Event deleted :" + eventId);
    }

    public Event updateEvent(Integer eventId, String name) {
        Event event = new Event(eventId, name);
        System.out.println("Event updated :" + event.toString());
        return event;
    }


}
