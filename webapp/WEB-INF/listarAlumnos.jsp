<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Listado de Alumnos</title>
    </head>
    <body>
        <div class="col-sm-8" >
            <h1>Listar Alumnos</h1>
            </br>
            <a href="${pageContext.request.contextPath}/ServletRedireccionar">Agregar</a>
            </br>
            <table class="table table-hover">

                <tr>
                    <th>Alumno Id</th>                
                    <th>Nombre</th>   
                    <th>Domicilio</th>
                    <th>Email</th>
                    <th>Telefono</th>
                </tr>
                <c:forEach var="alumno" items="${alumnos}">
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath}/ServletModificar?idAlumno=${alumno.idAlumno}">
                                ${alumno.idAlumno}
                            </a>    
                        </td>
                        <td>${alumno.nombre} ${alumno.apellido}</td>
                        <td>${alumno.domicilio.calle} ${alumno.domicilio.nroCalle} ${alumno.domicilio.pais}</td>
                        <td>${alumno.contacto.telefono}</td>
                        <td>${alumno.contacto.email}</td>
                    </tr>
                </c:forEach>
            </table>  
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
