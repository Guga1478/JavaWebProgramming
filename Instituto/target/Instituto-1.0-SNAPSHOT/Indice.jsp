<%-- 
    Document   : Indice
    Created on : Mar 27, 2021, 11:46:20 PM
    Author     : GUSATAVO
--%>
<%@page import="ar.com.instituto.java.enums.Dia"%>
<%@page import="ar.com.instituto.java.enums.Turno"%>
<%@page import="ar.com.instituto.java.entities.Profesores"%>
<%@page import="ar.com.instituto.java.utils.html.HtmlTable"%>
<%@page import="ar.com.instituto.java.entities.Alumnos"%>
<%@page import="ar.com.instituto.java.entities.Materias"%>
<%@page import="ar.com.instituto.java.repositories.jdbc.MateriasRepository"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_MateriasRepository"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_MateriasRepository"%>
<%@page import="ar.com.instituto.java.repositories.jdbc.ProfesoresRepository"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_ProfesoresRepository"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_ProfesoresRepository"%>
<%@page import="ar.com.instituto.java.connectors.Connector"%>
<%@page import="ar.com.instituto.java.repositories.jdbc.AlumnosRepository"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_AlumnosRepository"%>
<% I_AlumnosRepository ar=new AlumnosRepository(Connector.getConnection()); %>
<% I_ProfesoresRepository pr=new ProfesoresRepository(Connector.getConnection()); %>
<% I_MateriasRepository mr=new MateriasRepository(Connector.getConnection()); %>
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
        <h1>Control Alumnos</h1>
        <form>
            <table>
                <tr><td>Nombre:   </td><td><input type="text"   name="nombre"    /></td></tr>
                <tr><td>Apellido: </td><td><input type="text"   name="apellido"  /></td></tr>
                <tr><td>Dni:      </td><td><input type="text"    name="dni"      /></td></tr>
                <tr><td>Materias:    </td>
                    <td>
                        <select name="idMaterias">
                         <%
                           for(Materias m: mr.getAll())
                           out.println("<option value="+m.getId()+">"+
                           m.getId()+", "+m.getNombre()+", "+m.getTurno()+", "+m.getDia()+", "+m.getProfesor()
                            +"</option>");
                         %>  
                        </select>
                    </td>
                </tr>
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
               int idMaterias=Integer.parseInt(request.getParameter("idMaterias"));
               
               if(nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty() ||
                  dni == null|| dni.isEmpty()|| nombre.contains("<") || apellido.contains("<") ||
                  dni.contains("<")
               ){
                  out.println("<h3>Falta ingresar datos</h3>");
               }else{
                    Alumnos alumnos = new Alumnos(nombre, apellido, dni, idMaterias);
                    ar.save(alumnos);
                    if(alumnos.getId()!=0){
                         out.println("<h3>Se guardo el alumno id: "+alumnos.getId()+"</h3>");
                       }else{
                             out.println("<h3>No se pudo guardar el alumno</h3>");
                        }
               }
              } catch (NullPointerException | NumberFormatException e) { out.println("<h3>Ingresar datos del nuevo alumno</h3>");
            } catch (Exception e) {
                out.println("<h3>Ocurrio un error!!</h3>");
                System.out.println("*****************************************");
                System.out.println(e);
                System.out.println("*****************************************");
            }               
       %>                      
       <form>
           Buscar Alumno:<input type="text" name="buscarApellido" />
       </form>
       <%
         String buscarApellido = request.getParameter("buscarApellido");
         if(buscarApellido == null || buscarApellido.isEmpty())  
         out.println(new HtmlTable().getTable(ar.getAll()));
         else
             out.println(new HtmlTable().getTable(ar.getLikeApellido(buscarApellido)));
         
       %>
                    
       <h1 sec:authorize="hasNivel('1,3')">Control Profesores</h1>        
        <form>
            <table>
                <tr><td>Nombre:   </td><td><input type="text"   name="nombre"    /></td></tr>
                <tr><td>Apellido: </td><td><input type="text"   name="apellido"  /></td></tr>
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
    <h1 sec:authorize="hasNivel('nivel_1')">Control Materias</h1>        
        <form>
            <table>
                <tr><td>Nombre:   </td><td><input type="text"   name="nombre"    /></td></tr>
                <tr><td>Truno:    </td>
                    <td>
                        <select name="turno">
                            <%
                            for(Turno t:Turno.values())
                            out.println("<option value="+t+">"+t.toString().toLowerCase()+"</option>");
                        %>    
                        </select>
                    </td>
                </tr>
                <tr><td>Dia:      </td>
                    <td>
                        <select name="dia">
                            <%
                                for(Dia d:Dia.values())
                                  out.println("<option value="+d+">"+d.toString().toLowerCase()+"</option>");
                                
                                
                            %>    
                         </select>
                    </td>
                </tr>
                <tr><td>Profesor:      </td>
                    <td>
                        <select name="profesor">
                            <%
                           for(Profesores p: pr.getAll())
                           out.println("<option value="+p.getApellido()+">"+
                           p.getId()+", "+p.getNombre()+", "+p.getApellido()+", "+p.getEstado()
                            +"</option>");
                         %>  
                        </select>
                    </td>
                </tr>
                <tr><td>Cupo Maximo:   </td><td><input type="number"   name="cupoMaxAlumnos"/></td></tr>
                <tr>
                     <td><input type="submit" value="Guardar"/></td>
                     <td><input type="reset" value="Borrar"/></td>
                </tr> 
            </table>
        </form> 
  <%
          try {
               String nombre=request.getParameter("nombre");
               Turno turno=Turno.valueOf(request.getParameter("turno"));
               Dia dia=Dia.valueOf(request.getParameter("dia"));
               String profesor=request.getParameter("profesor");
               int cupoMaxAlumnos = Integer.parseInt(request.getParameter("cupoMaxAlumnos"));
               
               if(nombre == null || nombre.isEmpty() ||  nombre.contains("<")
                  || profesor == null|| profesor.isEmpty()|| profesor.contains("<")                  
               ){
                  out.println("<h3>Falta ingresar datos</h3>");
               }else{
                    Materias materias = new Materias(nombre, turno, dia, profesor, cupoMaxAlumnos);
                    mr.save(materias);
                    if(materias.getId()!=0){
                         out.println("<h3>Se guardo la materia id: "+materias.getId()+"</h3>");
                       }else{
                             out.println("<h3>No se pudo guardar los datos de la Materia</h3>");
                        }
               }
              } catch (NullPointerException | NumberFormatException e) { out.println("<h3>Ingresar datos de la Materia</h3>");
            } catch (Exception e) {
                out.println("<h3>Ocurrio un error!!</h3>");
                System.out.println("*****************************************");
                System.out.println(e);
                System.out.println("*****************************************");
            }               
       %>                      
       <form>
           Buscar Materias:<input type="text" name="buscarMaterias" />
       </form>
       <%
         String buscarMaterias = request.getParameter("buscarMaterias");
         if(buscarMaterias == null || buscarMaterias.isEmpty())  
         out.println(new HtmlTable().getTable(mr.getAll()));
         else
             out.println(new HtmlTable().getTable(mr.getByNombre(buscarMaterias)));
         
       %>     
   
    </body>
</html>
