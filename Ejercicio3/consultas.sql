--2)
SELECT p.Nombre, COUNT(v.Producto) AS Numero_de_ventas
FROM Productos p, Venta v
WHERE v.Producto = p.Producto
GROUP BY p.Nombre,
ORDER BY COUNT(v.Producto) DESC

--3)
SELECT Cajeros.NomApels, Productos.Nombre, Productos.Precio, Maquinas_Registradoras.Piso
FROM Venta, Cajeros, Productos, Maquinas_Registradoras
WHERE Venta.Cajero = Cajeros.Cajero AND Venta.Producto = Productos.Producto AND Venta.Maquina = Maquinas_Registradoras.Maquina

--4)
SELECT m.Piso, COUNT(v.Maquina) AS Ventas_totales
FROM Maquinas_Registradoras m, Venta v
WHERE m.Maquina = v.Maquina
ORDER BY m.Piso DESC

--5)
SELECT c.Cajero, c.NomApels, SUM(p.Precio) AS Total_ventas
FROM Cajeros c, Venta v, Productos p
WHERE c.Cajero = v.Cajero AND v.Producto = p.Producto
GROUP BY c.Cajero

--6)
SELECT c.Cajero, c.NomApels FROM Cajero c, Venta v 
WHERE c.Cajero = v.Cajero AND v.Maquina IN
(SELECT Maquina FROM Maquinas_Registradoras WHERE Piso IN
(SELECT m.Piso
FROM Productos p, Venta v, Maquinas_Registradoras m
WHERE p.Producto = v.Producto AND m.Maquina = v.Maquina
GRUOP BY m.Piso HAVING SUM(p.Precio) < 5000))
