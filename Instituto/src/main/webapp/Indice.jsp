<%-- 
    Document   : Indice
    Created on : Mar 27, 2021, 11:46:20 PM
    Author     : GUSATAVO
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
<% I_AlumnosRepository ar = new AlumnosRepository(Connector.getConnection()); %>
<% I_ProfesoresRepository pr = new ProfesoresRepository(Connector.getConnection()); %>
<% I_MateriasRepository mr = new MateriasRepository(Connector.getConnection()); %>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Instituto</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
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
            <h1>Alumnos List Control</h1>  
            
            <a href="Agregar.jsp" class="btn btn-success btn-md">Nuevo Registro</a>
            <br>

            <%
                Connection conn;
                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/instituto";
                String user = "root";
                String pass = "Amelia2015";
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps;
                ResultSet rs;
                ps = conn.prepareStatement("select * from alumnos");
                rs = ps.executeQuery();
            %>

            <div class="table-responsive">
                
                <table class="table table-bordered">
                    <tr>
                        <th class="danger text-center" text="id" name="id">Id</th>
                        <th class="danger text-center" text="Nombre" name="nombre">Name</th>
                        <th class="danger text-center" text="Apellido" name="apellido">Apellido</th>
                        <th class="danger text-center" text="dni" name="dni">Dni</th>
                        <th class="danger text-center" text="idMaterias" name="idMaterias">Id Materia</th>
                        <th class="danger text-center" text="acciones" name="acciones">Acciones</th>
                    </tr>
                    <%
                        while (rs.next()) {
                    %>
                    <tr>
                        <td class="active "><%= rs.getInt("id")%></td>
                        <td class="success"><%= rs.getString("nombre")%></td>
                        <td class="success"><%= rs.getString("apellido")%></td>
                        <td class="warning"><%= rs.getString("dni")%></td>
                        <td class="active"><%= rs.getInt("idMaterias")%></td>
                        <td class="text-center">
                        <a class="btn btn-warning btn-xs" href="EditarAlumno.jsp?id=<%= rs.getInt("id")%>">Editar</a> 
                        <a class="btn btn-danger btn-xs" href="Eliminar.jsp?id=<%= rs.getInt("id")%>">Eliminar</a>``
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>                 
            <form>
                Buscar Alumno:<input type="text" name="buscarApellido" />
            </form>
            <%
                String buscarApellido = request.getParameter("buscarApellido");
                out.println(new HtmlTable().getTable(ar.getLikeApellido(buscarApellido)));
            %>

            
            <%
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pass);
                ps = conn.prepareStatement("select * from profesores");
                rs = ps.executeQuery();
            %>

            <div class="table-responsive">
                <h1>Profesores List Control</h1>
                <a href="AgregarProfesor.jsp" class="btn btn-success btn-md">Nuevo Registro</a>
            <br>
                <table class="table table-bordered">
                    <tr>
                        <th class="danger" text="id" name="id">Id</th>
                        <th class="danger" text="Nombre" name="nombre">Name</th>
                        <th class="danger" text="Apellido" name="apellido">Apellido</th>
                        <th class="danger" text="Dni" name="dni">Dni</th>
                        <th class="danger" text="Estado" name="estado">Estado</th>
                        <th class="danger text-center" text="acciones" name="acciones">Acciones</th>
                    </tr>
                    <%
                        while (rs.next()) {
                    %>
                    <tr>
                        <td class="active"><%= rs.getInt("id")%></td>
                        <td class="active"><%= rs.getString("nombre")%></td>
                        <td class="success"><%= rs.getString("apellido")%></td>
                        <td class="active"><%= rs.getString("dni")%></td>
                        <td class="active"><%= rs.getString("estado")%></td>
                        <td class="text-center">
                        <a class="btn btn-warning btn-xs" href="EditarProfesor.jsp?id=<%= rs.getInt("id")%>">Editar</a> 
                        <a class="btn btn-danger btn-xs" href="EliminarProfesor.jsp?id=<%= rs.getInt("id")%>">Eliminar</a>`
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>              

            <form>
                Buscar Profesor:<input type="text" name="buscarProfesor" />
            </form>
            <%
                String buscarProfesor = request.getParameter("buscarProfesor");
                out.println(new HtmlTable().getTable(pr.getByApellido(buscarProfesor)));
            %>     
            
            <%
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pass);
                ps = conn.prepareStatement("select * from materias");
                rs = ps.executeQuery();
            %>

            <div class="table-responsive">
                <h1>Materias List Control</h1>
                <a href="AgregarMaterias.jsp" class="btn btn-success btn-md">Nuevo Registro</a>
            <br>
                <table class="table table-bordered">
                    <tr>
                        <th class="danger" text="id" name="id">Id</th>
                        <th class="danger" text="Nombre" name="nombre">Nombre</th>
                        <th class="danger" text="Turno" name="turno">Turno</th>
                        <th class="danger" text="Dni" name="dia">Dia</th>
                        <th class="danger" text="profesor" name="profesor">Profesor</th>
                        <th class="danger" text="cupoMaxAlumnos" name="cupoMaxAlumnos">Cupo Maximo</th>
                        <th class="danger text-center" text="acciones" name="acciones">Acciones</th>
                    </tr>
                    <%
                        while (rs.next()) {
                    %>
                    <tr>
                        <td class="active"><%= rs.getInt("id")%></td>
                        <td class="active"><%= rs.getString("nombre")%></td>
                        <td class="success"><%= rs.getString("turno")%></td>
                        <td class="success"><%= rs.getString("dia")%></td>
                        <td class="active"><%= rs.getString("profesor")%></td>
                        <td class="active"><%= rs.getInt("cupo_max_alumnos")%></td>
                        <td class="text-center">
                        <a class="btn btn-warning btn-xs" href="EditarMaterias.jsp?id=<%= rs.getInt("id")%>">Editar</a> 
                        <a class="btn btn-danger btn-xs" href="EliminarMaterias.jsp?id=<%= rs.getInt("id")%>">Eliminar</a>`
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>              

            
            <form>
                Buscar Materias:<input type="text" name="buscarMaterias" />
            </form>
            <%
                String buscarMaterias = request.getParameter("buscarMaterias");
                    out.println(new HtmlTable().getTable(mr.getByNombre(buscarMaterias)));
            %>     
        </div> 
    </body>
</html>
