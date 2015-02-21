CREATE TABLE cm_contact
(
  contact_id SERIAL,
  sur_name varchar(255) not null,
  given_name varchar(255) not null,
  email varchar(255) not null,
  phone varchar(255) not null,
  primary key (contact_id)
);