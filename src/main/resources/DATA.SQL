-- Création de la base de données (si elle n'existe pas déjà)
CREATE DATABASE IF NOT EXISTS emergency_services;
USE emergency_services;

-- Création des tables

-- Table pour stocker les informations des personnes
CREATE TABLE IF NOT EXISTS person (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(50),
    zip VARCHAR(10),
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    birth_date DATE
    );

-- Table pour stocker les dossiers médicaux des personnes
CREATE TABLE IF NOT EXISTS medical_record (
                                              id INT AUTO_INCREMENT PRIMARY KEY,
                                              person_id INT NOT NULL,
                                              medications JSON NOT NULL,
                                              allergies JSON NOT NULL,
                                              prescription JSON NOT NULL,
                                              FOREIGN KEY (person_id) REFERENCES person(id)
    );

-- Table pour stocker les informations des stations de pompiers
CREATE TABLE IF NOT EXISTS fire_station (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            station_number INT NOT NULL,
                                            address VARCHAR(255),
    city VARCHAR(50),
    zip VARCHAR(10)
    );

-- Table pour associer les personnes aux stations de pompiers
CREATE TABLE IF NOT EXISTS fire_station_personnel (
                                                      fire_station_id INT NOT NULL,
                                                      person_id INT NOT NULL,
                                                      FOREIGN KEY (fire_station_id) REFERENCES fire_station(id),
    FOREIGN KEY (person_id) REFERENCES person(id),
    PRIMARY KEY (fire_station_id, person_id)
    );
