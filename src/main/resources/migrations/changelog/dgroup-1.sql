--liquibase formatted sql

--changeset fetyukhin:dgroup-1

CREATE TABLE customer
(
    id       UUID PRIMARY KEY,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
