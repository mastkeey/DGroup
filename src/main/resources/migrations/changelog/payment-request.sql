--liquibase formatted sql

--changeset borowski:payment-request

CREATE TABLE payment_request
(
    id              uuid PRIMARY KEY,
    status          text,
    date_of_request timestamp,
    customer_id     uuid NOT NULL
        CONSTRAINT payment_request_customer_id_fk REFERENCES customer (id)
);