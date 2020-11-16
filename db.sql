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

CREATE TABLE academic_detail(
    id INT AUTO_INCREMENT NOT NULL,
    student_id INT UNIQUE NOT NULL,
    CET_percentile DOUBLE,
    JEE_percentile DOUBLE,
    HSC_or_equivalent_percentage DOUBLE,
    SSC_or_equivalent_percentage DOUBLE,
    SSC_passing_year INT,
    HSC_passing_year INT,
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE student_phone(
    student_id INT AUTO_INCREMENT NOT NULL,
    phone VARCHAR (20),
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
    PRIMARY KEY (student_id)
);


CREATE TABLE parent(
    id INT AUTO_INCREMENT NOT NULL,
    relationship_type VARCHAR (20),
    first_name VARCHAR(50),
    middle_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    occupation_type VARCHAR(50),
    occupation_name VARCHAR(50),
    annual_income VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE parent_phone(
    parent_id INT AUTO_INCREMENT NOT NULL,
    phone VARCHAR (20),
    FOREIGN KEY (parent_id) REFERENCES parent(id) ON DELETE CASCADE,
    PRIMARY KEY (parent_id)
);


CREATE TABLE student_parents(
  student_id INT NOT NULL,
  parent_id INT NOT NULL,
  FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
  FOREIGN KEY (parent_id) REFERENCES parent(id) ON DELETE CASCADE
);


CREATE TABLE state_state(
  id INT AUTO_INCREMENT NOT NULL,
  state_name VARCHAR (50),
  PRIMARY KEY (id)
);

CREATE TABLE city_city(
  id INT AUTO_INCREMENT NOT NULL,
  state_id INT NOT NULL, 
  city_name VARCHAR (50),
  FOREIGN KEY (state_id) REFERENCES state_state(id) ON DELETE CASCADE,
  PRIMARY KEY (id)
);


CREATE TABLE address_address(
  id INT AUTO_INCREMENT NOT NULL,
  student_id INT NOT NULL,
  city_id INT NOT NULL,
  pincode VARCHAR (10),
  address_type VARCHAR (10),
  FOREIGN KEY (city_id) REFERENCES city_city(id) ON DELETE CASCADE,
  FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
  PRIMARY KEY (id)
);

CREATE TABLE address_lines(
  id INT AUTO_INCREMENT NOT NULL,
  address_id INT NOT NULL,
  line VARCHAR (255),
  FOREIGN KEY (address_id) REFERENCES address_address(id) ON DELETE CASCADE,
  PRIMARY KEY (id)
);