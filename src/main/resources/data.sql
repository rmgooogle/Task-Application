DROP TABLE IF EXISTS MASTERS;
DROP TABLE IF EXISTS PLANETS;

CREATE TABLE MASTERS (
                         id   LONG NOT NULL AUTO_INCREMENT,
                         name VARCHAR(128) NOT NULL,
                         age LONG NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE PLANETS (
                         id   LONG  NOT NULL AUTO_INCREMENT,
                         name VARCHAR(128) NOT NULL,
                         master_id LONG REFERENCES MASTERS(id),
                         PRIMARY KEY (id)
);

insert into MASTERS (name, age) values
                                       ('Эн Дви Гаст', 14000000),
                                       ('Локи', 1052),
                                       ('Тор', 1500),
                                       ('Один', 10001),
                                       ('Бездельник', 29),
                                       ('Ван', 404),
                                       ('Малекит', 404),
                                       ('Эйтри', 404),
                                       ('Суртур', 8001),
                                       ('Бездельница', 28),
                                       ('Хелла', 4500);


insert into PLANETS (name, master_id) values
                                       ('Сакаар', 1),
                                       ('Йотунхейм', 2),
                                       ('Земля', 3),
                                       ('Асгард', 4),
                                       ('Ванахейм', 6),
                                       ('Ванахейм', 7),
                                       ('Нидавеллир', 8),
                                       ('Муспельхейм', 9),
                                       ('Нифльхейм', 11);

