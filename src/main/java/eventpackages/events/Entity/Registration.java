package eventpackages.events.Entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Registration {
	enum Acceptance {
		YES, NO
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registrationId;
	
	private Acceptance acceptance;
	
	@Pattern(regexp = "[^A-Z]*")
	@Length(max=12)
	private String registration_date;
	
	private String registrationAddOnQuestions;
	
	
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
