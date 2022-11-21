/* Populate tabla clientes */



INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha) VALUES(1, 'Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(2, 'Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(4, 'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(4, 'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(4, 'Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(3, 'Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(3, 'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(3, 'John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(3, 'Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(5, 'Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha) VALUES(6, 'Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO cliente (id_region, nombre, apellido, aemail, fecha)  VALUES(7, 'Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');

/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuario` (username, password, enabled) VALUES ('andres','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1);
INSERT INTO `usuario` (username, password, enabled) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1);

INSERT INTO `role` (nombre) VALUES ('ROLE_USER');
INSERT INTO `role` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuario_role` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuario_role` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuario_role` (usuario_id, role_id) VALUES (2, 1);

SELECT * FROM usuario;