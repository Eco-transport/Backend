-- --------- --
-- Role data --
-- --------- --
INSERT INTO "bdEcotransport"."public"."role" (role_id, role_name)
    VALUES (1, 'Cliente'), (2, 'Admin');

-- --------- --
-- User Data --
-- --------- --
INSERT INTO "bdEcotransport"."public"."user" (user_id, username, password, names, surnames, identity_number, email, user_phone, security_question, security_answer, user_state)
VALUES (1, 'suba', '$2a$10$WBrK1hLx2Go/alh38HuQdu4wW4P8pFo.rLcH7oskis9yKut77ZwDO', 'SUBA', 'SUBA', '0000000001', 'adminSuba@gmail.com', '(310) 558 4599', '¿Nombre de la estación?', 'SUBA', 'ACTIVO'),
       (2, 'kennedy', '$2a$10$3Ai.b.v/SJtTEjJeOWgPLeoMhKyEUJb.uuK0tws310LQfKKQuN5JO', 'KENNEDY', 'KENNEDY', '0000000002', 'adminKennedy@gmail.com', '(310) 528 4585', '¿Nombre de la estación?', 'KENNEDY', 'ACTIVO'),
       (3, 'usme', '$2a$10$lBpVDdvg7APyo/ozWmrb0el1y44eTqPv5quwK/Cf8ZcNl/TNzxG6W', 'USME', 'USME', '0000000003', 'adminUsme@gmail.com', '(315) 558 2285', 'Nombre de la estación', 'USME', 'ACTIVO'),
       (4, 'soacha', '$2a$10$MuvQDfRNfbs/q00Q1YzBNeFd28/9QUML.vy1az6FoWYtZcXzuGCcK', 'SOACHA', 'SOACHA', '0000000004', 'adminSoacha@gmail.com', '(319) 558 4585', '¿Nombre de la estación?', 'SOACHA', 'ACTIVO'),
       (5, 'ntapiaa', '$2a$10$K5LjicrVUsLto0yyiSOxyeRSzPCSwQ424CacXk2LZuKE3guD/IVoK', 'NANCY', 'TAPIA ÁRIAS', '0000000005', 'nancy@gmail.com', '(319) 557 4585', '¿Nombre de su madre?', 'Nidia', 'ACTIVO');
ALTER SEQUENCE user_user_id_seq RESTART WITH 6;

-- -------------- --
-- Role User Data --
-- -------------- --
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (1, 2);
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (2, 2);
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (3, 2);
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (4, 2);
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (5, 1);

-- ------------ --
-- Station Data --
-- ------------ --
INSERT INTO "bdEcotransport"."public"."station" (station_id, station_name,station_address,station_phone,station_open_time,station_close_time,station_city,station_available,station_inventory)
VALUES (1, 'Suba', 'Cl. 138 #54-60','(310) 558 4599','7:00 am','6:00 pm','Bogota','5','5');
INSERT INTO "bdEcotransport"."public"."station" (station_id, station_name,station_address,station_phone,station_open_time,station_close_time,station_city,station_available,station_inventory)
VALUES (2, 'Kennedy', 'Carrera 72 n, Cl. 38 Sur ## 34','(310) 528 4585','7:00 am','6:00 pm','Bogota','5','5');
INSERT INTO "bdEcotransport"."public"."station" (station_id, station_name,station_address,station_phone,station_open_time,station_close_time,station_city,station_available,station_inventory)
VALUES (3, 'Usme', 'Cra. 5 Este #100b Sur-15 a 100b','(315) 558 2285','7:00 am','6:00 pm','Bogotá','5','5');
INSERT INTO "bdEcotransport"."public"."station" (station_id, station_name,station_address,station_phone,station_open_time,station_close_time,station_city,station_available,station_inventory)
VALUES (4, 'Soacha', 'Cra. 3 #30-2 a 30-90','(319) 558 4585','7:00 am','6:00 pm','Soacha','5','5');
ALTER SEQUENCE station_station_id_seq RESTART WITH 5;

