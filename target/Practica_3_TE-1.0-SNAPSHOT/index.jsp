
<%@page import="com.emergentes.modelo.GestorCategoria"%>
<%@page import="com.emergentes.modelo.categoria"%>
<%@page import="com.emergentes.modelo.GestorLibros"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.libro"%>
<%
    if (session.getAttribute("agenda") == null) {
            GestorLibros objeto1 = new GestorLibros();
            objeto1.insertarTarea(new libro(1,"los deshabitados","Alex Fernandez","No","Científico"));
            objeto1.insertarTarea(new libro(2,"El otro gallo","Jorge Gonzales","Si", "Literatura"));
            objeto1.insertarTarea(new libro(3,"Jonás y la ballena rosada","Roberto Bolaños","No", "Novela"));
            objeto1.insertarTarea(new libro(4,"Aluvión de fuego","Iver Quispe","Si", "Matematicas"));
            
            GestorCategoria objeto2 = new GestorCategoria();
            objeto2.insertarTarea(new categoria(1,"Cuento"));
            objeto2.insertarTarea(new categoria(2,"Historia"));
            objeto2.insertarTarea(new categoria(3,"Novela"));
            objeto2.insertarTarea(new categoria(4,"Poéticos"));
            objeto2.insertarTarea(new categoria(5,"Ficción"));
            objeto2.insertarTarea(new categoria(6,"Juveniles"));

            session.setAttribute("listalibro", objeto1);
            session.setAttribute("listacate", objeto2);
    }


    

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca</title>
    </head>
    <body>
        <h1>Practica Nro.3</h1>
        <h1>Biblioteca</h1>
        <ul>
            <li><a href="categoria.jsp">Categorias</a></li>
            <li><a href="libro.jsp">Libros</a></li>
        </ul>

        
    </body>
</html>
