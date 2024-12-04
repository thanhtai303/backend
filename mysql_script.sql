CREATE DATABASE IF NOT EXISTS health_monitoring;
USE health_monitoring;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_type VARCHAR(50)
);



CREATE TABLE patients (
    id BIGINT PRIMARY KEY,
    dob DATE,
    FOREIGN KEY (id)
        REFERENCES users (id)
);

CREATE TABLE doctors (
    id BIGINT PRIMARY KEY,
    list_of_patients TEXT,
    FOREIGN KEY (id)
        REFERENCES users (id)
);

CREATE TABLE sensor_data (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    temperature DOUBLE,
    blood_pressure DOUBLE,
    heart_rate INTEGER,
    timestamp DATETIME,
    patient_id BIGINT,
    FOREIGN KEY (patient_id)
        REFERENCES patients (id)
);

ALTER TABLE patients ADD doctor_id BIGINT;

ALTER TABLE patients
ADD CONSTRAINT fk_doctor
FOREIGN KEY (doctor_id)
REFERENCES doctors (id);


-- Sample data for users (patients)
INSERT INTO users (name, email, password, user_type) VALUES
('Alice Johnson', 'alice.johnson@example.com', SHA2('password123', 256), 'PATIENT'),
('Bob Smith', 'bob.smith@example.com', SHA2('password123', 256), 'PATIENT'),
('Charlie Brown', 'charlie.brown@example.com', SHA2('password123', 256), 'PATIENT'),
('David Wilson', 'david.wilson@example.com', SHA2('password123', 256), 'PATIENT'),
('Eve Davis', 'eve.davis@example.com', SHA2('password123', 256), 'PATIENT'),
('Frank Miller', 'frank.miller@example.com', SHA2('password123', 256), 'PATIENT'),
('Grace Lee', 'grace.lee@example.com', SHA2('password123', 256), 'PATIENT'),
('Hannah Thompson', 'hannah.thompson@example.com', SHA2('password123', 256), 'PATIENT'),
('Isaac Martinez', 'isaac.martinez@example.com', SHA2('password123', 256), 'PATIENT'),
('Jack Garcia', 'jack.garcia@example.com', SHA2('password123', 256), 'PATIENT'),
('Kate Robinson', 'kate.robinson@example.com', SHA2('password123', 256), 'PATIENT'),
('Liam Lewis', 'liam.lewis@example.com', SHA2('password123', 256), 'PATIENT'),
('Mia Clark', 'mia.clark@example.com', SHA2('password123', 256), 'PATIENT'),
('Nora Walker', 'nora.walker@example.com', SHA2('password123', 256), 'PATIENT'),
('Owen Hall', 'owen.hall@example.com', SHA2('password123', 256), 'PATIENT'),
('Pam Young', 'pam.young@example.com', SHA2('password123', 256), 'PATIENT'),
('Quinn King', 'quinn.king@example.com', SHA2('password123', 256), 'PATIENT'),
('Ruby Scott', 'ruby.scott@example.com', SHA2('password123', 256), 'PATIENT'),
('Sam Green', 'sam.green@example.com', SHA2('password123', 256), 'PATIENT'),
('Tina Adams', 'tina.adams@example.com', SHA2('password123', 256), 'PATIENT');

-- Sample data for patients
INSERT INTO patients (id, dob) VALUES
(1, '1990-01-15'),
(2, '1985-05-22'),
(3, '2000-03-10'),
(4, '1992-11-30'),
(5, '1988-07-19'),
(6, '1975-09-14'),
(7, '1995-02-25'),
(8, '1982-04-18'),
(9, '1991-06-08'),
(10, '1987-12-01'),
(11, '1993-10-20'),
(12, '1986-08-12'),
(13, '1998-03-05'),
(14, '1994-07-30'),
(15, '1983-05-11'),
(16, '2001-01-01'),
(17, '1978-11-21'),
(18, '1989-02-14'),
(19, '1997-06-15'),
(20, '1970-09-09');

