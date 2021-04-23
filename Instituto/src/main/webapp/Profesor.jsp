<%-- 
    Document   : Profesor
    Created on : Mar 28, 2021, 1:16:16 AM
    Author     : GUSATAVO
--%>

<%@page import="ar.com.instituto.java.repositories.jdbc.ProfesoresRepository"%>
<%@page import="ar.com.instituto.java.connectors.Connector"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_ProfesoresRepository"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_ProfesoresRepository"%>
<%@page import="ar.com.instituto.java.entities.Profesores"%>
<%@page import="ar.com.instituto.java.utils.html.HtmlTable"%>
<% I_ProfesoresRepository pr=new ProfesoresRepository(Connector.getConnection()); %>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instituto</title>
    </head>
    <body style="background-color: lightgreen">
         <%
          HttpSession sesion = request.getSession();
          String usuario;
          String nivel;
          if(session.getAttribute("user")!=null && session.getAttribute("nivel")!=null){
              usuario=session.getAttribute("user").toString();
              nivel=session.getAttribute("nivel").toString();
              out.print("<a href='Login.jsp?cerrar=true'><h5>Cerrar Sesion " + usuario + "</h5></a>");
            }else{
               out.print("<script>location.replace('Login.jsp');</script>");
            }
          
        %>
        <h1>Control Profesores</h1>        
        <p><strong>Favor ingresar los datos para acceder al sistema de gestion.</strong></p>
        <form>
            <table>
                <tr><td>Nombre:   </td><td><input type="text"   name="Nombre"    /></td></tr>
                <tr><td>Apellido: </td><td><input type="text"   name="Apellido"  /></td></tr>
                <tr><td>Dni:      </td><td><input type="text"    name="dni"      /></td></tr>
                <tr><td>Estado:      </td><td><input type="text"    name="estado"      /></td></tr>
                <tr>
                     <td><input type="submit" value="Guardar"/></td>
                     <td><input type="reset" value="Borrar"/></td>
                </tr> 
            </table>
        </form> 
  <%
          try {
               String nombre=request.getParameter("nombre");
               String apellido=request.getParameter("apellido");
               String dni= request.getParameter("dni");
               String estado= request.getParameter("estado");
               
               if(nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty() ||
                  dni == null|| dni.isEmpty()|| nombre.contains("<") || apellido.contains("<") ||
                  dni.contains("<") ||estado == null || estado.isEmpty() ||estado.contains("<")
               ){
                  out.println("<h3>Falta ingresar datos</h3>");
               }else{
                    Profesores profesores = new Profesores(nombre, apellido, dni, estado);
                    pr.save(profesores);
                    if(profesores.getId()!=0){
                         out.println("<h3>Se guardo el profesor id: "+profesores.getId()+"</h3>");
                       }else{
                             out.println("<h3>No se pudo guardar los datos del Profesor</h3>");
                        }
               }
              } catch (NullPointerException | NumberFormatException e) { out.println("<h3>Ingresar datos del nuevo Profesor</h3>");
            } catch (Exception e) {
                out.println("<h3>Ocurrio un error!!</h3>");
                System.out.println("*****************************************");
                System.out.println(e);
                System.out.println("*****************************************");
            }               
       %>                      
       <form>
           Buscar Profesor:<input type="text" name="buscarProfesor" />
       </form>
       <%
         String buscarProfesor = request.getParameter("buscarProfesor");
         if(buscarProfesor == null || buscarProfesor.isEmpty())  
         out.println(new HtmlTable().getTable(pr.getAll()));
         else
             out.println(new HtmlTable().getTable(pr.getByApellido(buscarProfesor)));
         
       %>  
    
    </body>
</html>
