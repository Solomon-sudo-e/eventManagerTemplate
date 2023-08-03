package eventpackages.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventpackages.events.Entity.UserData;
import eventpackages.events.dao.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public Mono<UserData> getUser(Long user_id) {
		// TODO Auto-generated method stub
		return repo.findById(user_id);
	}

	
}
