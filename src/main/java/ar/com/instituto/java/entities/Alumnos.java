package ar.com.instituto.java.entities;

import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "alumnos")
public class Alumnos {
    
    @Id
    private int id;
    
    private String nombre;
    private String apellido;
    private String dni;
    private int idMaterias;

    public Alumnos() {
    }

    public Alumnos(int id, String nombre, String apellido, String dni, int idMaterias) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.idMaterias = idMaterias;
    }

    public Alumnos(String nombre, String apellido, String dni, int idMaterias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.idMaterias = idMaterias;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", idMaterias=" + idMaterias + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(int idMaterias) {
        this.idMaterias = idMaterias;
    }
    
    
    
}
