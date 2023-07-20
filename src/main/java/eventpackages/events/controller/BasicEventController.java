package eventpackages.events.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import eventpackages.events.Entity.Event;
import eventpackages.events.service.EventService;

@RestController
public class BasicEventController implements eventController {

	
	
	
	@Autowired
	EventService eventService;
	
	@Override
	public Event listEvents() {
		Event eventSerivce;
		return eventService.listEvents();
	}

}
