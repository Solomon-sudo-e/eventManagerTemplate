package eventpackages.events.Entity;


import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventCreation {
	
	enum Status {
		ACCEPTED, DENIED
	}
	@Id
	private Long eventCreationId;
	
	private String text, accomodations;
	private Status status;
	
	@Pattern(regexp = "[0-9]*[^A-Z]")
	private String dateOf;
	
	@Pattern(regexp = "[^A-Z]")
	private String timeOf;
	
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