-- Sample data for users (doctors)
INSERT INTO users (name, email, password, user_type) VALUES
('Dr. John Smith', 'john.smith@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Mary Johnson', 'mary.johnson@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Robert Williams', 'robert.williams@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Patricia Brown', 'patricia.brown@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Michael Jones', 'michael.jones@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Linda Garcia', 'linda.garcia@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. William Miller', 'william.miller@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Elizabeth Davis', 'elizabeth.davis@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. James Rodriguez', 'james.rodriguez@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Barbara Martinez', 'barbara.martinez@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Richard Hernandez', 'richard.hernandez@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Susan Lopez', 'susan.lopez@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Joseph Gonzalez', 'joseph.gonzalez@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Sarah Wilson', 'sarah.wilson@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Charles Anderson', 'charles.anderson@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Karen Thomas', 'karen.thomas@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Christopher Taylor', 'christopher.taylor@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Nancy Moore', 'nancy.moore@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Daniel Jackson', 'daniel.jackson@hospital.com', SHA2('docpassword123', 256), 'DOCTOR'),
('Dr. Lisa White', 'lisa.white@hospital.com', SHA2('docpassword123', 256), 'DOCTOR');

-- Sample data for doctors (linking to users)
INSERT INTO doctors (id, list_of_patients) VALUES
(1, '1,2,3'),
(2, '4,5,6'),
(3, '7,8,9'),
(4, '10,11,12'),
(5, '13,14'),
(6, '15,16'),
(7, '17,18'),
(8, '19,20'),
(9, '1,4,7'),
(10, '2,5,8'),
(11, '3,6,9'),
(12, '10,13'),
(13, '11,14'),
(14, '12,15'),
(15, '16,19'),
(16, '18,20'),
(17, '1,2,3,4'),
(18, '5,6,7,8'),
(19, '9,10,11,12'),
(20, '13,14,15,16');

-- Sample data for sensor_data
INSERT INTO sensor_data (temperature, blood_pressure, heart_rate, timestamp, patient_id) VALUES
(37.1, 120.0, 72, NOW() - INTERVAL 10 DAY, 1),
(36.8, 125.0, 75, NOW() - INTERVAL 12 DAY, 2),
(37.5, 130.0, 80, NOW() - INTERVAL 8 DAY, 3),
(36.4, 118.0, 70, NOW() - INTERVAL 5 DAY, 4),
(37.0, 122.0, 77, NOW() - INTERVAL 20 DAY, 5),
(36.9, 129.0, 76, NOW() - INTERVAL 15 DAY, 6),
(37.2, 127.0, 74, NOW() - INTERVAL 3 DAY, 7),
(36.5, 119.0, 68, NOW() - INTERVAL 9 DAY, 8),
(36.7, 124.0, 73, NOW() - INTERVAL 2 DAY, 9),
(37.3, 126.0, 78, NOW() - INTERVAL 14 DAY, 10),
(36.6, 121.0, 71, NOW() - INTERVAL 1 DAY, 11),
(37.4, 128.0, 79, NOW() - INTERVAL 7 DAY, 12),
(36.3, 117.0, 67, NOW() - INTERVAL 6 DAY, 13),
(37.6, 132.0, 82, NOW() - INTERVAL 4 DAY, 14),
(36.4, 115.0, 65, NOW() - INTERVAL 11 DAY, 15),
(37.2, 123.0, 76, NOW() - INTERVAL 13 DAY, 16),
(36.8, 120.0, 72, NOW() - INTERVAL 10 DAY, 17),
(37.1, 126.0, 78, NOW() - INTERVAL 2 DAY, 18),
(36.5, 119.0, 70, NOW() - INTERVAL 9 DAY, 19),
(36.7, 125.0, 73, NOW() - INTERVAL 3 DAY, 20);




