--liquibase formatted sql

--changeset borowski:customer

CREATE TABLE customer
(
    id                 uuid PRIMARY KEY,
    inn                text,
    contr_agent_info   text,
    transaction_subject text,
    isRegular          boolean,
    isLogisticNeeds    boolean,
    phone              text,
    email              text
);