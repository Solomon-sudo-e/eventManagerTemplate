

CREATE TABLE IF NOT EXISTS Guest(
guest_id INT PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE IF NOT EXISTS User_Data(
user_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20),
phone_number VARCHAR(12),
city TEXT,
state TEXT,
email TEXT,
pass_key TEXT
);

CREATE TABLE IF NOT EXISTS Event(
event_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100),
date_of VARCHAR(8),
time_of VARCHAR(7),
description TEXT
);

CREATE TABLE IF NOT EXISTS Venue(
venue_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
address VARCHAR(75),
capacity INT
);

CREATE TABLE IF NOT EXISTS Event_Creation(
event_creation_id INT PRIMARY KEY AUTO_INCREMENT,
description TEXT,
status ENUM ('ACCEPTED', 'DENIED'),
accommodations TEXT,
date_of VARCHAR(8),
time_of VARCHAR(7),
event_id INT,
venue_id INT,
user_id INT,
FOREIGN KEY (event_id) REFERENCES Event (event_id) ON DELETE CASCADE,
FOREIGN KEY (venue_id) REFERENCES Venue (venue_id) ON DELETE CASCADE,
FOREIGN KEY (user_id) REFERENCES User_Data (user_id) ON DELETE CASCADE 
);

CREATE TABLE IF NOT EXISTS Registration(
registration_id INT PRIMARY KEY AUTO_INCREMENT,
private ENUM ('YES', 'NO'),
registration_date TIMESTAMP,
registation_add_on_questions TEXT,
user_id INT,
FOREIGN KEY (user_id) REFERENCES User_Data (user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Posting(
posting_id INT PRIMARY KEY AUTO_INCREMENT,
description TEXT,
accommodations TEXT,
event_id INT,
venue_id INT,
user_id INT,
registration_id INT,
FOREIGN KEY (event_id) REFERENCES Event (event_id) ON DELETE CASCADE,
FOREIGN KEY (venue_id) REFERENCES Venue (venue_id) ON DELETE CASCADE,
FOREIGN KEY (user_id) REFERENCES User_Data (user_id) ON DELETE CASCADE,
FOREIGN KEY (registration_id) REFERENCES Registration (registration_id) ON DELETE CASCADE
);