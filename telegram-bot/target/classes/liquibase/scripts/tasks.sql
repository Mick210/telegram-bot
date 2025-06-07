-- liquibase formatted sql

-- changeset msidorenko:1
CREATE TABLE tasks
(
    id                SERIAL PRIMARY KEY,
    chat_id           INTEGER,
    notification_task TEXT,
    date_time         TIMESTAMP
);



