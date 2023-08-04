package eventpackages.events.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import eventpackages.events.Entity.EventCreation;

public interface EventCrRepository extends ReactiveCrudRepository<EventCreation, Long> {

}
