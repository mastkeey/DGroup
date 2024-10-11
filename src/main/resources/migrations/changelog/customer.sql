--liquibase formatted sql

--changeset borowski:customer

CREATE TABLE customer
(
    id                  uuid PRIMARY KEY,
    inn                 text,
    phone               text,
    email               text NOT NULL,
    password            text NOT NULL
);