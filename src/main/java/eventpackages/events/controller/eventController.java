package eventpackages.events.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eventpackages.events.Entity.Event;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
/*
 * we can change the 'url' names and what I have set, this is just for an example and layout for you!
 */
@RequestMapping()
@OpenAPIDefinition(info = @Info(title = "Profile Network"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")
})
@RestController
public interface eventController {
	@Operation(
			summary = "Get, post, put, delete, event mapping",
			description = "This operation set is for basic CRUD operations and addUser operations."
					+ "CRUD statements and a addUser mapping to add users ass active conncetions.",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A profile is returned", 
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Event.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No profiles were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured", 
							content = @Content(mediaType = "application/json")),
			})		
	
	@GetMapping()
	Event listEvents();
	
	
	// All event_creation  entitied CRUD use in this controller.
}