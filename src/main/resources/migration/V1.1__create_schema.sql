BEGIN;

USE `beezzy`;


CREATE TABLE ROLES(
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  ROLE_NAME VARCHAR(30) NOT NULL
);

CREATE TABLE PERMISSIONS(
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  PERMISSION_NAME VARCHAR(30) NOT NULL
);

CREATE TABLE ROLE_TO_PERMISSION(
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  ROLE_ID INTEGER,
  PERMISSION_ID INTEGER,
  CONSTRAINT `fk_ROLE_TO_PERMISSION_role_id` FOREIGN KEY (ROLE_ID) REFERENCES ROLES(ID) ON DELETE NO ACTION,
  CONSTRAINT `fk_ROLE_TO_PERMISSION_permission_id` FOREIGN KEY (PERMISSION_ID) REFERENCES PERMISSIONS(ID) ON DELETE NO ACTION
);

CREATE TABLE USERS(
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  EMAIL VARCHAR(50) NOT NULL,
  PASSWORD VARCHAR(20) NOT NULL,
  ROLE_ID INTEGER,
  ACTIVE TINYINT(1) DEFAULT 0,
  UNIQUE(EMAIL),
  CONSTRAINT `fk_USERS_role_id` FOREIGN KEY (ROLE_ID) REFERENCES ROLES(ID) ON DELETE NO ACTION
);

CREATE TABLE CATEGORY(
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  PARENT_ID INTEGER,
  CONSTRAINT `fk_CATEGORY_parent_id` FOREIGN KEY (PARENT_ID) REFERENCES CATEGORY(ID) ON DELETE NO ACTION
);

CREATE TABLE SHOPS(
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  DESCRIPTION TEXT,
  OWNER_ID INTEGER,
  CONSTRAINT `fk_SHOPS_owner_id` FOREIGN KEY (OWNER_ID) REFERENCES USERS(ID) ON DELETE NO ACTION
);

CREATE TABLE GOODS(
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  CATEGORY_ID INTEGER NOT NULL,
  DESCRIPTION TEXT,
  SHOP_ID INTEGER,
  CONSTRAINT `fk_GOODS_shop_id` FOREIGN KEY (SHOP_ID) REFERENCES SHOPS(ID) ON DELETE NO ACTION,
  CONSTRAINT `fk_GOODS_category_id` FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY(ID) ON DELETE NO ACTION
);

CREATE TABLE VARIETY(
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  DESCRIPTION TEXT NOT NULL,
  AMOUNT INTEGER DEFAULT 0,
  GOODS_ID INTEGER,
  PURCHASE_PRICE REAL NOT NULL,
  SELLING_PRICE REAL NOT NULL,
  CODE VARCHAR(30) NOT NULL,
  UNIQUE(CODE),
  CONSTRAINT `fk_VARIETY_goods_id` FOREIGN KEY (GOODS_ID) REFERENCES GOODS(ID) ON DELETE NO ACTION
);

COMMIT;

