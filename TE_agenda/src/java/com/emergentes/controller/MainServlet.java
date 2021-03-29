
package com.emergentes.controller;

import com.emergentes.modelo.nota;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("op");
        nota objper = new nota();
        int id, pos;
        HttpSession ses = request.getSession();
        List<nota> lista = (List<nota>) ses.getAttribute("listaper");
        
        switch (opcion){
            case "nuevo":
                //enviar objeto a editar
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                //obtener la posicion del elemento en la coleccion
                pos = buscarPorIndice(request, id);
                //obtener el objeto
                objper = lista.get(pos);
                //enviarlo para edicion
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                //obtener la posicion del elemento en la coleccion
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                if(pos >= 0){
                    lista.remove(pos);
                }
                //Actualizamos la lista debido a la eliminacion
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<nota> lista = (ArrayList<nota>) ses.getAttribute("listaper");
        nota objper = new nota ();
        objper.setId(id);
        objper.setHora(request.getParameter("hora"));
        objper.setActividad(request.getParameter("actividad"));
        objper.setCompletado(request.getParameter("completado"));
        System.out.println("El ID es" + id);
        if(id == 0){
            //colocar el ID
            int idNuevo = obtenerId(request);
            objper.setId(idNuevo);
            
            lista.add(objper);
            System.out.println(objper.toString());
        }else {
            //edicion
            int pos = buscarPorIndice(request, id);
            lista.set(pos, objper);
            System.out.println(objper.toString());
        }
        System.out.println("Enviando as index ");
        request.setAttribute("listaper", lista);
        response.sendRedirect("index.jsp");
    }

    // metodo buscar por indice
    public int buscarPorIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        List<nota> lista = (List<nota>) ses.getAttribute("listaper");
        
        int pos = -1;
        
        if(lista != null){
            for (nota ele : lista){
                ++pos;
                if(ele.getId() == id){
                    break;
                }
            }
        }
        return pos;
    }
    
    //metodo obtener id
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<nota> lista = (ArrayList<nota>) ses.getAttribute("listaper");
        //conteo del id desde 0
        int idn=0;
        for (nota ele : lista){
            idn = ele.getId();
        }
        return idn + 1;
    }
}

