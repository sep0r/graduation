DELETE
FROM user_roles;
DELETE
FROM votes;
DELETE
FROM users;
DELETE
FROM RESTAURANTS;
DELETE
FROM DISHES;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO restaurants (name, description)
VALUES ('ЧEBUREK', 'description 1'),
       ('Пельменная №2', 'description 2'),
       ('Хуторок', 'description 3'),
       ('Златибор', 'description 4'),
       ('Four', 'description 5');

INSERT INTO dishes (rest_id, date_add, name, price)
VALUES (100002, '2021-01-30', 'Лапша удон', 1200),
       (100003, '2021-01-30', 'Отбивные из фарша', 300),
       (100004, '2021-01-30', 'Куриные рулеты с грибами', 150),
       (100005, '2021-01-30', 'Жульен из курицы', 200),
       (100006, '2021-01-30', 'Тушеный картофель с мясом', 280),
       (100002, '2021-01-29', 'Котлеты из овощей', 100),
       (100003, '2021-01-29', 'Курица в томатном соусе', 300),
       (100005, '2021-01-29', 'Паста с помидорами', 150),
       (100002, '2021-01-29', 'Гуляш из печени говяжьей', 700),
       (100006, '2021-01-28', 'Сибирские пельмени', 550);

INSERT INTO votes (user_id, restaurants_id)
VALUES (100000, 100002),
       (100001, 100003),
       (100000, 100004),
       (100000, 100002),
       (100001, 100006),
       (100000, 100002),
       (100001, 100003),
       (100000, 100004),
       (100000, 100002),
       (100001, 100006);