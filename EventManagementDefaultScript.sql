DROP TABLE IF EXISTS Posting;
DROP TABLE IF EXISTS Registration;
DROP TABLE IF EXISTS Event_Creation;
DROP TABLE IF EXISTS Attendee;
DROP TABLE IF EXISTS Organizer;
DROP TABLE IF EXISTS Venue;
DROP TABLE IF EXISTS Event;
DROP TABLE IF EXISTS User_Data;
DROP TABLE IF EXISTS Guest;

CREATE TABLE Guest(
guest_id INT PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE User_Data(
user_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20),
phoneNumber VARCHAR(12),
cityLocation TEXT,
stateLocation TEXT,
email TEXT,
passKey TEXT
);

CREATE TABLE Event(
event_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100),
dateOf VARCHAR(8),
timeOF VARCHAR(7),
description TEXT
);

CREATE TABLE Venue(
venue_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
address VARCHAR(75),
capacity INT
);

CREATE TABLE Organizer(
organizer_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(25),
email VARCHAR(50),
phone VARCHAR(17),
user_id INT,
FOREIGN KEY (user_id) REFERENCES User_Data (user_id) ON DELETE CASCADE
);

CREATE TABLE Attendee(
attendee_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(25),
email VARCHAR(50),
phone VARCHAR(17),
user_id INT,
FOREIGN KEY (user_id) REFERENCES User_Data (user_id) ON DELETE CASCADE
);

CREATE TABLE Event_Creation(
event_creation_id INT PRIMARY KEY AUTO_INCREMENT,
description TEXT,
status ENUM ('ACCEPTED', 'DENIED'),
accommodations TEXT,
dateOf VARCHAR(8),
timeOf VARCHAR(7),
event_id INT,
venue_id INT,
organizer_id INT,
FOREIGN KEY (event_id) REFERENCES Event (event_id) ON DELETE CASCADE,
FOREIGN KEY (venue_id) REFERENCES Venue (venue_id) ON DELETE CASCADE,
FOREIGN KEY (organizer_id) REFERENCES Organizer (organizer_id) ON DELETE CASCADE 
);

CREATE TABLE Registration(
registration_id INT PRIMARY KEY AUTO_INCREMENT,
private ENUM ('YES', 'NO'),
registration_date TIMESTAMP,
registation_add_on_questions TEXT,
organizer_id INT,
FOREIGN KEY (organizer_id) REFERENCES Organizer (organizer_id) ON DELETE CASCADE
);

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