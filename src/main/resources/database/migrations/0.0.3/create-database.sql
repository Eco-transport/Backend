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
    "identity_number" VARCHAR(10) NOT NULL,
    "email" VARCHAR(100) NOT NULL,
    "user_phone" VARCHAR(10) NOT NULL,
    "security_question" VARCHAR(100) NOT NULL,
    "security_answer" VARCHAR(100) NOT NULL,
    "user_state" VARCHAR(10) NOT NULL,
    PRIMARY KEY ("user_id")
);


-- ------------------------------ --
-- Table "bdEcotransport"."public"."estacion" --
-- ------------------------------ --
CREATE TABLE IF NOT EXISTS "bdEcotransport"."public"."station"
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
-- Table "bdEcotransport"."public"."payment" --
-- ---------------------------- --
/* CREATE TABLE IF NOT EXISTS "bdEcotransport"."public"."payment"
(
    "payment_id"   INTEGER     NOT NULL,
    "payment_type" VARCHAR(20) NOT NULL,
    PRIMARY KEY ("payment_id")
);

-- ---------------------------- --
-- Table "bdEcotransport"."public"."bicycle" --
-- ---------------------------- --
CREATE TABLE IF NOT EXISTS "bdEcotransport"."public"."bicycle"
(
    "bicycle_id"   INTEGER     NOT NULL,
    "bicycle_name" VARCHAR(20) NOT NULL,
    "bicycle_vendor" VARCHAR(20) NOT NULL,
    "bicycle_stock"   INTEGER     NOT NULL,
    "bicycle_buy_price"   FLOAT     NOT NULL,
    
    
    PRIMARY KEY ("bicycle_id")
);

-- ---------------------------- --
-- Table "bdEcotransport"."public"."order" --
-- ---------------------------- --
CREATE TABLE IF NOT EXISTS "bdEcotransport"."public"."order"
(
    "order_id"  SERIAL       NOT NULL,
    "order_date"  TIMESTAMP       NOT NULL,
    "order_status"  VARCHAR(25)       ,
    "order_comments"  VARCHAR(255)       ,    
    PRIMARY KEY ("order_id")
); */

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


