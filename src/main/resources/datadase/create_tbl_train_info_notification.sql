DROP TABLE tbl_train_info_notification;

CREATE TABLE tbl_train_info_notification (
  line   varchar(50) NOT NULL,
  name   varchar(20) NOT NULL,
  url    text,
  info   varchar(20),
  detail varchar(20),
  PRIMARY KEY (line, name)
);