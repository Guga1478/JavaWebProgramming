package ar.com.centroeducativo.modelo;

public class Alumno {
    private int id;
    private String nombres;
    private String dni;
    private int idMaterias;
    private String user;

    public Alumno() {
    }

    public Alumno(int id, String nombres, String dni, int idMaterias, String user) {
        this.id = id;
        this.nombres = nombres;
        this.dni = dni;
        this.idMaterias = idMaterias;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombres=" + nombres + ", dni=" + dni + ", idMaterias=" + idMaterias + ", user=" + user + '}';
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
    
}
