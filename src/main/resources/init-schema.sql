CREATE TABLE users
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)       NULL,
    age  INT                NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE autos
(
    id      INT AUTO_INCREMENT NOT NULL,
    model   VARCHAR(255)       NULL,
    color   VARCHAR(255)       NULL,
    user_id INT                NULL,
    CONSTRAINT pk_autos PRIMARY KEY (id)
);

ALTER TABLE autos
    ADD CONSTRAINT FK_AUTOS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);
