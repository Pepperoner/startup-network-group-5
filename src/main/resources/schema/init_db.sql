DROP DATABASE IF EXISTS startupdb;
CREATE DATABASE IF NOT EXISTS startupdb
  DEFAULT CHARACTER SET utf8;
USE startupdb;

CREATE TABLE users
(
  id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) DEFAULT '' NOT NULL,
  password VARCHAR(60) DEFAULT '' NOT NULL,
  email VARCHAR(60) DEFAULT '' NOT NULL,
  contacts VARCHAR(300) DEFAULT '' NOT NULL,
  role ENUM('ADMIN', 'DEVELOPER', 'INVESTOR' ) DEFAULT 'INVESTOR' NOT NULL,
  paidcost INT(11) DEFAULT '0' NOT NULL,
  locked TINYINT(1) DEFAULT '0' NOT NULL,
  image MEDIUMBLOB
);

CREATE TABLE startups
(
  id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) DEFAULT '' NOT NULL,
  description VARCHAR(1800) DEFAULT '' NOT NULL,
  cost INT(11) DEFAULT '0' NOT NULL,
  currentsum INT(11) DEFAULT '0' NOT NULL,
  image BLOB
);

CREATE TABLE users_startups
(
  user_id INT(10) unsigned NOT NULL,
  startup_id INT(10) unsigned NOT NULL,
  PRIMARY KEY (user_id, startup_id),
  KEY fk_user (user_id),
  KEY fk_startup (startup_id),
  CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_startup FOREIGN KEY (startup_id) REFERENCES startups (id)
);

