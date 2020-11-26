CREATE TABLE student (
  id INT NOT NULL,
  first_name VARCHAR(50),
  middle_name VARCHAR(50),
  last_name VARCHAR(50),
  date_of_birth VARCHAR(10),
  email VARCHAR(50),
  category VARCHAR(15),
  gender VARCHAR(15),
  belongs_to_EWS varchar(5) check(belongs_to_EWS in ('True', 'False')),
  is_disabled varchar(5) check(is_disabled in ('True', 'False')),
  mother_tongue VARCHAR(30),
  caste VARCHAR(30),
  religion VARCHAR(30),
  phone VARCHAR(10),
  PRIMARY KEY (id)
);

CREATE TABLE academic_detail(
  student_id INT NOT NULL,
  CET_percentile NUMBER(3, 7),
  JEE_percentile NUMBER(3, 7),
  HSC_or_equivalent_percentage NUMBER(3, 7),
  SSC_or_equivalent_percentage NUMBER(3, 7),
  SSC_passing_year INT,
  HSC_passing_year INT,
  FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
  PRIMARY KEY (student_id)
);

CREATE TABLE parent(
  id INT NOT NULL,
  relationship_type VARCHAR (20),
  first_name VARCHAR(50),
  middle_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(50),
  occupation_type VARCHAR(50),
  occupation_name VARCHAR(50),
  annual_income VARCHAR(50),
  phone VARCHAR (10),
  PRIMARY KEY (id)
);

CREATE TABLE student_parents(
  student_id INT NOT NULL,
  parent_id INT NOT NULL,
  FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
  FOREIGN KEY (parent_id) REFERENCES parent(id) ON DELETE CASCADE
);