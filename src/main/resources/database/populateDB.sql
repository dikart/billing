DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('User', 'user@yandex.ru', '{noop}password');

INSERT INTO user_roles(user_id, role)
VALUES (100000, 'ROLE_ADMIN'),
       (100001, 'ROLE_USER')
