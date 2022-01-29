DROP DATABASE IF EXISTS bookmark;
CREATE DATABASE bookmark;
USE bookmark;
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
  id int PRIMARY KEY AUTO_INCREMENT,
  username varchar(255) UNIQUE KEY,
  password varchar(255) NOT NULL,
  role varchar(255) NOT NULL DEFAULT 'user'
)DEFAULT CHARACTER
  SET=utf8;

  INSERT INTO user
    (username, password)
  VALUES
    ("user", "$2a$10$4aY672Pznbg68T8tiP2SjODC0GbLJ2pYjgqmbkhs8mjj31TTk.tD2");
  -- demo1