-- Table: users
CREATE TABLE users (
  id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  email    VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL ,
  role_id INT NOT NULL ,

  FOREIGN KEY (user_id) REFERENCES users (id) ,
  FOREIGN KEY (role_id) REFERENCES roles (id) ,

  UNIQUE (user_id, role_id)

)
  ENGINE = InnoDB;

-- Table: documents
CREATE TABLE documents (
  id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name        VARCHAR(255) NOT NULL ,
  created     VARCHAR(255) NOT NULL ,
  author      VARCHAR(255) NOT NULL ,
  description VARCHAR(255) NOT NULL ,
  file        BLOB NOT NULL
)
  ENGINE = InnoDB;
