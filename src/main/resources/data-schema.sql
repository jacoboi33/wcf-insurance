CREATE SEQUENCE IF NOT EXISTS state_seq;
CREATE TABLE IF NOT EXISTS state_details (
    id BIGINT NOT NULL DEFAULT nextval('state_seq') PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zip VARCHAR(100) NOT NULL,
    phone VARCHAR(100) NOT NULL,
    balance NUMERIC(8,2) NOT NULL
    );