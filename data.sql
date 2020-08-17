drop database mystarterdb;
drop user mystarter;
create user mystarter with password 'mystarter';
create database mystarterdb with template=template0 owner=mystarter;
\connect mystarterdb;
alter default privileges grant all on tables to mystarter;

CREATE EXTENSION "uuid-ossp";

CREATE TABLE PERSON (
id UUID not null primary key,
name varchar(100) not null
);

INSERT INTO person (id,name) values (uuid_generate_v4(), 'Maria John');