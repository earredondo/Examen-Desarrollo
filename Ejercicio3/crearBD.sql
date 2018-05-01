CREATE DATABASE Tienda
USE Tienda

CREATE TABLE Productos(
Producto INT ,
Nombre NVARCHAR(100),
Precio Money(15,2),
PRIMARY KEY(Producto)
)

CREATE TABLE Cajeros(
Cajero INT,
NomApels VARCHAR(255),
PRIMARY KEY(Cajero)
)

CREATE TABLE Maquinas_Registradoras(
Maquina INT,
Piso INT,
PRIMARY KEY(Maquina)
)

CREATE TABLE Venta(
Cajero INT REFERENCES Cajeros(Cajero),
Maquina INT REFERENCES Maquinas_Registradoras(Maquina),
Producto INT REFERENCES Productos(Producto)
)


