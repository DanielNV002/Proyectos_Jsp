DROP DATABASE IF EXISTS JspWeb;
CREATE DATABASE JspWeb;
USE JspWeb;

CREATE TABLE proyectos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_proyecto VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_inicio DATE,
    fecha_fin DATE,
    estado ENUM('EN_CURSO', 'COMPLETADO') NOT NULL
);

CREATE TABLE tareas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_proyecto INT,
    descripcion_tarea TEXT,
    responsable VARCHAR(255),
    fecha_inicio DATE,
    fecha_fin DATE,
    estado ENUM('PENDIENTE', 'EN_PROGRESO', 'COMPLETADA') NOT NULL,
    FOREIGN KEY (id_proyecto) REFERENCES proyectos(id)
);

INSERT INTO proyectos (nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado) 
VALUES
('Proyecto A', 'Descripción del Proyecto A', '2025-01-01', '2025-06-30', 'EN_CURSO'),
('Proyecto B', 'Descripción del Proyecto B', '2025-02-01', '2025-12-01', 'EN_CURSO'),
('Proyecto C', 'Descripción del Proyecto C', '2025-03-01', '2025-09-30', 'COMPLETADO'),
('Proyecto D', 'Descripción del Proyecto D', '2025-04-01', '2025-08-15', 'EN_CURSO'),
('Proyecto E', 'Descripción del Proyecto E', '2025-05-01', '2025-11-01', 'COMPLETADO'),
('Proyecto F', 'Descripción del Proyecto F', '2025-06-01', '2025-12-15', 'EN_CURSO'),
('Proyecto G', 'Descripción del Proyecto G', '2025-07-01', '2025-10-31', 'COMPLETADO'),
('Proyecto H', 'Descripción del Proyecto H', '2025-08-01', '2025-09-30', 'EN_CURSO'),
('Proyecto I', 'Descripción del Proyecto I', '2025-09-01', '2025-12-01', 'COMPLETADO'),
('Proyecto J', 'Descripción del Proyecto J', '2025-10-01', '2026-01-01', 'EN_CURSO');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(1, 'Tarea 1 del Proyecto A', 'Juan Pérez', '2025-01-01', '2025-01-15', 'PENDIENTE'),
(1, 'Tarea 2 del Proyecto A', 'Ana Gómez', '2025-01-10', '2025-02-01', 'EN_PROGRESO'),
(1, 'Tarea 3 del Proyecto A', 'Carlos López', '2025-01-20', '2025-02-15', 'COMPLETADA');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(2, 'Tarea 1 del Proyecto B', 'María Fernández', '2025-02-01', '2025-03-01', 'PENDIENTE'),
(2, 'Tarea 2 del Proyecto B', 'Luis Martínez', '2025-02-15', '2025-04-01', 'EN_PROGRESO'),
(2, 'Tarea 3 del Proyecto B', 'Roberto Sánchez', '2025-02-20', '2025-03-25', 'PENDIENTE');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(3, 'Tarea 1 del Proyecto C', 'Laura García', '2025-03-01', '2025-03-15', 'COMPLETADA'),
(3, 'Tarea 2 del Proyecto C', 'Pedro Díaz', '2025-03-10', '2025-04-01', 'COMPLETADA');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(4, 'Tarea 1 del Proyecto D', 'Marta Ruiz', '2025-04-01', '2025-04-20', 'PENDIENTE'),
(4, 'Tarea 2 del Proyecto D', 'José Martínez', '2025-04-10', '2025-05-05', 'EN_PROGRESO'),
(4, 'Tarea 3 del Proyecto D', 'Luis Pérez', '2025-04-15', '2025-05-01', 'PENDIENTE');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(5, 'Tarea 1 del Proyecto E', 'Sofía García', '2025-05-01', '2025-05-10', 'COMPLETADA'),
(5, 'Tarea 2 del Proyecto E', 'Carlos Martínez', '2025-05-05', '2025-06-01', 'COMPLETADA');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(6, 'Tarea 1 del Proyecto F', 'Ana López', '2025-06-01', '2025-06-20', 'PENDIENTE'),
(6, 'Tarea 2 del Proyecto F', 'Felipe Torres', '2025-06-10', '2025-07-01', 'PENDIENTE'),
(6, 'Tarea 3 del Proyecto F', 'Marcos Rodríguez', '2025-06-15', '2025-07-05', 'EN_PROGRESO');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(7, 'Tarea 1 del Proyecto G', 'Cristina Pérez', '2025-07-01', '2025-07-15', 'COMPLETADA'),
(7, 'Tarea 2 del Proyecto G', 'Raúl Gómez', '2025-07-05', '2025-07-20', 'COMPLETADA');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(8, 'Tarea 1 del Proyecto H', 'Esteban Martín', '2025-08-01', '2025-08-10', 'PENDIENTE'),
(8, 'Tarea 2 del Proyecto H', 'Nina Gómez', '2025-08-05', '2025-08-20', 'PENDIENTE'),
(8, 'Tarea 3 del Proyecto H', 'Sergio Martínez', '2025-08-10', '2025-08-25', 'PENDIENTE');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(9, 'Tarea 1 del Proyecto I', 'Ricardo Fernández', '2025-09-01', '2025-09-10', 'COMPLETADA'),
(9, 'Tarea 2 del Proyecto I', 'Teresa López', '2025-09-05', '2025-09-20', 'COMPLETADA');
INSERT INTO tareas (id_proyecto, descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado) 
VALUES
(10, 'Tarea 1 del Proyecto J', 'Elena Sánchez', '2025-10-01', '2025-10-15', 'EN_PROGRESO'),
(10, 'Tarea 2 del Proyecto J', 'Fernando Pérez', '2025-10-05', '2025-10-20', 'PENDIENTE'),
(10, 'Tarea 3 del Proyecto J', 'José González', '2025-10-10', '2025-10-25', 'EN_PROGRESO');


SELECT * FROM proyectos;
SELECT * FROM tareas;