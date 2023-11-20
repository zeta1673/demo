INSERT INTO role (id, name) VALUES(1, 'Admin');
INSERT INTO role (id, name) VALUES(2, 'Doctor');
INSERT INTO role (id, name) VALUES(3, 'Nurse');

INSERT INTO speciality (id, name) VALUES(1, 'Oncologist');
INSERT INTO speciality (id, name) VALUES(2, 'Orthopedist');
INSERT INTO speciality (id, name) VALUES(3, 'Traumatologist');
INSERT INTO speciality (id, name) VALUES(4, 'Surgeon');
INSERT INTO speciality (id, name) VALUES(5, 'Neurologist');

INSERT INTO service (id, name) VALUES(1, 'Consult');
INSERT INTO service (id, name) VALUES(2, 'Chemotherapy');
INSERT INTO service (id, name) VALUES(3, 'Blood test');
INSERT INTO service (id, name) VALUES(4, 'Surgery');
INSERT INTO service (id, name) VALUES(5, 'Electroencephalogram');
INSERT INTO service (id, name) VALUES(6, 'X-ray');


INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(1, 'Peter', 'Rogers', 2, 1);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(2, 'Robert', 'Black', 2, 1);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(3, 'Kate', 'Peterson', 2, 2);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(4, 'Harry', 'Smith', 2, 3);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(5, 'Jhon', 'Williamson', 2, 4);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(6, 'Gregory', 'House', 2, 5);

INSERT INTO patient (name, last_name, birth_date) VALUES('Pamela', 'Henderson', '1989-11-23');
INSERT INTO patient (name, last_name, birth_date) VALUES('Richard', 'Nixon', '1975-10-05');
INSERT INTO patient (name, last_name, birth_date) VALUES('Andrew', 'Smith', '2002-05-08');
INSERT INTO patient (name, last_name, birth_date) VALUES('Jhon', 'Mayers', '2000-06-06');
INSERT INTO patient (name, last_name, birth_date) VALUES('Giovani', 'Rogers', '1954-03-15');
INSERT INTO patient (name, last_name, birth_date) VALUES('Luke', 'Skywalker', '1994-02-27');
INSERT INTO patient (name, last_name, birth_date) VALUES('Daniel', 'Reiskin', '1989-08-21');

INSERT INTO hospital_card (id, diagnosis, start_date, end_date, id_patient, id_service, id_staff) VALUES(1, 'Cancer', '2022-08-24', '2022-08-25', 2, 2, 1);
INSERT INTO hospital_card (id, diagnosis, start_date, end_date, id_patient, id_service, id_staff) VALUES(2, 'Clavicle fracture', '2022-08-24', '2022-08-25', 1, 6, 2);
INSERT INTO hospital_card (id, diagnosis, start_date, end_date, id_patient, id_service, id_staff) VALUES(3, 'Epilepsy', '2022-08-24', '2022-08-25', 4, 5, 6);
INSERT INTO hospital_card (id, diagnosis, start_date, end_date, id_patient, id_service, id_staff) VALUES(4, 'Diabetes', '2022-08-24', '2022-08-25', 5, 3, 2);
INSERT INTO hospital_card (id, diagnosis, start_date, end_date, id_patient, id_service, id_staff) VALUES(5, 'Appendicitis', '2022-08-24', '2022-08-25', 7, 4, 5);