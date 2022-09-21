DROP TABLE IF EXISTS BOOKING CASCADE;
CREATE TABLE BOOKING
(
    id           UUID,
    name         VARCHAR(50) NOT NULL,
    booking_type VARCHAR(2000) NOT NULL,
    status       VARCHAR(2000) NOT NULL,

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS MEMBER CASCADE;
CREATE TABLE MEMBER
(
    id            UUID,
    username      VARCHAR(2000) NOT NULL,
    email         VARCHAR(2000) NOT NULL,
    firstname     VARCHAR(2000) NOT NULL,
    lastname      VARCHAR(2000) NOT NULL,
    password_hash VARCHAR(2000) NOT NULL,
    newsletter    BOOLEAN       NOT NULL DEFAULT TRUE,
    is_admin      BOOLEAN       NOT NULL DEFAULT FALSE,

    PRIMARY KEY (id)
);