DROP DATABASE IF EXISTS `Hotel Management System`;
CREATE DATABASE IF NOT EXISTS `Hotel Management System`;
USE `Hotel Management System`;

#
# TABLE STRUCTURE FOR: Agents
#

CREATE TABLE Agents (
  `agent_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `safety question` varchar(255) NOT NULL,
  `type` enum('Admin','Non-Approved','Approved') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# TABLE STRUCTURE FOR: Guests
#

CREATE TABLE Guests (
  `guest_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `register_date` date DEFAULT current_timestamp
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# TABLE STRUCTURE FOR: Hotel
#

CREATE TABLE Hotel (
  `hotel_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `name` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `Total_floors#` int not null,
  `Total_rooms#` int not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# TABLE STRUCTURE FOR: Rooms
#

CREATE TABLE Rooms (
    `room_id` INT NOT NULL AUTO_INCREMENT,
    `hotel` INT NOT NULL,
    `room#` INT NOT NULL,
    `floor#` INT NOT NULL,
    `smoke` TINYINT(1) NOT NULL,
    `capacity` ENUM('Individual', 'Double Room', 'Triple Room','Family Room') NOT NULL,
    `status` ENUM('Idle', 'Full', 'Hold') NOT NULL default 'Idle',
    `cost` double not null,
    PRIMARY KEY (`room_id`),
    FOREIGN KEY (`hotel`)
        REFERENCES Hotel (`hotel_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

#
# TABLE STRUCTURE FOR: Booked_Rooms
#

CREATE TABLE Booked_Rooms (
  `bookedrooms_id` int PRIMARY KEY NOT NULL,
  `guest_id` int,
  `room_id` int NOT NULL,
 FOREIGN KEY (`room_id`) REFERENCES Rooms(`room_id`),
  FOREIGN KEY (`guest_id`) REFERENCES Guests(`guest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# TABLE STRUCTURE FOR: Booking_Transaction
#


CREATE TABLE Booking_Transaction (
    `transaction_id` INT PRIMARY KEY NOT NULL,
    `hotel` INT NOT NULL,
    `guest` INT NOT NULL,
    `agent` INT NOT NULL,
    `bookedroom` INT NOT NULL,
    `from` Date NOT NULL,
    `to` Date NOT NULL,
    `status` ENUM('Confirmed', 'Cancled', 'On Use', 'Ending') NOT NULL,
    `cost` double not null,
    FOREIGN KEY (`hotel`)
        REFERENCES Hotel (`hotel_id`),
    FOREIGN KEY (`bookedroom`)
        REFERENCES Booked_Rooms (`bookedrooms_id`),
    FOREIGN KEY (`guest`)
        REFERENCES Guests (`guest_id`),
    FOREIGN KEY (`agent`)
        REFERENCES Agents (`agent_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;
