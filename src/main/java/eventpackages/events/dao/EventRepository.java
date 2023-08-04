package eventpackages.events.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import eventpackages.events.Entity.Event;

public interface EventRepository extends ReactiveCrudRepository<Event, Long> {

}
