package mx.com.gm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;
import mx.com.gm.servicio.ServicioAlumno;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        String nroCalle = request.getParameter("nroCalle");
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNroCalle(nroCalle);
        domicilio.setPais(pais);
        
        Contacto contacto = new Contacto();
        contacto.setTelefono(telefono);
        contacto.setEmail(email);
        
        
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        servicioAlumno.guardarAlumno(alumno);
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
    } 
    
}
