<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="ar.com.centroeducativo.config.Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.centroeducativo.modelo.MateriasDAO"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.centroeducativo.modelo.Materias"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Alumno</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Alumno" method="POST">
                        <div class="form-group">
                            <div class="form-group">
                            <label>Id Materias</label>
                            <input type="text" name="codigomateria" value="${materias.getId()}" class="form-control" placeholder="Codigo Materia"> 
                            <button type="submit" name="accion" value="BuscarMateria" class="btn btn-outline-info">Buscar</button>
                        </div>
                            <label>Nombre Materia</label>    
                        <div class="form-group">
                            <input type="text" name="nommateria" value="${materias.getNombre()}" class="form-control" >   
                        </div>                            
                            <label>Nombres</label>
                            <input type="text" value="${alumno.getNombres()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${alumno.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${alumno.getUser()}" name="txtUser" class="form-control">                            
                        </div>
                        
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>            
            </div>  
            <div class="col-sm-8" >
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRES</th>
                            <th>DNI</th>
                            <th>IDMATERIAS</th>
                            <th>USUARIO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="al" items="${alumnos}">
                            <tr>
                                <td>${al.getId()}</td>
                                <td>${al.getNombres()}</td>
                                <td>${al.getDni()}</td>
                                <td>${al.getIdMaterias()}</td>
                                <td>${al.getUser()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Alumno&accion=Editar&id=${al.getId()}">Editar</a>
                                    <a class="btn btn-info" href="Controlador?menu=Inscripcion&accion=default&id=${al.getId()}">Alta</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Alumno&accion=Delete&id=${al.getId()}">Delete</a>
                                    
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>  
            </div>
        </div           
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
