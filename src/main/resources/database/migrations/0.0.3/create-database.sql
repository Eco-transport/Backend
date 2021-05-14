DROP TABLE IF EXISTS "bdEcotransport"."public"."association";
DROP TABLE IF EXISTS "bdEcotransport"."public"."estacion";
DROP TABLE IF EXISTS "bdEcotransport"."public"."user_role";
DROP TABLE IF EXISTS "bdEcotransport"."public"."user";
DROP TABLE IF EXISTS "bdEcotransport"."public"."role";


-- ---------------------------- --
-- Table "bdEcotransport"."public"."user" --
-- ---------------------------- --
CREATE TABLE IF NOT EXISTS "bdEcotransport"."public"."user"
(
    "user_id"  SERIAL       NOT NULL,
    "username" VARCHAR(10)  NOT NULL,
    "password" VARCHAR(256) NOT NULL,
    "names"    VARCHAR(100) NOT NULL,
    "surnames" VARCHAR(100) NOT NULL,
    PRIMARY KEY ("user_id")
);


-- ------------------------------ --
-- Table "bdEcotransport"."public"."estacion" --
-- ------------------------------ --
CREATE TABLE IF NOT EXISTS "bdEcotransport"."public"."estacion"
(
    "station_id"      SERIAL       NOT NULL,
    "station_name"    VARCHAR(100) NOT NULL,
    "station_address"  VARCHAR(100) NOT NULL,
    "station_phone"     VARCHAR(100) NOT NULL,
    "station_city"      VARCHAR(100) NOT NULL,
    "station_available" INTEGER NOT NULL,
    "station_inventory" INTEGER NOT NULL,
    "station_open_time"     VARCHAR(100) NOT NULL,
    "station_close_time"      VARCHAR(100) NOT NULL,
    PRIMARY KEY ("station_id")
);


-- ---------------------------- --
-- Table "bdEcotransport"."public"."role" --
-- ---------------------------- --
CREATE TABLE IF NOT EXISTS "bdEcotransport"."public"."role"
(
    "role_id"   INTEGER     NOT NULL,
    "role_name" VARCHAR(20) NOT NULL,
    PRIMARY KEY ("role_id")
);


-- --------------------------------- --
-- Table "bdEcotransport"."public"."user_role" --
-- --------------------------------- --
CREATE TABLE IF NOT EXISTS "bdEcotransport"."public"."user_role"
(
    "user_id" INT NOT NULL,
    "role_id" INT NOT NULL,
    PRIMARY KEY ("user_id", "role_id"),
    CONSTRAINT "fk_user_id"
        FOREIGN KEY ("user_id")
            REFERENCES "bdEcotransport"."public"."user" ("user_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT "fk_role_id"
        FOREIGN KEY ("role_id")
            REFERENCES "bdEcotransport"."public"."role" ("role_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE INDEX "idx_user_role_user_id" ON "bdEcotransport"."public"."user" ("user_id" ASC);
CREATE INDEX "idx_user_role_role_id" ON "bdEcotransport"."public"."role" ("role_id" ASC);


-- ----------------------------------- --
-- Table "bdEcotransport"."public"."association" --
-- ----------------------------------- --
/* CREATE TABLE IF NOT EXISTS "bdEcotransport"."public"."association"
(
    "association_id" SERIAL NOT NULL,
    "user_id"        INT    NOT NULL,
    "role_id"        INT    NOT NULL,
    "estacion_id"      INT    NOT NULL,
    PRIMARY KEY ("association_id"),
    CONSTRAINT "fk_user_role"
        FOREIGN KEY ("user_id", "role_id")
            REFERENCES "bdEcotransport"."public"."user_role" ("user_id", "role_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT "fk_Estacion"
        FOREIGN KEY ("estacion_id")
            REFERENCES "bdEcotransport"."public"."estacion" ("estacion_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE INDEX "idx_association_user_role_id" ON "bdEcotransport"."public"."association" ("user_id" ASC, "role_id" ASC);
CREATE INDEX "idx_association_Estacion_id" ON "bdEcotransport"."public"."association" ("estacion_id" ASC);
 */

