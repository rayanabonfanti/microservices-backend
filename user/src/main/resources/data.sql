INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$12$/8yL2uSAw/67UQCYXPqIgO2FGbzxbtl4gi5R4cOoV8UP1A7esmrNG');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$12$/8yL2uSAw/67UQCYXPqIgO2FGbzxbtl4gi5R4cOoV8UP1A7esmrNG');
INSERT INTO tb_user (name, email, password) VALUES ('Rayana', 'rayana@gmail.com', '$2a$12$/8yL2uSAw/67UQCYXPqIgO2FGbzxbtl4gi5R4cOoV8UP1A7esmrNG');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
