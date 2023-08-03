package eventpackages.events.Entity;


import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
	
	@Id
	private Long venueId;
	
	private String venueName, address;
	
	private int capacity;
	
	
}
