package eventpackages.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventpackages.events.Entity.Event;
import eventpackages.events.Entity.EventCreation;
import eventpackages.events.dao.EventCrRepository;
import eventpackages.events.dao.EventRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventService {
	@Autowired
	EventRepository repo;

	@Autowired
	EventCrRepository crRepo;
	
	public Mono<Event> getEvent(Long event_id) {
				return this.repo.findById(event_id);
	}

	public Mono<Event> updateEvent(Long event_id, Mono<Event> event) {
				return this.repo.findById(event_id)
				.flatMap(e -> event.map(d -> {
					e.setEventName(d.getEventName());
					e.setDateOfEvent(d.getDateOfEvent());
					return e;
				}))
				.flatMap(e -> this.repo.save(e));
		
		// e = event_id
		// d = body
	}

	public Mono<Event> createEvent(Event event) {
				return this.repo.save(event);
	}

	public Mono<Void> deleteEvent(Long event_id) {
				return this.repo.deleteById(event_id);
	}

	public Flux<Event> getAllEvents() {
				return this.repo.findAll();
	}

	public Mono<EventCreation> getEventCreator(Long eventCr_id) {
				return this.crRepo.findById(eventCr_id);
	}

	public Mono<Void> deleteEventCr(Long eventCr_id) {
				return this.crRepo.deleteById(eventCr_id);
	}

	public Mono<EventCreation> createEventCr(EventCreation eventCr) {
				return this.crRepo.save(eventCr);
	}
}
