INSERT INTO
    student (
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
        "Aman",
        "Pradeep",
        "Kalra",
        "2001-10-21",
        "example@domain.com",
        "open",
        "Male",
        false,
        false,
        "sindhi",
        "sindhi",
        "hindu"
    );

INSERT INTO
    phone_number (student_id, phone)
VALUES
    (2, "8451904417");