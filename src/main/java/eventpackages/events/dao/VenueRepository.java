package eventpackages.events.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import eventpackages.events.Entity.Venue;

public interface VenueRepository extends ReactiveCrudRepository<Venue, Long>{

}
