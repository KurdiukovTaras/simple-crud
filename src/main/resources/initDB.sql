DROP TABLE IF EXISTS sms;
DROP TABLE IF EXISTS client;
CREATE TABLE client
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20),
  descripment TEXT,
  phonenumber TEXT
);
CREATE UNIQUE INDEX client_unique_id ON client (id);
CREATE TABLE sms
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  message TEXT,
  readed BOOL DEFAULT TRUE,
  in_out BOOL,
  date_time TIMESTAMP,
  port VARCHAR(20),
  client_id INTEGER,
  FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX sms_unique_client_datetime_idx ON sms(client_id, date_time)
