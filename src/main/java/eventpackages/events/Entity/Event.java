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
	private Long event_id;
	private String name, description, dateOf, timeOf;
	
	public Event(String name, String description, String dateOf, String timeOf) {
		this(null, name, description, dateOf, timeOf);
	}
}

