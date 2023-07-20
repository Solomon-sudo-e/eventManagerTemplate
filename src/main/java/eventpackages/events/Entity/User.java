package eventpackages.events.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Length(min = 1, max = 50)
    private String name;

    @Length(min = 1, max = 12)
    private String phoneNumber;

    private String city;

    private String state;

    private String email;

    private String passKey;


}

/*

CREATE TABLE User_Data(
user_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20),
phoneNumber VARCHAR(12),
cityLocation TEXT,
stateLocation TEXT,
email TEXT,
passKey TEXT
);

 */