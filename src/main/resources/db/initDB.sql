DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR(255)                      NOT NULL,
    email      VARCHAR(255)                      NOT NULL,
    password   VARCHAR(255)                      NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE votes
(
    id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id        INTEGER NOT NULL,
    restaurants_id INTEGER NOT NULL,
    date           DATE    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (restaurants_id) REFERENCES restaurants (id) ON DELETE CASCADE,
    CONSTRAINT user_date_idx UNIQUE (user_id, date)
);
CREATE INDEX fki_votes_rest ON votes (restaurants_id);
CREATE INDEX fki_votes_user ON votes (user_id);

CREATE TABLE menu
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    date          DATE    NOT NULL,
    restaurant_id INTEGER NOT NULL,
    CONSTRAINT date_restaurant_idx UNIQUE (date, restaurant_id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE dishes
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    menu_id INTEGER      NOT NULL,
    name    VARCHAR(255) NOT NULL,
    price   INT          NOT NULL,
    CONSTRAINT dishes_unique_idx UNIQUE (menu_id, name, price),
    FOREIGN KEY (menu_id) REFERENCES menu (id) ON DELETE CASCADE
);
CREATE INDEX fki_dishes_rest ON dishes (menu_id);