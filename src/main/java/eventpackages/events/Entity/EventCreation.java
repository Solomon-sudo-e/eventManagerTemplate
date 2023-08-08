package eventpackages.events.Entity;


import java.time.Instant;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventCreation {
	
	public enum Status {
		ACCEPTED, DENIED
	}
	@Id
	private Long eventCreationId;
	
	private String description, accommodations;
	private Status status;
	
	String dateOf;
	
	String timeOf;
	
	
	public EventCreation(String description, String accommodations, EventCreation.Status status, 
			String dateOf, String timeOf) {
		this(null, description, accommodations, status,
				dateOf, timeOf);
	}
	/*
	 * /*
	 * CREATE TABLE Event_Creation(
		event_creation_id INT PRIMARY KEY AUTO_INCREMENT,
		description TEXT,
		status ENUM ('ACCEPTED', 'DENIED'),
		accommodations TEXT,
		dateOf VARCHAR(8),
		timeOf VARCHAR(7),
		event_id INT,
		venue_id INT,
		organizer_id INT,
		FOREIGN KEY (event_id) REFERENCES Event (event_id) ON DELETE CASCADE,
		FOREIGN KEY (venue_id) REFERENCES Venue (venue_id) ON DELETE CASCADE,
		FOREIGN KEY (organizer_id) REFERENCES Organizer (organizer_id) ON DELETE CASCADE 
);
	 */
	 
}
