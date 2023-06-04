-- Jacob Igel 
-- ISA 245
-- Assignment 3 Part 1

-- creating tables

-- creating class table
CREATE TABLE class
(class_num NUMBER(6), 
class_description VARCHAR2(30) NOT NULL,
CONSTRAINT class_class_num_pk PRIMARY KEY (class_num));

-- creating job table
CREATE TABLE  job
(job_num NUMBER(6), 
CONSTRAINT job_contract_num_fk FOREIGN KEY (contract_num) REFERENCES contract(contract_num),
CONSTRAINT job_consultant_num_fk FOREIGN KEY (consultant_num) REFERENCES consultant(consultant_num),
CONSTRAINT job_class_num_fk FOREIGN KEY (class_num) REFERENCES class(class_num),
CONSTRAINT job_job_num_pk PRIMARY KEY (job_num));

-- creating contract table
CREATE TABLE contract
(contract_num NUMBER(6),
contract_amount NUMBER(30) NOT NULL, 
contract_date DATE NOT NULL,
CONSTRAINT contract_client_num_fk FOREIGN KEY (client_num) REFERENCES client(client_num),
CONSTRAINT contract_contract_num_pk PRIMARY KEY (contract_num));

-- creating consultant table
CREATE TABLE  consultant
(consultant_num NUMBER(6), 
consultant_skill VARCHAR2(30) NOT NULL, 
consultant_name VARCHAR2(30) NOT NULL, 
CONSTRAINT consultant_skill_num_fk FOREIGN KEY (skill_num) REFERENCES skill(skill_num),
CONSTRAINT consultant_consultant_num_pk PRIMARY KEY (consultant_num));

-- creating region table
CREATE TABLE region
(region_num NUMBER(6), 
region_description VARCHAR2(30) NOT NULL, 
region_name VARCHAR2(30) NOT NULL, 
CONSTRAINT region_region_num_pk PRIMARY KEY (region_num));

-- creating client table
CREATE TABLE  client
(client_num NUMBER(6), 
client_name VARCHAR2(30) NOT NULL, 
CONSTRAINT client_region_num_fk FOREIGN KEY (region_num) REFERENCES region(region_num),
CONSTRAINT client_client_num_pk PRIMARY KEY (client_num));

-- creating skill table
CREATE TABLE skill
(skill_num NUMBER(6), 
CONSTRAINT skill_region_num_fk FOREIGN KEY (region_num) REFERENCES region(region_num),
CONSTRAINT skill_skill_num_pk PRIMARY KEY (skill_num));

-- inserting data

-- class data
CREATE SEQUENCE class_num_sequence
START WITH 10000;

INSERT INTO class VALUES (class_num_sequence.nextval, 'ISA');
INSERT INTO class VALUES (class_num_sequence.nextval, 'BUS');
INSERT INTO class VALUES (class_num_sequence.nextval, 'CSE');

-- job data
INSERT INTO job VALUES (1,1,1,1);
INSERT INTO job VALUES (2,2,2,2);
INSERT INTO job VALUES (3,3,3,3);

-- contract data
INSERT INTO contract VALUES (1,10000, DATE'2021-1-1');
INSERT INTO contract VALUES (2,20000, DATE'2021-1-1');
INSERT INTO contract VALUES (3,30000, DATE'2021-1-1');

-- consultant data
INSERT INTO consultant VALUES (1,'Information Systems', 'Evans');
INSERT INTO consultant VALUES (2,'Business', 'Stark');
INSERT INTO consultant VALUES (3,'Computers','Hughie');

-- region data
INSERT INTO region VALUES (0001,'Oxford','Butler');
INSERT INTO region VALUES (0002,'Cincinnati','Hamiltion');
INSERT INTO region VALUES (0003,'Mason','Warren');

-- client data
INSERT INTO client VALUES (100,'Butcher',0001);
INSERT INTO client VALUES (200,'Frenchie',0002);
INSERT INTO client VALUES (300,'Liberty',0003);

-- skill data
INSERT INTO skill VALUES (1000,0001);
INSERT INTO skill VALUES (2000,0002);
INSERT INTO skill VALUES (3000,0003);
