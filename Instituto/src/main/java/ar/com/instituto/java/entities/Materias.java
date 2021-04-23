package ar.com.instituto.java.entities;

import ar.com.instituto.java.enums.Dia;
import ar.com.instituto.java.enums.Turno;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "materias")
public class Materias {
    
    @Id
    private int id;
    
    private String nombre;
    private Turno turno;
    private Dia dia;
    private String profesor;
    private int cupoMaxAlumnos;

    public Materias() {
    }

    public Materias(int id, String nombre, Turno turno, Dia dia, String profesor, int cupoMaxAlumnos) {
        this.id = id;
        this.nombre = nombre;
        this.turno = turno;
        this.dia = dia;
        this.profesor = profesor;
        this.cupoMaxAlumnos = cupoMaxAlumnos;
    }

    public Materias(String nombre, Turno turno, Dia dia, String profesor, int cupoMaxAlumnos) {
        this.nombre = nombre;
        this.turno = turno;
        this.dia = dia;
        this.profesor = profesor;
        this.cupoMaxAlumnos = cupoMaxAlumnos;
    }

    @Override
    public String toString() {
        return "Materias{" + "id=" + id + ", nombre=" + nombre + ", turno=" + turno + ", dia=" + dia + ", profesor=" + profesor + ", cupoMaxAlumnos=" + cupoMaxAlumnos + '}';
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

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getCupoMaxAlumnos() {
        return cupoMaxAlumnos;
    }

    public void setCupoMaxAlumnos(int cupoMaxAlumnos) {
        this.cupoMaxAlumnos = cupoMaxAlumnos;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }
    
    
            
    
}
