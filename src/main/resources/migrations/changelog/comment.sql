--liquibase formatted sql

--changeset borowski:comment

CREATE TABLE comment
(
    id                   uuid PRIMARY KEY,
    text                 text,
    sender_id            uuid NOT NULL
        CONSTRAINT comment_sender_id_fk REFERENCES customer (id),
    dateOfMessage        timestamp,
    payment_request_id   uuid NOT NULL
        CONSTRAINT comment_payment_request_id_fk REFERENCES payment_request (id)
);