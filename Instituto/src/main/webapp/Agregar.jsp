<%-- 
    Document   : Agregar
    Created on : Apr 24, 2021, 8:37:41 AM
    Author     : GUSATAVO
--%>

<%@page import="ar.com.instituto.java.enums.Dia"%>
<%@page import="ar.com.instituto.java.enums.Turno"%>
<%@page import="ar.com.instituto.java.entities.Profesores"%>
<%@page import="ar.com.instituto.java.entities.Alumnos"%>
<%@page import="ar.com.instituto.java.entities.Materias"%>
<%@page import="ar.com.instituto.java.repositories.jdbc.MateriasRepository"%>
<%@page import="ar.com.instituto.java.repositories.jdbc.ProfesoresRepository"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_ProfesoresRepository"%>
<%@page import="ar.com.instituto.java.repositories.jdbc.AlumnosRepository"%>
<%@page import="ar.com.instituto.java.repositories.jdbc.AlumnosRepository"%>
<%@page import="ar.com.instituto.java.connectors.Connector"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_MateriasRepository"%>
<%@page import="ar.com.instituto.java.repositories.interfaces.I_AlumnosRepository"%>
<% I_AlumnosRepository ar = new AlumnosRepository(Connector.getConnection()); %>
<% I_ProfesoresRepository pr = new ProfesoresRepository(Connector.getConnection()); %>
<% I_MateriasRepository mr = new MateriasRepository(Connector.getConnection()); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <style>
        html{
            background-size: auto;
            min-height: 100%;
            background-color: #cccccc;
        }

        body{
            background-image: url("CSS/Imagenes/background.jpg");
            background-color: #007bff; 
        }

        #advanced-search-form{
            background-size: auto;
            background-color: lightcyan;
            max-width: 1200px;
            margin: auto auto auto;
            padding:auto;
            color: #858b8e;
            box-shadow: 40px 6px 40px rgba(0,0,0,0.2);
        }

        #advanced-search-form h2{
            padding-bottom: 20px;
            margin: 10px 10px;
            font-size: 24px;
        }

        #table{
            text-align: left;
            table-layout: fixed;
            width: 100px;
            border-color: #c82333;
        }

        #advanced-search-form hr{
            margin-top: 38px;
            margin-bottom: 54px;
            margin-left:3px;
            border: 1px solid #cccccc;

        }

        #advanced-search-form .form-group{
            margin-bottom: 20px;
            margin-left:5px;
            width: 30%;
            float:left;
            text-align: left;
        }

        #advanced-search-form .form-control{
            padding: 12px 20px;
            height: auto;
            border-radius: 2px;
        }

        #advanced-search-form .radio-inline{
            margin-left: 10px;
            margin-right: 10px;
        }

        #advanced-search-form .gender{
            width: 30%;
            margin-top: 30px;
            padding-left: 20px;
            padding-top: 10px;
            padding-bottom: 5px;
        }

        #advanced-search-form .btn{
            width: 46%;
            margin: 20px auto 0;
            display: block;
            outline: none;
        }

        @media screen and (max-width: 800px){
            #advanced-search-form .form-group{
                width: 55%;
            }

            #advanced-search-form{
                margin-top: 0;
            }
        }

        @media screen and (max-width: 560px){
            #advanced-search-form .form-group{
                width: 100%;
                margin-left: 0;
            }

            #advanced-search-form h2{
                text-align: center;
            }



        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>Agregar</title>
    </head>
    <body>
        <div class="container" id="advanced-search-form">
            <%
                HttpSession sesion = request.getSession();
                String usuario;
                String nivel;
                if (session.getAttribute("user") != null && session.getAttribute("nivel") != null) {
                    usuario = session.getAttribute("user").toString();
                    nivel = session.getAttribute("nivel").toString();
                    out.print("<a href='Login.jsp?cerrar=true'><h5>Cerrar Sesion " + usuario + "</h5></a>");
                } else {
                    out.print("<script>location.replace('Login.jsp');</script>");
                }

            %>
        <a href="Indice.jsp" sec="">Regresar</a>
        <h1>Agregar Informacion</h1>
        
        <h2>Control Alumnos</h2>
            
            <form>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" placeholder="Nombre" name="nombre" id="nombre">
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" class="form-control" placeholder="Apellido" name="apellido" id="apellido">
                </div>
                <div class="form-group">
                    <label for="dni">Dni:</label>
                    <input type="text" class="form-control" placeholder="Dni" name="dni" id="dni">
                </div>
                <div class="form-group">
                    <label for="materias">Materias</label>
                    <select class="form-control" name="idMaterias">
                        <%                             for (Materias m : mr.getAll())
                                out.println("<option value=" + m.getId() + ">"
                                        + m.getId() + ", " + m.getNombre() + ", " + m.getTurno() + ", " + m.getDia() + ", " + m.getProfesor()
                                        + "</option>");
                        %>  
                    </select>
                </div>
                <div class="clearfix"></div>
                <button type="submit" class="btn btn-info btn-lg btn-responsive" id="Guardar" value="Guardar"> <span class="glyphicon glyphicon-search"></span> Guardar</button> 
                
            </form>    
            <%
                try {
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String dni = request.getParameter("dni");
                    int idMaterias = Integer.parseInt(request.getParameter("idMaterias"));

                    if (nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty()
                            || dni == null || dni.isEmpty() || nombre.contains("<") || apellido.contains("<")
                            || dni.contains("<")) {
                        out.println("<h3>Falta ingresar datos</h3>");
                    } else {
                        Alumnos alumnos = new Alumnos(nombre, apellido, dni, idMaterias);
                        ar.save(alumnos);
                        if (alumnos.getId() != 0) {
                            out.println("<h3>Se guardo el alumno id: " + alumnos.getId() + "</h3>");
                        } else {
                            out.println("<h3>No se pudo guardar el alumno</h3>");
                        }
                    }
                } catch (NullPointerException | NumberFormatException e) {
                    out.println("<h3>Ingresar datos del nuevo alumno</h3>");
                } catch (Exception e) {
                    out.println("<h3>Ocurrio un error!!</h3>");
                    System.out.println("*****************************************");
                    System.out.println(e);
                    System.out.println("*****************************************");
                }
            %>                      
        
           

            
        </div>   
    </body>
</html>

