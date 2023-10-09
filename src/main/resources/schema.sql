CREATE TABLE user (
      id int NOT NULL AUTO_INCREMENT,
      email varchar(255) DEFAULT NULL,
      name varchar(255) DEFAULT NULL,
      rog_date datetime DEFAULT NULL,
      mod_date datetime DEFAULT NULL,
      PRIMARY KEY (id)
);


CREATE TABLE BOARD(
    board_id int NOT NULL AUTO_INCREMENT,
    usrId int NOT NULL
    board_title varchar(255) DEFAULT NULL,
    board_content varchar(255) DEFAULT NULL,
    rog_date datetime DEFAULT NULL,
    mod_date datetime DEFAULT NULL,
    PRIMARY KEY (board_id)
)