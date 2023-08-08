package eventpackages.events.Entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    @Id
    private Long userId;

    private String name, phoneNumber, city, state, email, passKey;

    
    public UserData(String name, String phoneNumber, String city, 
    		String state, String email, String passKey) {
    	this(null, name, phoneNumber, city, state, email, passKey);
    }
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