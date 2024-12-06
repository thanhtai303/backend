CREATE DATABASE IF NOT EXISTS healthcare_db;
USE healthcare_db;


DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS consultations;
DROP TABLE IF EXISTS sensor_data;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE patients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNIQUE, 
    dob DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNIQUE,  
    specialization VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE sensor_data (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id BIGINT,
    temperature DECIMAL(5,2),
    blood_pressure VARCHAR(20),
    heart_rate INTEGER,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);

CREATE TABLE consultations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id BIGINT,
    doctor_id BIGINT,
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);

CREATE TABLE payments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    consultation_id BIGINT,
    amount DECIMAL(10,2),
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (consultation_id) REFERENCES consultations(id)
);


INSERT INTO users (name, email, password, role) VALUES
('John Doe', 'john.doe@example.com', 'password123', 'patient'),
('Jane Smith', 'jane.smith@example.com', 'password123', 'doctor'),
('Alice Johnson', 'alice.johnson@example.com', 'password123', 'patient'),
('Bob Brown', 'bob.brown@example.com', 'password123', 'doctor'),
('Charlie Davis', 'charlie.davis@example.com', 'password123', 'patient'),
('Diana Prince', 'diana.prince@example.com', 'password123', 'doctor'),
('Ethan Hunt', 'ethan.hunt@example.com', 'password123', 'patient'),
('Fiona Apple', 'fiona.apple@example.com', 'password123', 'doctor'),
('George Clooney', 'george.clooney@example.com', 'password123', 'patient'),
('Hannah Montana', 'hannah.montana@example.com', 'password123', 'doctor');


INSERT INTO patients (user_id, dob) VALUES
(1, '1980-01-15'),
(3, '1990-05-22'),
(5, '1985-09-30'),
(7, '1975-12-01'),
(9, '1992-07-18');


INSERT INTO doctors (user_id, specialization) VALUES
(2, 'Cardiology'),
(4, 'Dermatology'),
(6, 'Neurology'),
(8, 'Pediatrics'),
(10, 'Orthopedics');


INSERT INTO sensor_data (patient_id, temperature, blood_pressure, heart_rate) VALUES
(1, 98.6, '120/80', 72),
(2, 99.1, '130/85', 75),
(3, 97.5, '115/75', 70),
(4, 100.0, '140/90', 80),
(5, 98.7, '125/82', 68);


INSERT INTO consultations (patient_id, doctor_id, status) VALUES
(1, 1, 'completed'),
(2, 2, 'pending'),
(3, 3, 'completed'),
(4, 4, 'canceled'),
(5, 5, 'completed');


INSERT INTO payments (consultation_id, amount, status) VALUES
(1, 100.00, 'paid'),
(2, 150.00, 'pending'),
(3, 120.00, 'paid'),
(4, 90.00, 'canceled'),
(5, 200.00, 'paid');