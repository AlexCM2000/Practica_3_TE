<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.libro"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Libros</h1>
        <a href="MainController?tipo=libros&op=nuevo">Nuevo</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Autor</th>
                    <th>Disponible</th>
                    <th>Catergoria</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${sessionScope.listalibro.getLista()}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.titulo}</td>
                        <td>${item.autor}</td>
                        <td>${item.disponible}</td>
                        <td>${item.categoria}</td>
                        <td><a href="MainController?tipo=libros&op=modificar&id=${item.id}">Modificar</a></td>
                        <td><a href="MainController?tipo=libros&op=eliminar&id=${item.id}">Eliminar</a></td>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>
        <a href="index.jsp">Volver</a>

    </body>
</html>
