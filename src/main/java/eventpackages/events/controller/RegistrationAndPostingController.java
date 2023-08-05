package eventpackages.events.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import eventpackages.events.Entity.Posting;
import eventpackages.events.Entity.Registration;
import eventpackages.events.service.RegistrationAndPostingService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class RegistrationAndPostingController {

	@Autowired
	RegistrationAndPostingService service;
	
	public RegistrationAndPostingController(RegistrationAndPostingService service) {
		this.service = service;
	}
	/*
	 * Posting entity
	 */
	
	@GetMapping("/postings")
	public Flux<Posting> getAllPostings() {
		return service.getAllPostings();
	}
	
	@PostMapping("/postings/createPosting")
	public Mono<Posting> createPosting(@RequestBody Posting posting) {
		return service.createPosting(posting);
	}
	
	@DeleteMapping("/postings/{posting_id}")
	public Mono<Void> deletePosting(@PathVariable Long posting_id) {
		return service.deletePosting(posting_id);
	}
	
	/*
	 * Registration entity
	 */
	
	@PostMapping("/registration")
	public Mono<Registration> createRegistration(@RequestBody Registration registration) {
		return service.createRegistration(registration);
	}
	
	@DeleteMapping("/registration/{registration_id}")
	public Mono<Void> deleteRegistration(@PathVariable Long registration_id) {
		return service.deleteRegistration(registration_id);
	}
}
