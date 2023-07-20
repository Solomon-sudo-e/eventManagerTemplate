package eventpackages.events.Entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Event_Creation {
	
	enum Status {
		ACCEPTED, DENIED
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventCreationId;
	
	private String text;
	private Status status;
	private String accommodations;
	
	@Pattern(regexp = "[0-9]*[^A-Z]")
	@Length(max = 8, min = 8)
	private String dateOf;
	
	@Pattern(regexp = "[^A-Z]")
	@Length(max = 5)
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
