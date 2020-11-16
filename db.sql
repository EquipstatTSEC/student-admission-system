CREATE TABLE student (
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(50),
    middle_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    email VARCHAR(50),
    category VARCHAR(15),
    gender VARCHAR(15),
    belongs_to_EWS BOOLEAN,
    is_disabled BOOLEAN,
    mother_tongue VARCHAR(30),
    caste VARCHAR(30),
    religion VARCHAR(30),
    PRIMARY KEY (id)
);


CREATE TABLE phone_number(
    student_id INT AUTO_INCREMENT NOT NULL,
    phone VARCHAR (20),
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
    PRIMARY KEY (student_id)
);

