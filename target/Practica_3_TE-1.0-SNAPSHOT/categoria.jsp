<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Categorias</h1>
        <a href="MainController?op=nuevo&tipo=categorias">Nuevo</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Catergoria</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${sessionScope.listacate.getLista()}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.categoria}</td>
                        <td><a href="MainController?tipo=categorias&op=modificar&id=${item.id}">Modificar</a></td>
                        <td><a href="MainController?tipo=categorias&op=eliminar&id=${item.id}">Eliminar</a></td>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>
        <a href="libro.jsp">Ir a libros</a>
    </body>
</html>
