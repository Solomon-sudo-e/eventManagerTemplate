package eventpackages.events.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import eventpackages.events.Entity.Event;
import eventpackages.events.Entity.EventCreation;
import eventpackages.events.service.EventService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class EventController {
	
	@Autowired
	EventService service;
	
	public EventController(EventService service) {
		this.service = service;
	}
	/*
	 * Event Entity
	 */
	
	@GetMapping("/event{event_id}")
	public Mono<Event> getEvent(@PathVariable Long event_id) {
		return service.getEvent(event_id);
	}
	
	@GetMapping("/event")
	public Flux<Event> getAllEvents() {
		return service.getAllEvents();
	}
	
	@PutMapping("/event/{event_id}")
	public Mono<Event> updateEvent(@PathVariable Long event_id, @RequestBody Mono<Event> event) {
		return service.updateEvent(event_id, event);
	}
	
	@PostMapping("/event")
	public Mono<Event> createEvent(@RequestBody Event event) {
		return service.createEvent(event);
	}
	
	@DeleteMapping("/event/{event_id}")
	public Mono<Void> deleteEvent(@PathVariable Long event_id) {
		return service.deleteEvent(event_id);
	}
	
	/*
	 * Event Creation Entity
	 */
	
	@GetMapping("/eventCr/{eventCr_id}")
	public Mono<EventCreation> getEventCreator(@PathVariable Long eventCr_id) {
		return service.getEventCreator(eventCr_id);
	}
	
	@PostMapping("/eventCr")
	public Mono<EventCreation> createEventCr(@RequestBody EventCreation eventCr) {
		return service.createEventCr(eventCr);
	}
	
	@DeleteMapping("/eventCr/{eventCr_id}")
	public Mono<Void> deleteEventCr(@PathVariable Long eventCr_id) {
		return service.deleteEventCr(eventCr_id);
	}
	
}
