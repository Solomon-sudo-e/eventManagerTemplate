package eventpackages.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventpackages.events.Entity.Posting;
import eventpackages.events.Entity.Registration;
import eventpackages.events.dao.PostingRepository;
import eventpackages.events.dao.RegistrationRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RegistrationAndPostingService {

	@Autowired
	RegistrationRepository repo;
	
	@Autowired
	PostingRepository pRepo;
	
	public Flux<Posting> getAllPostings() {
		return this.pRepo.findAll();
	}
	
	public Mono<Posting> createPosting(Posting posting) {
		return this.pRepo.save(posting);
	}
	
	public Mono<Void> deletePosting(Long posting_id) {
		return this.pRepo.deleteById(posting_id);
	}
	
	public Mono<Registration> createRegistration(Registration registration) {
		return this.repo.save(registration);
	}
	
	public Mono<Void> deleteRegistration(Long registration_id) {
		return this.repo.deleteById(registration_id);
	}
}
