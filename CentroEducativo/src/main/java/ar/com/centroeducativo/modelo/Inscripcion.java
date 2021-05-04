package ar.com.centroeducativo.modelo;

public class Inscripcion {
    private int idInscripcion;
    private int idAlumno;
    private int idMaterias;
    private String numeroSerie;
    private String descripcionMat;
    private String fecha;
    private String estado;
    private int cantidad;
    private int item;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, int idAlumno, int idMaterias, String numeroSerie, String descripcionMat, String fecha, String estado, int cantidad, int item) {
        this.idInscripcion = idInscripcion;
        this.idAlumno = idAlumno;
        this.idMaterias = idMaterias;
        this.numeroSerie = numeroSerie;
        this.descripcionMat = descripcionMat;
        this.fecha = fecha;
        this.estado = estado;
        this.cantidad = cantidad;
        this.item = item;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(int idMaterias) {
        this.idMaterias = idMaterias;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getDescripcionMat() {
        return descripcionMat;
    }

    public void setDescripcionMat(String descripcionMat) {
        this.descripcionMat = descripcionMat;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", idAlumno=" + idAlumno + ", idMaterias=" + idMaterias + ", numeroSerie=" + numeroSerie + ", descripcionMat=" + descripcionMat + ", fecha=" + fecha + ", estado=" + estado + ", cantidad=" + cantidad + ", item=" + item + '}';
    }
    
    

    
    
    
    
    
    
}
