CREATE TABLE tbl_train_info_notification (
  line   varchar(50) NOT NULL,
  name   varchar(20) NOT NULL,
  status int NOT NULL,
  PRIMARY KEY (line, name)
);