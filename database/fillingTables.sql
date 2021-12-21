USE onlineShop1;

INSERT INTO Roles (role)
VALUES ('user');

INSERT INTO Roles (role)
VALUES ('admin');


INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Евгений', 'Цуриков', 'Олегович', 380663333942);

INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Сергей', 'Александров', 'Петрович', 380663333942);

INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Danylo', 'Borgev', 'Sergeevich', 375442114982);


INSERT INTO BankCards (card_number, expiration_year, expiration_month, card_owner, cvv, balance)
VALUES (5168634532543153, 2022, 07, 'Sergei Petrov', 333, 99999.32);

INSERT INTO BankCards (card_number, expiration_year, expiration_month, card_owner, cvv, balance)
VALUES (3153325463455168, 2023, 08, 'Danylo Borgev', 335, 99999.32);


INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (1, 2, 'tszheka@gmail.com', 'sdfhyjug');

INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (2, 1, 'sergei.aleksandrov@gmail.com', 'avpzcheck');

INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (3, 1, 'danylo.borgev@gmail.com', 'avpzcheck');


INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('г. Харьков, ул. Бакулина д. 22', '2021-11-30', '2021-12-10', 'зарегистрирован');

INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('г. Харьков, ул. Бакулина д. 6', '2021-11-30', '2021-12-10','зарегистрирован');


INSERT INTO Categories (category)
VALUES ('Телефоны');

INSERT INTO Categories (category)
VALUES ('Ноутбуки');

INSERT INTO Categories (category)
VALUES ('Инструменты');


INSERT INTO Products (category_id, name, price, status, photo, color, orders_number, description)
VALUES (1, 'Apple iPhone 13 Pro Max 256GB', 46499.00, 1, 'phones/Apple_iPhone_13_Pro_Max_256GB_Sierra_Blue.jpg', 'Sierra Blue',6,
        'Экран (6.7", OLED (Super Retina XDR), 2778x1284) / Apple A15 Bionic / тройная основная камера: 12 Мп + 12 Мп + 12 Мп,
         фронтальная камера: 12 Мп / 256 ГБ встроенной памяти / 3G / LTE / 5G / GPS / Nano-SIM / iOS 15');

INSERT INTO Products (category_id, name, price, status, photo, color, orders_number, description)
VALUES (1, 'Motorola Moto G60 6/128GB', 6999.00, 1, 'phones/Motorola_Moto_G60_6_128GB_Haze_Gray.jpg', 'Haze Gray',5,
        'Экран (6.8", IPS, 2460x1080) / Qualcomm Snapdragon 732G (2 х 2.3 ГГц + 6 х 1.8 ГГц) / основная тройная камера: 108 Мп
        + 8 Мп + 2 Мп, фронтальная камера: 32 Мп / RAM 6 ГБ / 128 ГБ встроенной памяти +
        microSD (до 1 ТБ) / 3G / LTE / GPS / поддержка 2х SIM-карт (Nano-SIM) / Android 11 / 6000 мА*ч');


INSERT INTO Products (category_id, name, price, status, photo, color, orders_number, description)
VALUES (2, 'Apple MacBook Air 13" M1 256GB 2020 (MGN63)', 33999.00, 1, 'laptops/Apple_MacBook_Air_13_M1_256GB_2020.jpg', 'Space Gray', 10,
        'Экран 13.3" Retina (2560x1600) WQXGA, глянцевый / Apple M1 / RAM 8 ГБ / SSD 256 ГБ / Apple M1 Graphics / Wi-Fi
        / Bluetooth / macOS Big Sur / 1.29 кг / серый');

INSERT INTO Products (category_id, name, price, status, photo, color, orders_number, description)
VALUES (2, 'Honor MagicBook X 15', 16499.00, 1, 'laptops/Honor_MagicBook_X_15.jpg', 'Black',3,
        'Экран 15.6" IPS (1920х1080) Full HD, глянцевый с антибликовым покрытием / Intel Core i3-10110U (2.1 - 4.1 ГГц)
        / RAM 8 ГБ / SSD 256 ГБ / Intel UHD Graphics / без ОД / Wi-Fi / Bluetooth / веб-камера / Windows 10 Home 64bit
        / 1.56 кг / серый');

INSERT INTO Products (category_id, name, price, status, photo, color, orders_number, description)
VALUES (3, 'Набор бит Metabo BitBox 29 шт', 200.50, 1, 'tools/Metabo_BitBox_29.jpg', 'Green', 2,
        'Набор бит Metabo BitBox включает в себя 27 бит, переходник и магнитный держатель насадок. Особенности: длина бит:
        25 мм и 50 мм, материал: хромованадиевая сталь, высококачественный футляр');

INSERT INTO Products (category_id, name, price, status, photo, color, orders_number, description)
VALUES (3, 'Аккумуляторная дрель-шуруповерт Metabo PowerMaxx BS 2х2.0 Ач', 859.00, 1,
        'tools/Metabo_PowerMaxx_BS.jpg', 'Green', 1,
        'Легкий и компактный дрель-шуруповерт — укороченная конструкция для универсального использования.');


INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (1, 3, 1, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (4, 3, 1, 1);