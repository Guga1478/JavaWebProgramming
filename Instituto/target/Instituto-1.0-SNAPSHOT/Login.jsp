<%-- 
    Document   : Login
    Created on : Mar 28, 2021, 6:59:41 PM
    Author     : GUSATAVO
--%>

<%@page import="ar.com.instituto.java.model.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body style="background-color: lightskyblue">
        <h1>Login</h1>
        <p><strong>Ingresar los datos para acceder al sistema de gestion</strong></p>
        <form action="Login.jsp" METHOD="POST">
            User:<input type="text" name="usuario" placeholder="ingrese su nombre de usuario"><br/>
            Password:<input type="password" name="contra" placeholder="ingrese su password"><br/>
    
            <input type="submit" name="btnIngresar" value="Enviar">
    </form>
        <%
          Operaciones op = new Operaciones();
          if(request.getParameter("btnIngresar")!=null){
              String usuario=request.getParameter("usuario");
              String contra=request.getParameter("contra");
              HttpSession sesion = request.getSession();
              switch(op.loguear(usuario, contra)){
                case 1:
                    sesion.setAttribute("user", usuario);
                    sesion.setAttribute("nivel","1");
                    response.sendRedirect("Indice.jsp");
                break;
                case 2:
                    sesion.setAttribute("user", usuario);
                    sesion.setAttribute("nivel","2");
                    response.sendRedirect("Profesor.jsp");
                break;
                case 3:
                    sesion.setAttribute("user", usuario);
                    sesion.setAttribute("nivel","3");
                    response.sendRedirect("Alumno.jsp");
                break;
                default:
                     out.write("usuario no existe, o password incorrecto");
                break;
            }
           }
           if(request.getParameter("cerrar")!=null){
               session.invalidate();    
            }
        %>
</body>
</html>
    
