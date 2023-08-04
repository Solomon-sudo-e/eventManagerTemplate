package eventpackages.events.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import eventpackages.events.Entity.Guest;

public interface GuestRepository extends ReactiveCrudRepository<Guest, Long>{

}
