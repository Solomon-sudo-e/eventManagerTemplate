package eventpackages.events.Entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;


@Data
@Entity
public class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venueId;
	
	@Length(min = 1, max = 50)
	private String venueName;
	
	@Length(min = 1, max = 75)
	private String address;
	
	private int capacity;
	
	
}
