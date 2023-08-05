package eventpackages.events.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import eventpackages.events.Entity.Venue;
import eventpackages.events.service.VenueService;
import reactor.core.publisher.Mono;

@Controller
public class VenueController {

	@Autowired
	VenueService service;
	
	public VenueController( VenueService service) {
		this.service = service;
	}
	
	@PostMapping("/venue")
	public Mono<Venue> createVenue(@RequestBody Venue venue) {
		return service.createVenue(venue);
	}
	
	@DeleteMapping("/venue/{venue_id}")
	public Mono<Void> deleteVenue(@PathVariable Long venue_id) {
		return service.deleteVenue(venue_id);
	}
	
	@PutMapping("/venue/{venue_id}")
	public Mono<Venue> updateVenue(@PathVariable Long venue_id, @RequestBody Mono<Venue> venue) {
		return service.updateVenue(venue_id, venue);
	}
}
