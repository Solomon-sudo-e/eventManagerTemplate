package eventpackages.events.Entity;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
	enum Acceptance {
		YES, NO
	}

	@Id
	private Long registrationId, registrationAddOnQuestions;
	
	private Acceptance acceptance;
	
	@Pattern(regexp = "[^A-Z]*")
	private String registration_date;
	
	
	/*
	 * 
CREATE TABLE Registration(
registration_id INT PRIMARY KEY AUTO_INCREMENT,
private ENUM ('YES', 'NO'),
registration_date TIMESTAMP,
registation_add_on_questions TEXT,
organizer_id INT,
FOREIGN KEY (organizer_id) REFERENCES Organizer (organizer_id) ON DELETE CASCADE
);
	 */
}
