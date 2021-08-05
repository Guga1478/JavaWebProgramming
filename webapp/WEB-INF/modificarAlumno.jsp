<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Modificar Alumno</title>
    </head>
    <body>
        <div class="col-sm-8" >
            <h1>Modificar Alumno</h1>
            <form name="form1" action="${pageContext.request.contextPath}/ServletModificar"  method="post">
                <input type="hidden" name="idAlumno" value="${alumno.idAlumno}"/>                

                Nombre: <input type="text" name="nombre" value="${alumno.nombre}"/>
                </br>
                Apellido: <input type="text" name="apellido" value="${alumno.apellido}"/>
                <br/> 
                <br/>
                Datos Domicilio: 
                <br/>
                Calle: <input type="text" name="calle" value="${alumno.domicilio.calle}"/>
                <br>
                Nro Calle: <input type="text" name="nroCalle" value="${alumno.domicilio.nroCalle}"/>
                <br/>
                Pais: <input type="text" name="pais" value="${alumno.domicilio.pais}"/>
                <br/>
                <br/>
                Datos de Contacto:
                <br/>
                Email: <input type="email" name="email" value="${alumno.contacto.email}"/>
                <br/>   
                Telefono: <input type="tel" name="telefono" value="${alumno.contacto.telefono}"/>
                <br/>                        
                <br/>
                <input type="submit" name="Modificar" value="Modificar">
                <input type="submit" name="Eliminar" value="Eliminar">
            </form>
        </div>   
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>    
</html>
