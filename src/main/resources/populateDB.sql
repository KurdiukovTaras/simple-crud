INSERT INTO client (name,descripment,phonenumber) VALUES
  ('Max','Good client','+380502501782'),
  ('Igor','Very good','+380502501783'),
  ('Methew','So so','+380502501784'),
  ('Fine','Bad client','+380502501785'),
  ('Ivi','he offen late','+380502501786');
INSERT INTO sms (message,readed,in_out,date_time,port,client_id) VALUES
  ('Hellow from Max',TRUE,TRUE,'2015-05-30 10:00:00','1.1',1),
  ('Hellow from Igor',TRUE,TRUE,'2015-05-30 20:00:00' ,'1.2',2),
  ('Hellow from Methew',TRUE,TRUE,'2015-05-31 10:00:00' ,'1.3',3),
  ('Hellow from Fine',TRUE,TRUE,'2015-05-31 13:00:00','1.4',4),
  ('Hellow from Ivi',TRUE,TRUE,'2015-06-01 21:00:00' ,'1.5',5);