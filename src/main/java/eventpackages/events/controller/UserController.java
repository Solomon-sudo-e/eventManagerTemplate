package eventpackages.events.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import eventpackages.events.Entity.Guest;
import eventpackages.events.Entity.UserData;
import eventpackages.events.service.UserService;
import reactor.core.publisher.Mono;

@Controller
public class UserController {
	
	@Autowired
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	
	/*
	 * UserData entity
	 */
	@ResponseBody
	@GetMapping("/user/{user_id}")
	public Mono<UserData> getCurrentUser(@PathVariable long user_id) throws IOException {
		return service.getUser(user_id);
	}
	
	@PostMapping("/user")
	public Mono<UserData> createNewUser(@RequestBody UserData user) throws IOException {
		return service.createUser(user);
	}
	
	@PutMapping("/user/{user_id}")
	public Mono<UserData> updateExistingUser(@PathVariable Long user_id, @RequestBody Mono<UserData> user) throws IOException {
		return service.updateUser(user_id, user);
	}
	
	@DeleteMapping("/user/{user_id}")
	public Mono<Void> deleteUser(@PathVariable Long user_id) throws IOException {
		return service.deleteUser(user_id);
	}
	
	/*
	 * Guest entity
	 */
	@GetMapping("/guest/{guest_id}")
	public Mono<Guest> getGuest(@PathVariable Long guest_id) throws IOException {
		return service.getGuest(guest_id);
	}
	
	@PostMapping("/guest")
	public Mono<Guest> createGuest(@RequestBody Guest guest) {
		return service.createGuest(guest);
	}
	
	@DeleteMapping("/guest/{guest_id}")
	public Mono<Void> deleteGuest(@PathVariable Long guest_id) {
		return service.deleteGuest(guest_id);
	}
	
	
}
