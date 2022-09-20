DROP TABLE IF EXISTS CATEGORY CASCADE;
CREATE TABLE CATEGORY
(
    id   UUID,
    name VARCHAR(50) NOT NULL,

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS GAME CASCADE;
CREATE TABLE GAME
(
    id       UUID,
    name     VARCHAR(50) NOT NULL,
    booking_type ENUM('MORNING','AFTERNOON','DAY') NOT NULL,
    status ENUM('APPROVED', 'DECLINED', 'PENDING'),
    category UUID NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (category) REFERENCES CATEGORY (id)
);

DROP TABLE IF EXISTS MEMBER CASCADE;
CREATE TABLE MEMBER
(
    id            UUID,
    username      VARCHAR(2000) NOT NULL,
    email VARCHAR(2000) NOT NULL,
    firstname VARCHAR(2000) NOT NULL,
    lastname VARCHAR(2000) NOT NULL,
    password_hash VARCHAR(2000) NOT NULL,
    newsletter BOOLEAN NOT NULL DEFAULT TRUE,
    is_admin      BOOLEAN       NOT NULL DEFAULT FALSE,

    PRIMARY KEY (id)
);