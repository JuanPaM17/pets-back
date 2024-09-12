INSERT INTO rol (nombre) values ("ADMINISTRADOR");
INSERT INTO rol (nombre) values ("SECRETARIO");
INSERT INTO rol (nombre) values ("VETERINARIO");

INSERT INTO permiso (nombre) values ("READ_BUYER");
INSERT INTO permiso (nombre) values ("CREATE_BUYER");
INSERT INTO permiso (nombre) values ("UPDATE_BUYER");
INSERT INTO permiso (nombre) values ("DELETE_BUYER");
INSERT INTO permiso (nombre) values ("SEARCH_BUYER");
INSERT INTO permiso (nombre) values ("READ_PET");
INSERT INTO permiso (nombre)values ("CREATE_PET");
INSERT INTO permiso (nombre) values ("UPDATE_PET");
INSERT INTO permiso (nombre) values ("DELETE_PET");
INSERT INTO permiso (nombre) values ("READ_MEDICINE");
INSERT INTO permiso (nombre) values ("CREATE_MEDICINE");
INSERT INTO permiso (nombre) values ("UPDATE_MEDICINE");
INSERT INTO permiso (nombre) values ("DELETE_MEDICINE");
INSERT INTO permiso (nombre) values ("SEARCH_MEDICINE");
-- Auth
INSERT INTO permiso (nombre) values ("READ_USER");
INSERT INTO permiso (nombre) values ("CREATE_USER");
INSERT INTO permiso (nombre) values ("UPDATE_USER");
INSERT INTO permiso (nombre) values ("DELETE_USER");
INSERT INTO permiso (nombre) values ("READ_ROL");
INSERT INTO permiso (nombre) values ("CREATE_ROL");
INSERT INTO permiso (nombre) values ("UPDATE_ROL");
INSERT INTO permiso (nombre) values ("DELETE_ROL");
INSERT INTO permiso (nombre) values ("READ_PERMISSION");
INSERT INTO permiso (nombre) values ("CREATE_PERMISSION");
INSERT INTO permiso (nombre) values ("UPDATE_PERMISSION");
INSERT INTO permiso (nombre) values ("DELETE_PERMISSION");
INSERT INTO permiso (nombre) values ("READ_PERMISSIONXROL");
INSERT INTO permiso (nombre) values ("CREATE_PERMISSIONXROL");
INSERT INTO permiso (nombre) values ("UPDATE_PERMISSIONXROL");
INSERT INTO permiso (nombre) values ("DELETE_PERMISSIONXROL");

INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_BUYER"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_BUYER"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_BUYER"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_BUYER"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "SEARCH_BUYER"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_PET"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_PET"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_PET"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_PET"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_MEDICINE"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_MEDICINE"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_MEDICINE"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_MEDICINE"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "SEARCH_MEDICINE"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_USER"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_USER"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_USER"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_USER"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_ROL"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_ROL"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_ROL"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_ROL"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_PERMISSION"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_PERMISSION"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_PERMISSION"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_PERMISSION"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_PERMISSIONXROL"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_PERMISSIONXROL"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_PERMISSIONXROL"), (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_PERMISSIONXROL"), (select id from rol where nombre = "ADMINISTRADOR"));

INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_BUYER"), (select id from rol where nombre = "VETERINARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_PET"), (select id from rol where nombre = "VETERINARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_PET"), (select id from rol where nombre = "VETERINARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_PET"), (select id from rol where nombre = "VETERINARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_PET"), (select id from rol where nombre = "VETERINARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_MEDICINE"), (select id from rol where nombre = "VETERINARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_MEDICINE"), (select id from rol where nombre = "VETERINARIO"));

INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_BUYER"), (select id from rol where nombre = "SECRETARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_BUYER"), (select id from rol where nombre = "SECRETARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_BUYER"), (select id from rol where nombre = "SECRETARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_BUYER"), (select id from rol where nombre = "SECRETARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "SEARCH_BUYER"), (select id from rol where nombre = "SECRETARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_PET"), (select id from rol where nombre = "SECRETARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "CREATE_PET"), (select id from rol where nombre = "SECRETARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "UPDATE_PET"), (select id from rol where nombre = "SECRETARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "DELETE_PET"), (select id from rol where nombre = "SECRETARIO"));
INSERT INTO permiso_x_rol VALUES ((select id from permiso where nombre = "READ_MEDICINE"), (select id from rol where nombre = "SECRETARIO"));

INSERT INTO usuario (cedula, contrasena, nombre, username, rol_id) VALUES (1000000001, '$2a$10$xsmwUoWsSw80VS6Oik3FPeZ4w65W7gGukXD/uxQHFFbG3Yo1FN7Ru', 'Juan Pablo', 'admin', (select id from rol where nombre = "ADMINISTRADOR"));
INSERT INTO usuario (cedula, contrasena, nombre, username, rol_id) VALUES (1000000002, '$2a$10$U8VBwfOgX5HDLHqSQ6dIxeVQGYMARDqm3WynCwJRzUrRl7xH7uH.W', 'Santiago Gomez', 'secretario', (select id from rol where nombre = "SECRETARIO"));
INSERT INTO usuario (cedula, contrasena, nombre, username, rol_id) VALUES (1000000003, '$2a$10$y8fl/TBoVv02dNsOjDXTXu4ZGk5vUmIer76F2X8LX2b.3E.DWEoBe', 'Santiago Gomez', 'veterinario', (select id from rol where nombre = "VETERINARIO"));

INSERT INTO cliente (cedula, nombre, apellidos, direccion, telefono) VALUES 
(1023456789, 'Carlos', 'Ramírez', 'Calle 12 #34-56, Bogotá', 3001234567),
(1056789123, 'María', 'Fernández', 'Carrera 5 #45-12, Medellín', 3109876543),
(1012345678, 'Luis', 'Pérez', 'Avenida 68 #23-45, Cali', 3123456789),
(1098765432, 'Laura', 'González', 'Calle 8 #12-34, Barranquilla', 3187654321),
(1045678912, 'Jorge', 'Martínez', 'Carrera 3 #10-30, Cartagena', 3201234567);

INSERT INTO medicamento (nombre, descripcion, dosis) VALUES 
('Ivermectina', 'Antiparasitario de amplio espectro', 5),
('Amoxicilina', 'Antibiótico para infecciones bacterianas', 500),
('Metronidazol', 'Antibiótico y antiprotozoario', 250),
('Carprofeno', 'Antiinflamatorio no esteroideo', 50),
('Prednisona', 'Corticosteroide para inflamación y alergias', 20);

INSERT INTO mascota (identificacion, nombre, raza, edad, peso, medicamento_id, cliente_id) VALUES (1234567890, 'Rex', 'Pastor Alemán', '3 años', 35000, 1, 1);
INSERT INTO mascota (identificacion, nombre, raza, edad, peso, medicamento_id, cliente_id) VALUES (2345678901, 'Luna', 'Labrador Retriever', '2 años', 28000, 2, 2);
INSERT INTO mascota (identificacion, nombre, raza, edad, peso, medicamento_id, cliente_id) VALUES (3456789012, 'Max', 'Golden Retriever', '5 años', 30000, 3, 3);
INSERT INTO mascota (identificacion, nombre, raza, edad, peso, medicamento_id, cliente_id) VALUES (4567890123, 'Maya', 'Beagle', '4 años', 18000, 4, 4);
INSERT INTO mascota (identificacion, nombre, raza, edad, peso, medicamento_id, cliente_id) VALUES (5678901234, 'Simba', 'Bulldog Francés', '1 año', 25000, 5, 5);

SELECT * FROM usuario;
SELECT * FROM mascota;
SELECT * FROM medicamento;
