INSERT INTO USUARIO_ENTITY(name, email, password) VALUES('Teste', 'teste_estudos@email.com', '987654321');
INSERT INTO USUARIO_ENTITY(name, email, password) VALUES('Teste2', 'teste_estudos.2@email.com', '123123123');

INSERT INTO CURSO_ENTITY(name, category) VALUES('Spring Boot', 'Back-end');
INSERT INTO CURSO_ENTITY(name, category) VALUES('Angular 13', 'Front-end');

INSERT INTO TOPICO_ENTITY(title, message, creation_date, status_topico, usuario_entity_id, curso_entity_id) VALUES ('Estudos', 'spring-boot', '2022-04-10 09:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO_ENTITY(title, message, creation_date, status_topico, usuario_entity_id, curso_entity_id) VALUES ('Praticas', 'java 8', '2019-08-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO_ENTITY(title, message, creation_date, status_topico, usuario_entity_id, curso_entity_id) VALUES ('Aprendizado', 'back end', '2021-07-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);