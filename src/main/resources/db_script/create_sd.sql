

CREATE TABLE address (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  postalcode VARCHAR(255),
  country    VARCHAR(255),
  city       VARCHAR(255),
  street     VARCHAR(255),
  house      VARCHAR(255),
  flat       VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE user (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name  VARCHAR(20)           DEFAULT NULL,
  second_name VARCHAR(30)           DEFAULT NULL,
  email       VARCHAR(40)           DEFAULT NULL,
  phone       VARCHAR(13)           DEFAULT NULL,
  address_id  INT UNSIGNED,
  login       VARCHAR(15)  NOT NULL,
  is_deleted  BOOLEAN               DEFAULT FALSE,
  pass        VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (address_id) REFERENCES address (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE

)

  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;