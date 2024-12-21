CREATE TABLE IF NOT EXISTS owner (
    id SERIAL PRIMARY KEY,
    fio VARCHAR,
    phone_number VARCHAR
);
CREATE TABLE IF NOT EXISTS specialist (
    id SERIAL PRIMARY KEY,
    fio VARCHAR,
    job VARCHAR
);
CREATE TABLE IF NOT EXISTS story (
    id SERIAL PRIMARY KEY,
    history VARCHAR,
    prescriptions VARCHAR
);
CREATE TABLE IF NOT EXISTS pet (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    specialist INTEGER REFERENCES specialist (id),
    story INTEGER REFERENCES story (id)
);
CREATE TABLE IF NOT EXISTS pet_owner (
    id SERIAL PRIMARY KEY,
    pet INTEGER REFERENCES pet (id),
    owner INTEGER REFERENCES owner (id)
);