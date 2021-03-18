DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;


CREATE SEQUENCE IF NOT EXISTS global_seq START WITH 100000;
CREATE TABLE IF NOT EXISTS users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq') NOT NULL,
    name       VARCHAR(255)                                      NOT NULL,
    email      VARCHAR(255)                                      NOT NULL,
    phone      VARCHAR(15),
    address    TEXT,
    inn_kpp    VARCHAR(100),
    password   VARCHAR(255)                                      NOT NULL,
    registered TIMESTAMP           DEFAULT now()                 NOT NULL,
    enabled    BOOLEAN             DEFAULT true                  NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);
CREATE TABLE IF NOT EXISTS user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);



