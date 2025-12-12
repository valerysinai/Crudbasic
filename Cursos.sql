--DML

CREATE DATABASE CursosOnlineDB;
GO
USE CursosOnlineDB;
GO


CREATE TABLE Usuarios(
    IdUsuario INT IDENTITY PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Email VARCHAR(120) UNIQUE NOT NULL,
    PasswordHash VARCHAR(200) NOT NULL,
    FechaRegistro DATETIME DEFAULT GETDATE()
);

CREATE TABLE Roles(
    IdRol INT IDENTITY PRIMARY KEY,
    NombreRol VARCHAR(50) NOT NULL
);

CREATE TABLE Categorias(
    IdCategoria INT IDENTITY PRIMARY KEY,
    NombreCategoria VARCHAR(80) NOT NULL
);

CREATE TABLE Instructores(
    IdInstructor INT IDENTITY PRIMARY KEY,
    IdUsuario INT NOT NULL,
    Biografia VARCHAR(500),
    FOREIGN KEY(IdUsuario) REFERENCES Usuarios(IdUsuario)
);

CREATE TABLE Estudiantes(
    IdEstudiante INT IDENTITY PRIMARY KEY,
    IdUsuario INT NOT NULL,
    Nivel VARCHAR(20),
    FOREIGN KEY(IdUsuario) REFERENCES Usuarios(IdUsuario)
);

CREATE TABLE Cursos(
    IdCurso INT IDENTITY PRIMARY KEY,
    IdInstructor INT NOT NULL,
    Titulo VARCHAR(150) NOT NULL,
    Descripcion VARCHAR(500),
    Precio DECIMAL(10,2),
    FechaCreacion DATETIME DEFAULT GETDATE(),
    FOREIGN KEY(IdInstructor) REFERENCES Instructores(IdInstructor)
);

CREATE TABLE Lecciones(
    IdLeccion INT IDENTITY PRIMARY KEY,
    IdCurso INT NOT NULL,
    Titulo VARCHAR(150),
    Contenido TEXT,
    DuracionMin INT,
    FOREIGN KEY(IdCurso) REFERENCES Cursos(IdCurso)
);

CREATE TABLE Inscripciones(
    IdInscripcion INT IDENTITY PRIMARY KEY,
    IdEstudiante INT NOT NULL,
    IdCurso INT NOT NULL,
    FechaInscripcion DATETIME DEFAULT GETDATE(),
    FOREIGN KEY(IdEstudiante) REFERENCES Estudiantes(IdEstudiante),
    FOREIGN KEY(IdCurso) REFERENCES Cursos(IdCurso)
);

CREATE TABLE Pagos(
    IdPago INT IDENTITY PRIMARY KEY,
    IdInscripcion INT NOT NULL,
    Monto DECIMAL(10,2),
    MetodoPago VARCHAR(50),
    FechaPago DATETIME DEFAULT GETDATE(),
    FOREIGN KEY(IdInscripcion) REFERENCES Inscripciones(IdInscripcion)
);

CREATE TABLE Certificados(
    IdCertificado INT IDENTITY PRIMARY KEY,
    IdInscripcion INT NOT NULL,
    FechaEmision DATETIME DEFAULT GETDATE(),
    CodigoCertificado VARCHAR(100),
    FOREIGN KEY(IdInscripcion) REFERENCES Inscripciones(IdInscripcion)
);

-- ===========================================
-- TABLAS PIVOTE (MANY TO MANY)
-- ===========================================

CREATE TABLE Usuario_Rol(
    IdUsuario INT NOT NULL,
    IdRol INT NOT NULL,
    PRIMARY KEY (IdUsuario, IdRol),
    FOREIGN KEY (IdUsuario) REFERENCES Usuarios(IdUsuario),
    FOREIGN KEY (IdRol) REFERENCES Roles(IdRol)
);

CREATE TABLE Curso_Categoria(
    IdCurso INT NOT NULL,
    IdCategoria INT NOT NULL,
    PRIMARY KEY (IdCurso, IdCategoria),
    FOREIGN KEY(IdCurso) REFERENCES Cursos(IdCurso),
    FOREIGN KEY(IdCategoria) REFERENCES Categorias(IdCategoria)
);


-- ROLES
INSERT INTO Roles (NombreRol) VALUES ('Admin'), ('Instructor'), ('Estudiante');

-- USUARIOS
INSERT INTO Usuarios (Nombre, Email, PasswordHash)
VALUES 
('Carlos Ruiz', 'carlos@mail.com', 'abc123'),
('Ana Torres', 'ana@mail.com', 'xyz123'),
('Luis Gomez', 'luis@mail.com', 'pass123');

-- ASIGNAR ROLES
INSERT INTO Usuario_Rol VALUES (1, 1);  -- Carlos -> Admin
INSERT INTO Usuario_Rol VALUES (2, 2);  -- Ana -> Instructor
INSERT INTO Usuario_Rol VALUES (3, 3);  -- Luis -> Estudiante

-- CATEGORÍAS
INSERT INTO Categorias (NombreCategoria)
VALUES ('Programación'), ('Diseño'), ('Marketing');

-- INSTRUCTOR
INSERT INTO Instructores (IdUsuario, Biografia)
VALUES (2, 'Experta en desarrollo web');

-- ESTUDIANTE
INSERT INTO Estudiantes (IdUsuario, Nivel)
VALUES (3, 'Básico');

-- CURSOS
INSERT INTO Cursos (IdInstructor, Titulo, Descripcion, Precio)
VALUES (1, 'Curso de HTML', 'Aprende HTML desde cero', 49.99),
       (1, 'Curso de CSS', 'Maqueta con CSS moderno', 59.99);

-- RELACIÓN CURSO - CATEGORÍA
INSERT INTO Curso_Categoria VALUES (1, 1);  
INSERT INTO Curso_Categoria VALUES (2, 1);  
INSERT INTO Curso_Categoria VALUES (2, 2);  

-- LECCIONES
INSERT INTO Lecciones (IdCurso, Titulo, Contenido, DuracionMin)
VALUES 
(1, 'Introducción a HTML', 'Contenido de introducción', 15),
(1, 'Etiquetas Básicas', 'Contenido de etiquetas', 20);

-- INSCRIPCIÓN
INSERT INTO Inscripciones (IdEstudiante, IdCurso)
VALUES (1, 1);  -- Luis se inscribe a HTML

-- PAGO
INSERT INTO Pagos (IdInscripcion, Monto, MetodoPago)
VALUES (1, 49.99, 'Tarjeta de Crédito');

-- CERTIFICADO
INSERT INTO Certificados (IdInscripcion, CodigoCertificado)
VALUES (1, 'CERT-HTML-001');
