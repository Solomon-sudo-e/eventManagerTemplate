package eventpackages.events.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import eventpackages.events.Entity.UserData;
import eventpackages.events.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserController {
	
	@Autowired
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@ResponseBody
	@GetMapping("/{user_id}")
	public Mono<UserData> getCurrentUser(@PathVariable Long user_id) throws IOException {
		return service.getUser(user_id);
	}
	
	
}
