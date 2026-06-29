-- Reference DDL (Hibernate ddl-auto=update also creates this table on startup)
CREATE TABLE IF NOT EXISTS student (
    student_id   VARCHAR(50)  NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    email        VARCHAR(255),
    course       VARCHAR(100),
    PRIMARY KEY (student_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
