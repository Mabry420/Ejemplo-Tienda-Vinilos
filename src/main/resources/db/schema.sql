-- Script para crear la base de datos y la tabla de vinilos
-- Ejecutar en MySQL Workbench

CREATE DATABASE IF NOT EXISTS tienda_vinilos
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE tienda_vinilos;

CREATE TABLE IF NOT EXISTS vinilos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    artista VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    anio INT NOT NULL,
    genero VARCHAR(50),
    CONSTRAINT chk_precio CHECK (precio >= 0),
    CONSTRAINT chk_anio CHECK (anio BETWEEN 1900 AND YEAR(CURDATE()) + 1)
);

-- Datos de ejemplo para probar la aplicación
INSERT INTO vinilos (titulo, artista, precio, anio, genero) VALUES
    ('Dark Side of the Moon', 'Pink Floyd', 29.99, 1973, 'Rock'),
    ('Thriller', 'Michael Jackson', 24.99, 1982, 'Pop'),
    ('Abbey Road', 'The Beatles', 27.99, 1969, 'Rock'),
    ('Kind of Blue', 'Miles Davis', 32.99, 1959, 'Jazz'),
    ('Rumours', 'Fleetwood Mac', 25.99, 1977, 'Rock');
