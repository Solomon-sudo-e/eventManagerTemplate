package eventpackages.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventpackages.events.Entity.Guest;
import eventpackages.events.Entity.UserData;
import eventpackages.events.dao.GuestRepository;
import eventpackages.events.dao.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	@Autowired
	GuestRepository guRepo;
	
//	@Autowired
//	WebClient client;
	
	
	public Mono<UserData> getUser(Long user_id) {
//		client.get()
//		.uri("/{user_id}")
//		.retrieve()
//		.bodyToMono(UserData.class)
//		.filter(ud -> !ud.getName().isEmpty());
		
		return this.repo.findById(user_id);
	}

	public Mono<UserData> createUser(UserData user) {
	
		return this.repo.save(user);
	}
	
	public Mono<UserData> updateUser(Long user_id, Mono<UserData> user) {
		return this.repo.findById(user_id)
				.flatMap(u -> user.map(d -> {
					u.setName(d.getName());
					u.setCity(d.getCity());
					u.setEmail(d.getEmail());
					u.setPassKey(d.getPassKey());
					u.setPhoneNumber(d.getPhoneNumber());
					u.setState(d.getState());
					return u;
				}))
				.flatMap(u -> this.repo.save(u));
	}

	// u = user_id
	// d = body
	
	public Mono<Void> deleteUser(Long user_id) {
		return this.repo.deleteById(user_id);
	}
	
	public Mono<Guest> createGuest(Guest guest) {
		return this.guRepo.save(guest);
	}
	
	public Mono<Guest> getGuest(Long guest_id) {
		return this.guRepo.findById(guest_id);
	}
	
	public Mono<Void> deleteGuest(Long guest_id) {
		return this.guRepo.deleteById(guest_id);
	}
}
