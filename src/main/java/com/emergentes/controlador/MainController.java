
package com.emergentes.controlador;

import com.emergentes.modelo.GestorCategoria;
import com.emergentes.modelo.GestorLibros;
import com.emergentes.modelo.categoria;
import com.emergentes.modelo.libro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Boris Leonel
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        libro objLibro = new libro();
        categoria objCate = new categoria();
        int id;
        int pos;
        String opcion = request.getParameter("op");
        String opcion2 = request.getParameter("tipo");
        String op = (opcion != null) ? request.getParameter("op") : "view";
        String tipo = (opcion2 != null) ? request.getParameter("tipo") : "view";
        if (tipo.equals("libros")) {
            if (op.equals("nuevo")) {
                HttpSession ses = request.getSession();
                GestorLibros agenda = (GestorLibros) ses.getAttribute("listalibro");
                objLibro.setId(agenda.obtieneId());
                request.setAttribute("op", op);
                request.setAttribute("miLibro", objLibro);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }

            if (op.equals("modificar")) {
                id = Integer.parseInt(request.getParameter("id"));
                HttpSession ses = request.getSession();
                GestorLibros agenda = (GestorLibros) ses.getAttribute("listalibro");
                pos = agenda.ubicarTarea(id);
                objLibro = agenda.getLista().get(pos);

                request.setAttribute("op", op);
                request.setAttribute("miLibro", objLibro);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }

            if (op.equals("eliminar")) {
                id = Integer.parseInt(request.getParameter("id"));
                HttpSession ses = request.getSession();
                GestorLibros agenda = (GestorLibros) ses.getAttribute("listalibro");
                pos = agenda.ubicarTarea(id);

                agenda.eliminarTarea(pos);
                ses.setAttribute("listalibro", agenda);
                response.sendRedirect("libro.jsp");
            }
        }
        if (tipo.equals("categorias")) {
            if (op.equals("nuevo")) {
                HttpSession ses = request.getSession();
                GestorCategoria agenda = (GestorCategoria) ses.getAttribute("listacate");
                objCate.setId(agenda.obtieneId());
                request.setAttribute("op", op);
                request.setAttribute("miCate", objCate);
                request.getRequestDispatcher("editaCate.jsp").forward(request, response);
            }

            if (op.equals("modificar")) {
                id = Integer.parseInt(request.getParameter("id"));
                HttpSession ses = request.getSession();
                GestorCategoria agenda = (GestorCategoria) ses.getAttribute("listacate");
                pos = agenda.ubicarTarea(id);
                objCate = agenda.getLista().get(pos);

                request.setAttribute("op", op);
                request.setAttribute("miCate", objCate);
                request.getRequestDispatcher("editaCate.jsp").forward(request, response);
            }

            if (op.equals("eliminar")) {
                id = Integer.parseInt(request.getParameter("id"));
                HttpSession ses = request.getSession();
                GestorCategoria agenda = (GestorCategoria) ses.getAttribute("listacate");
                pos = agenda.ubicarTarea(id);

                agenda.eliminarTarea(pos);
                ses.setAttribute("listacate", agenda);
                response.sendRedirect("categoria.jsp");
            }
        }

        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        libro objTarea = new libro();
        categoria objCate = new categoria();
        int pos;
        String op = request.getParameter("op");
        String tipo = request.getParameter("tipo");
        if (tipo.equals("libros")) {
            if (op.equals("grabar")) {
                objTarea.setId(Integer.parseInt(request.getParameter("id")));
                objTarea.setTitulo(request.getParameter("titulo"));
                objTarea.setAutor(request.getParameter("autor"));
                objTarea.setDisponible(request.getParameter("disponible"));
                objTarea.setCategoria(request.getParameter("categoria"));

                HttpSession ses = request.getSession();
                GestorLibros agenda = (GestorLibros) ses.getAttribute("listalibro");

                String opg = request.getParameter("opg");
                if (opg.equals("nuevo")) {
                    agenda.insertarTarea(objTarea);
                } else {
                    pos = agenda.ubicarTarea(objTarea.getId());
                    agenda.modificarTarea(pos, objTarea);
                }
                ses.setAttribute("listalibro", agenda);
                response.sendRedirect("libro.jsp");
            }
        }
        if (tipo.equals("categorias")) {
            if (op.equals("grabar")) {
                objCate.setId(Integer.parseInt(request.getParameter("id")));
                objCate.setCategoria(request.getParameter("categoria"));


                HttpSession ses = request.getSession();
                GestorCategoria agenda = (GestorCategoria) ses.getAttribute("listacate");

                String opg = request.getParameter("opg");
                if (opg.equals("nuevo")) {
                    agenda.insertarTarea(objCate);
                } else {
                    pos = agenda.ubicarTarea(objCate.getId());
                    agenda.modificarTarea(pos, objCate);
                }
                ses.setAttribute("listacate", agenda);
                response.sendRedirect("categoria.jsp");
            }
        }
    }
}
