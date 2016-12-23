 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('supervisor','supervisor', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('user','user', TRUE);
 
INSERT INTO authority (username, authority, credentials_id) VALUES ('supervisor', 'ROLE_SUPERVISOR', 'supervisor');
INSERT INTO authority (username, authority, credentials_id) VALUES ('guest', 'ROLE_USER', 'guest');
INSERT INTO authority (username, authority, credentials_id) VALUES ('admin', 'ROLE_ADMIN', 'admin');
INSERT INTO authority (username, authority, credentials_id) VALUES ('user', 'ROLE_USER', 'user');

INSERT INTO  `users` (firstname, lastname,age,email,membernumber, member_id) VALUES ('Rabin','Pantha',26,'rbnpantha@gmail.com', 8754,'supervisor');
INSERT INTO `users` (firstname, lastname,age,email,membernumber,member_id) VALUES ('Nilam','Dahal',25,'nilamdahal@gmail.com', 8733,'admin');
INSERT INTO `users` (firstname, lastname,age,email,membernumber,member_id) VALUES ('Prajil','Shrestha',24,'prajilshrestha@gmail.com', 8753,'guest');
INSERT INTO `users` (firstname, lastname,age,email,membernumber,member_id) VALUES ('Bidur','Kunwar',27,'bidurkunwar@gmail.com', 8731,'guest');

					