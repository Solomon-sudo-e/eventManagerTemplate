package eventpackages.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventpackages.events.Entity.Event;
import eventpackages.events.dao.EventDao;

@Service
public class DefaultEventService implements EventService {

	@Autowired
	private EventDao eventDao;
	
	@Override
	public Event listEvents() {
		
		return eventDao.listEvents();
	}

}
