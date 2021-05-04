package ar.com.centroeducativo.modelo;

public class Materias {
    private int id;
    private String nombre;
    private String turno;
    private String dia;
    private int cupoMaxAlumnos;

    public Materias() {
    }

    public Materias(int id, String nombre, String turno, String dia, int cupoMaxAlumnos) {
        this.id = id;
        this.nombre = nombre;
        this.turno = turno;
        this.dia = dia;
        this.cupoMaxAlumnos = cupoMaxAlumnos;
    }

    @Override
    public String toString() {
        return "Materias{" + "id=" + id + ", nombre=" + nombre + ", turno=" + turno + ", dia=" + dia + ", cupoMaxAlumnos=" + cupoMaxAlumnos + '}';
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getCupoMaxAlumnos() {
        return cupoMaxAlumnos;
    }

    public void setCupoMaxAlumnos(int cupoMaxAlumnos) {
        this.cupoMaxAlumnos = cupoMaxAlumnos;
    }
    
    
    
}
