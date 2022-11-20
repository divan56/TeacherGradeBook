CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE students (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR,
    grade INT NOT NULL
);

CREATE TABLE subjects (
    id UUID default uuid_generate_v4() PRIMARY KEY,
    name VARCHAR NOT NULL UNIQUE
);

CREATE TABLE marks (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    mark VARCHAR(1) NOT NULL,
    date DATE,
    student_id UUID REFERENCES students(id),
    subject_id UUID REFERENCES subjects(id)
);