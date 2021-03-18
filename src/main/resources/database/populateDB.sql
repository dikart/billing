DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin'),
       ('User', 'user@yandex.ru', 'password');

INSERT INTO user_roles(user_id, role)
VALUES (100000, 'ADMIN'),
       (100001, 'USER')
