<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Inscripcion</title>
    </head>
    <body>
        <div class="d-flex">            
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=Inscripcion" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Alumno</label>
                            </div>     
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoalumno" value="${alu.getDni()}" class="form-control" placeholder="Codigo"> 
                                    <input type="submit" name="accion" value="BuscarAlumno" class="btn btn-outline-info"> 
                                </div>                            
                                <div class="col-sm-6">
                                    <input type="text" name="nombresalumno" value="${alu.getNombres()}" class="form-control" placeholder="Datos Alumno" >   
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Materias</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigomateria" value="${materias.getId()}" class="form-control" placeholder="Codigo"> 
                                    <button type="submit" name="accion" value="BuscarMateria" class="btn btn-outline-info">Buscar</button>
                                </div>                            
                                <div class="col-sm-6">
                                    <input type="text" name="nommateria" value="${materias.getNombre()}" class="form-control" placeholder="Datos Materia" >   
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-3">
                                    <input type="number" name="cant" class="form-control" placeholder="" >   
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="cup" value="${materias.getCupoMaxAlumnos()}" class="form-control" placeholder="Cupo" >   
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Materia</button>
                            </div>
                        </div>
                    </form>
                </div>                
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>NumeroSerie</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">  
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Cantidad</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}" >
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdMaterias()}</td>
                                    <td>${list.getDescripcionMat()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td class="d-flex">
                                        <a href="#" class="btn btn-warning" >Editar</a>
                                        <a href="#" class="btn btn-danger" style="margin-left: 10px">Delete</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>       
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=Inscripcion&accion=GenerarInscripcion" class="btn btn-warning" >Generar Inscripcion</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
