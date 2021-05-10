-- --------- --
-- Role data --
-- --------- --
INSERT INTO "bdEcotransport"."public"."role" (role_id, role_name)
    VALUES (1, 'Cliente'), (2, 'Admin');


-- --------- --
-- User Data --
-- --------- --
INSERT INTO "bdEcotransport"."public"."user" (user_id, username, password, "names", surnames)
    VALUES (1, 'hlopezm', '$2a$10$WBrK1hLx2Go/alh38HuQdu4wW4P8pFo.rLcH7oskis9yKut77ZwDO', 'HUMBERTO', 'LÓPEZ MIRANDA'),
        (2, 'spastore', '$2a$10$3Ai.b.v/SJtTEjJeOWgPLeoMhKyEUJb.uuK0tws310LQfKKQuN5JO', 'SALVADOR', 'PASTOR ESPINOZA'),
        (3, 'rperezg', '$2a$10$lBpVDdvg7APyo/ozWmrb0el1y44eTqPv5quwK/Cf8ZcNl/TNzxG6W', 'TOMÁS', 'PÉREZ GIL'),
        (4, 'jmendezs', '$2a$10$MuvQDfRNfbs/q00Q1YzBNeFd28/9QUML.vy1az6FoWYtZcXzuGCcK', 'JONATHAN', 'MÉNDEZ SOSA'),
        (5, 'ntapiaa', '$2a$10$K5LjicrVUsLto0yyiSOxyeRSzPCSwQ424CacXk2LZuKE3guD/IVoK', 'NANCY', 'TAPIA ÁRIAS');
ALTER SEQUENCE user_user_id_seq RESTART WITH 6;

-- -------------- --
-- Role User Data --
-- -------------- --
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (1, 2);
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (2, 1);
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (3, 1);
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (4, 1);
INSERT INTO "bdEcotransport"."public"."user_role" (user_id, role_id) VALUES (5, 1);

-- ----------- --
-- Estacion Data --
-- ----------- --
INSERT INTO "bdEcotransport"."public"."estacion" (estacion_id, estacion_name) VALUES (1, 'Banderas');
INSERT INTO "bdEcotransport"."public"."estacion" (estacion_id, estacion_name) VALUES (2, 'Salitre');
ALTER SEQUENCE estacion_estacion_id_seq RESTART WITH 3;

-- ---------------- --
-- Association Data --
-- ---------------- --
INSERT INTO "bdEcotransport"."public"."association" (association_id, user_id, role_id, estacion_id)
    VALUES (1, 1, 2, 1);
INSERT INTO "bdEcotransport"."public"."association" (association_id, user_id, role_id, estacion_id)
    VALUES (2, 2, 1, 1);
INSERT INTO "bdEcotransport"."public"."association" (association_id, user_id, role_id, estacion_id)
    VALUES (3, 3, 1, 1);
INSERT INTO "bdEcotransport"."public"."association" (association_id, user_id, role_id, estacion_id)
    VALUES (4, 5, 1, 2);
INSERT INTO "bdEcotransport"."public"."association" (association_id, user_id, role_id, estacion_id)
    VALUES (5, 4, 1, 2);
INSERT INTO "bdEcotransport"."public"."association" (association_id, user_id, role_id, estacion_id)
    VALUES (6, 3, 1, 2);