package eventpackages.events.Entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posting {

    @Id
    private Long postingId;

    private String description, accomodations;

    private Long eventId, venueId, userId, registrationid;


    /*

    CREATE TABLE Posting(
        posting_id INT PRIMARY KEY AUTO_INCREMENT,
        description TEXT,
        accomodations TEXT,
        event_id INT,
        venue_id INT,
        organizer_id INT,
        registration_id INT,
        FOREIGN KEY (event_id) REFERENCES Event (event_id) ON DELETE CASCADE,
        FOREIGN KEY (venue_id) REFERENCES Venue (venue_id) ON DELETE CASCADE,
        FOREIGN KEY (organizer_id) REFERENCES Organizer (organizer_id) ON DELETE CASCADE,
        FOREIGN KEY (registration_id) REFERENCES Registration (registration_id) ON DELETE CASCADE
    );

     */

}
