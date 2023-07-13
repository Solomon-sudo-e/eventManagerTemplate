package eventpackages.events.Entity;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event {
	String eventName;
	@Pattern(regexp = "[0-9]*")
	int dateOfEvent;
}
