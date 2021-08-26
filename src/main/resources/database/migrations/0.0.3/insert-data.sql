INSERT INTO "bdEcotransport"."public"."role" (role_id, role_name)
VALUES (1, 'Cliente'), (2, 'Admin');

-- --------- --
-- User Data --
-- --------- --
INSERT INTO "bdEcotransport"."public"."user" (user_id, username, password, names, surnames, identity_number, email, user_phone, security_question, security_answer, user_state)
VALUES (1, 'mvalbuenag', '$2a$10$WBrK1hLx2Go/alh38HuQdu4wW4P8pFo.rLcH7oskis9yKut77ZwDO', 'MAGNERT', 'VALBUENA', '1070988435', 'mvalbuenag@gmail.com', '(310) 558 4599', '¿Nombre de su madre?', 'Laura', 'ACTIVO'),
       (2, 'kibarra', '$2a$10$3Ai.b.v/SJtTEjJeOWgPLeoMhKyEUJb.uuK0tws310LQfKKQuN5JO', 'KEVIN', 'IBARRA', '1078988635', 'kibarra@gmail.com', '(310) 528 4585', '¿Primer vehículo que compró?', 'Spark', 'ACTIVO'),
       (3, 'gnpinedal', '$2a$10$lBpVDdvg7APyo/ozWmrb0el1y44eTqPv5quwK/Cf8ZcNl/TNzxG6W', 'GERSON', 'PINEDA', '1078988640', 'gnpinedal@gmail.com', '(315) 558 2285', '¿Raza de su primera mascota?', 'Labrador', 'ACTIVO'),
       (4, 'nrodriguezs', '$2a$10$MuvQDfRNfbs/q00Q1YzBNeFd28/9QUML.vy1az6FoWYtZcXzuGCcK', 'NICOLAS', 'RODRIGUEZ', '1078182640', 'nrodriguezs@gmail.com', '(319) 558 4585', '¿Primer vehículo que compró?', 'Aveo', 'ACTIVO'),
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

-- ----------- --
-- station Data --
-- ----------- --
INSERT INTO "bdEcotransport"."public"."station" (station_id, station_name,station_address,station_phone,station_open_time,station_close_time,station_city,station_available,station_inventory)
VALUES (1, 'Suba', 'Cl. 138 #54-60','(310) 558 4599','06:00','21:00','Bogota','5','5');
INSERT INTO "bdEcotransport"."public"."station" (station_id, station_name,station_address,station_phone,station_open_time,station_close_time,station_city,station_available,station_inventory)
VALUES (2, 'Kennedy', 'Carrera 72 n, Cl. 38 Sur ## 34','(310) 528 4585','06:00','21:00','Bogota','5','5');
INSERT INTO "bdEcotransport"."public"."station" (station_id, station_name,station_address,station_phone,station_open_time,station_close_time,station_city,station_available,station_inventory)
VALUES (3, 'Usme', 'Cra. 5 Este #100b Sur-15 a 100b','(315) 558 2285','06:00','21:00','Bogotá','5','5');
INSERT INTO "bdEcotransport"."public"."station" (station_id, station_name,station_address,station_phone,station_open_time,station_close_time,station_city,station_available,station_inventory)
VALUES (4, 'Soacha', 'Cra. 3 #30-2 a 30-90','(319) 558 4585','06:00','21:00','Soacha','5','5');
ALTER SEQUENCE station_station_id_seq RESTART WITH 5;

-- ----------- --
-- bicycle Data --
-- ----------- --
INSERT INTO "bdEcotransport"."public"."bicycle" (bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (1, 'Yamaha 2021 500Watts', 'H1F1SAFE21SQ', 'Disponible', 1);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (2, 'Yamaha 2021 500Watts', 'H1F1SAFE21SR', 'Disponible', 1);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (3, 'Yamaha 2021 500Watts', 'H1F1SAFE21SS', 'Disponible', 1);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (4, 'Yamaha 2021 500Watts', 'H1F1SAFE21ST', 'Disponible', 1);
INSERT INTO "bdEcotransport"."public"."bicycle"(bicycle_id, bicycle_vendor,bicycle_serial,bicycle_status,station_id)
VALUES (5, 'Yamaha 2021 500Watts', 'H1F1SAFE21SU', 'Disponible', 1);
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
VALUES (20, 'Yamaha 2021 500Watts', 'H1F1SAFE21SP', 'Disponible', 4);
ALTER SEQUENCE bicycle_bicycle_id_seq RESTART WITH 21;

-- ----------- --
-- payment Data --
-- ----------- --
INSERT INTO "bdEcotransport"."public"."payment" (payment_id, payment_type)
VALUES (1,'Efectivo');
INSERT INTO "bdEcotransport"."public"."payment" (payment_id, payment_type)
VALUES (2,'PSE');
ALTER SEQUENCE payment_payment_id_seq RESTART WITH 3;