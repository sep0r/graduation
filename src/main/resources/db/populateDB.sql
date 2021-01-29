DELETE
FROM user_roles;
DELETE
FROM votes;
DELETE
FROM users;
DELETE
FROM menu;
DELETE
FROM RESTAURANTS;
DELETE
FROM DISHES;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User1', 'user1@yandex.ru', 'password1'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('User2', 'user2@yandex.ru', 'password2'),
       ('User3', 'user3@yandex.ru', 'password3');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO restaurants (name, description)
VALUES ('ЧEBUREK', 'description 1'),
       ('Пельменная №2', 'description 2'),
       ('Хуторок', 'description 3'),
       ('Златибор', 'description 4'),
       ('Four', 'description 5');

INSERT INTO menu (date, restaurant_id)
VALUES ('2020-05-20', 100004),
       ('2020-05-20', 100005),
       ('2020-05-20', 100006),
       ('2020-05-21', 100007),
       ('2020-05-21', 100008);

INSERT INTO dishes (menu_id, name, price)
VALUES (100009, 'Лапша удон', 1200),
       (100010, 'Отбивные из фарша', 300),
       (100011, 'Куриные рулеты с грибами', 150),
       (100012, 'Жульен из курицы', 200),
       (100013, 'Тушеный картофель с мясом', 280),
       (100009, 'Котлеты из овощей', 100),
       (100009, 'Курица в томатном соусе', 300),
       (100009, 'Паста с помидорами', 150),
       (100010, 'Гуляш из печени говяжьей', 700),
       (100012, 'Сибирские пельмени', 550);

INSERT INTO votes (user_id, restaurants_id, date)
VALUES (100000, 100006, '2020-05-20'),
       (100001, 100005, '2020-05-20'),
       (100002, 100004, '2020-05-20'),
       (100003, 100004, '2020-05-20'),
       (100001, 100007, '2020-05-21'),
       (100000, 100008, '2020-05-21'),
       (100002, 100008, '2020-05-21'),
       (100003, 100008, '2020-05-21');