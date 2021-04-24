package ar.com.instituto.java.entities;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "profesores")
public class Profesores {
    @Id    
    private int id;
    
    private String nombre;
    private String apellido;
    private String dni;
    private String estado;

    public Profesores() {
    }

    public Profesores(int id, String nombre, String apellido, String dni, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estado = estado;
    }

    public Profesores(String nombre, String apellido, String dni, String estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Profesores{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", estado=" + estado + '}';
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
