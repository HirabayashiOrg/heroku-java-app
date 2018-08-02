CREATE TABLE tbl_github_push (
  id        int NOT NULL AUTO_INCREMENT,
  total     int NOT NULL,
  additions int NOT NULL,
  deletions int NOT NULL,
  pushed    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);