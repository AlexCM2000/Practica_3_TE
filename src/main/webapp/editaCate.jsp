<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="miCate" scope="request" class="com.emergentes.modelo.categoria" />
    <body>
        <h1>
            <c:if test="${requestScope.op == 'nuevo'}" var="res" scope="request">
                Registro de
            </c:if>
            <c:if test="${requestScope.op == 'modificar'}" var="res" scope="request">
                Modificar
            </c:if>
            Categoria
        </h1>
                <form action="MainController" method="POST">
            <label>Id</label>
            <input type="text" name="id" value="<jsp:getProperty name="miCate" property="id" />"> <br>
            <label>Categoria</label>
            <input type="text" name="categoria" value="<jsp:getProperty name="miCate" property="categoria" />"> <br>
           
            <input type="hidden" name="opg" value="${requestScope.op}">
            <input type="hidden" name="op" value="grabar">
            <input type="hidden" name="tipo" value="categorias"><br>
            <input type="submit" value="Enviar">
            
        </form>
    </body>
</html>
