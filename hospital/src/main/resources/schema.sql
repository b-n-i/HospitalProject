CREATE TABLE doctors (
    doctor_id   INTEGER      NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    function VARCHAR(128) NOT NULL,
    address_id INTEGER,
    email_id INTEGER,
    phone_number_id INTEGER NOT NULL,
    PRIMARY KEY (doctor_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id),
    FOREIGN KEY (email_id) REFERENCES address(email_id),
    FOREIGN KEY (phone_number_id) REFERENCES address(phone_number_id)
);

insert into emails(doctor_id, first_name, last_name, function, address_id, email_id, phone_number_id)
 values(1,'email@ceva.com');

CREATE TABLE addresses (
    address_id   INTEGER  NOT NULL AUTO_INCREMENT,
    country VARCHAR(128) NOT NULL,
    city VARCHAR(128) NOT NULL,
    street VARCHAR(128) NOT NULL,
    street_number VARCHAR(128) NOT NULL,
    PRIMARY KEY (address_id)
);
insert into addresses(address_id, country , city, street, street_number) values(1,'country','city','street', '5A');

CREATE TABLE emails(
    email_id   INTEGER  NOT NULL AUTO_INCREMENT,
    email VARCHAR(128) NOT NULL
    PRIMARY KEY (email_id)
);
insert into emails(email_id, email) values(1,'email@ceva.com');

CREATE TABLE phone_numbers(
    phone_number_id   INTEGER  NOT NULL AUTO_INCREMENT,
    phone_number VARCHAR(128) NOT NULL
    PRIMARY KEY (phone_id)
);
insert into phone_numbers(phone_number_id, phone_number) values(1,'3253332333');