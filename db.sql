CREATE TABLE student (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50),
middle_name  VARCHAR(50),
last_name VARCHAR(50),
date_of_birth DATE,
email VARCHAR(50),
category VARCHAR(15),
gender VARCHAR(15),
belongs_to_EWS BIT,
is_disabled BIT,
mother_tongue VARCHAR(30),
caste VARCHAR(30),
religion VARCHAR(30)
);


INSERT INTO student
(
first_name,
middle_name,
last_name,
date_of_birth,
email,
category,
gender,
belongs_to_EWS,
is_disabled,
mother_tongue,
caste,
religion
)
VALUES 
(
"xyz",
"xyz",
"xyz",
"2001-10-21",
"example@domain.com",
"open",
"Male",
b'1',
b'1',
"sindhi",
"sindhi",
"hindu"
);