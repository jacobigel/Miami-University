-- Jacob Igel
-- ISA 245 B
-- Assignment 3 Part 2

-- Emptying all of the tables created in ASMT3 Part One
DELETE FROM class;
DELETE FROM contract;
DELETE FROM job;
DELETE FROM consultant;
DELETE FROM region;
DELETE FROM client;
DELETE FROM skill;

-- Drop all of the sequences
DROP SEQUENCE class_num_sequence;

-- Drop all of the tables
DROP TABLE class;
DROP TABLE contract;
DROP TABLE job;
DROP TABLE consultant;
DROP TABLE region;
DROP TABLE client;
DROP TABLE skill;

COMMIT;