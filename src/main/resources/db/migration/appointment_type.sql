CREATE TABLE IF NOT EXISTS appointment_type
(
    id SERIAL NOT NULL,
    name_ VARCHAR(60) NOT NULL,
    description VARCHAR(255),
    duration_minutes SMALLINT NOT NULL,
    color_hex_code VARCHAR(10) NOT NULL,
    CONSTRAINT pk_appointment_type PRIMARY KEY (id)
);

ALTER TABLE appointment_type ADD CONSTRAINT idx_appointment_type_on_name_unq UNIQUE (name_);
