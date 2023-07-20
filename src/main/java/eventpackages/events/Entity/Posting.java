package eventpackages.events.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postingId;

    private String description;

    private String accomodations;

    private Long eventId;

    private Long venueId;

    private Long organizerId;

    private Long registrationId;

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
