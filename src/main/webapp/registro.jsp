<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${requestScope.op == 'nuevo'}" var="res" scope="request">
                Registro de
            </c:if>
            <c:if test="${requestScope.op == 'modificar'}" var="res" scope="request">
                Modificar
            </c:if>
            Libro
        </h1>
        <jsp:useBean id="miLibro" scope="request" class="com.emergentes.modelo.libro" />
        <form action="MainController" method="POST">
            <label>Id</label>
            <input type="text" name="id" value="<jsp:getProperty name="miLibro" property="id" />"> <br>
            <label>Titulo</label>
            <input type="text" name="titulo" value="<jsp:getProperty name="miLibro" property="titulo" />"> <br>
            <label>Autor</label>
            <input type="text" name="autor" value="<jsp:getProperty name="miLibro" property="autor" />"> <br>
            <label>Disponible</label>
            <select name="disponible">
                <option value="Si" <c:if test="${miLibro.disponible == 'Si'}" var="res" scope="request">selected</c:if> >Si</option>
                <option value="No" <c:if test="${miLibro.disponible == 'No'}" var="res" scope="request">selected</c:if> >No</option>
            </select> <br>
            <label>Categoria</label>
            <select name="categoria">
                <c:forEach var="item" items="${sessionScope.listacate.getLista()}">
                    <option value="${item.categoria}">${item.categoria}</option>
                </c:forEach> 
            </select>
            <br>
            
            <input type="hidden" name="opg" value="${requestScope.op}">
            <input type="hidden" name="op" value="grabar">
            <input type="hidden" name="tipo" value="libros">
            
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
