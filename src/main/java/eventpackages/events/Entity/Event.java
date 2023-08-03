package eventpackages.events.Entity;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
	@Id
	String eventName;
	
	@Pattern(regexp = "[0-9]*")
	int dateOfEvent;
	
	}

