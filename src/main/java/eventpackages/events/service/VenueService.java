package eventpackages.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventpackages.events.Entity.Venue;
import eventpackages.events.dao.VenueRepository;
import reactor.core.publisher.Mono;

@Service
public class VenueService {

	@Autowired
	VenueRepository repo;
	
	public Mono<Venue> createVenue(Venue venue) {
		return this.repo.save(venue);
	}
	
	public Mono<Void> deleteVenue(Long venue_id) {
		return this.repo.deleteById(venue_id);
	}
	
	public Mono<Venue> updateVenue(Long venue_id, Mono<Venue> venue) {
		return this.repo.findById(venue_id)
				.flatMap(v -> venue.map(d -> {
					v.setVenueName(d.getVenueName());
					v.setAddress(d.getAddress());
					v.setCapacity(d.getCapacity());
					return v;
				}))
				.flatMap(e -> this.repo.save(e));
	}
	
	// v = venue_id
	// d = body
}
