package ar.com.centroeducativo.modelo;

public class Profesor {
    private int id;
    private String nombres;
    private String dni;
    private String estado;
    private String user;

    public Profesor() {
    }

    public Profesor(int id, String nombres, String dni, String estado, String user) {
        this.id = id;
        this.nombres = nombres;
        this.dni = dni;
        this.estado = estado;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id=" + id + ", nombres=" + nombres + ", dni=" + dni + ", estado=" + estado + ", user=" + user + '}';
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
}