-- ------------ --
-- Bicycle Data --
-- ------------ --
INSERT INTO "bdEcotransport"."public"."bicycle" (bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (1, 'Yamaha 2021 500Watts', 'F12SE522S14D', 'Disponible', 1);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (2, 'Yamaha 2021 500Watts', 'DFGSR1FD21RF', 'Disponible', 1);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (3, 'Yamaha 2021 500Watts', 'SDF12ES41D1E', 'Disponible', 1);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (4, 'Yamaha 2021 500Watts', '231ESW5SF12A', 'Disponible', 1);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (5, 'Yamaha 2021 500Watts', 'H1F1SAFE21SE', 'Disponible', 1);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (6, 'Yamaha 2021 500Watts', 'H1F1SAFE21SA', 'Disponible', 2);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (7, 'Yamaha 2021 500Watts', 'H1F1SAFE21SB', 'Disponible', 2);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (8, 'Yamaha 2021 500Watts', 'H1F1SAFE21SC', 'Disponible', 2);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (9, 'Yamaha 2021 500Watts', 'H1F1SAFE21SD', 'Disponible', 2);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (10, 'Yamaha 2021 500Watts', 'H1F1SAFE21SF', 'Disponible', 2);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (11, 'Yamaha 2021 500Watts', 'H1F1SAFE21SG', 'Disponible', 3);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (12, 'Yamaha 2021 500Watts', 'H1F1SAFE21SH', 'Disponible', 3);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (13, 'Yamaha 2021 500Watts', 'H1F1SAFE21SI', 'Disponible', 3);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (14, 'Yamaha 2021 500Watts', 'H1F1SAFE21SJ', 'Disponible', 3);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (15, 'Yamaha 2021 500Watts', 'H1F1SAFE21SK', 'Disponible', 3);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (16, 'Yamaha 2021 500Watts', 'H1F1SAFE21SL', 'Disponible', 4);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (17, 'Yamaha 2021 500Watts', 'H1F1SAFE21SM', 'Disponible', 4);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (18, 'Yamaha 2021 500Watts', 'H1F1SAFE21SN', 'Disponible', 4);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (19, 'Yamaha 2021 500Watts', 'H1F1SAFE21SO', 'Disponible', 4);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (20, 'Yamaha 2021 500Watts', 'H1F1SAFE21SU', 'Disponible', 4);
ALTER SEQUENCE bicycle_bicycle_id_seq RESTART WITH 21;

-- ------------ --
-- Payment Data --
-- ------------ --
INSERT INTO "bdEcotransport"."public"."payment" (payment_id, payment_type)
VALUES (1,'Efectivo');
INSERT INTO "bdEcotransport"."public"."payment" (payment_id, payment_type)
VALUES (2,'PSE');
ALTER SEQUENCE payment_payment_id_seq RESTART WITH 3;

-- ---------- --
-- Order Data -- (Solo pruebas)
-- ---------- --
/*
INSERT INTO "bdEcotransport"."public"."order" (order_id, order_date,order_status,order_hours, order_price, payment_id, station_id, user_id)
	VALUES (1,'2021-06-14 20:44:11', 'Pendiente pago', 2, 20000, 1, 1, 3);
ALTER SEQUENCE order_order_id_seq RESTART WITH 2;

INSERT INTO "bdEcotransport"."public"."order" (order_id, order_date,order_status, payment_id, station_id, user_id)
	VALUES (2,'2021-06-14 21:44:11', 'Pendiente pago', 1, 2, 4);
INSERT INTO "bdEcotransport"."public"."order" (order_id, order_date,order_status, payment_id, station_id, user_id)
	VALUES (3,'2021-06-14 22:44:11', 'Pagado', 1, 2, 3);
INSERT INTO "bdEcotransport"."public"."order" (order_id, order_date,order_status, payment_id, station_id, user_id)
	VALUES (4,'2021-06-14 23:44:11', 'Cancelado', 1, 3, 3);
INSERT INTO "bdEcotransport"."public"."order" (order_id, order_date,order_status, payment_id, station_id, user_id)
	VALUES (5,'2021-06-14 23:50:11', 'Pagado', 1, 3, 3);
INSERT INTO "bdEcotransport"."public"."order" (order_id, order_date,order_status, payment_id, station_id, user_id)
	VALUES (6,'2021-06-14 11:44:11', 'Pagado', 1, 3, 5);
INSERT INTO "bdEcotransport"."public"."order" (order_id, order_date,order_status, payment_id, station_id, user_id)
	VALUES (7,'2021-06-14 10:44:11', 'Pendiente pago', 1, 3, 5);
*/