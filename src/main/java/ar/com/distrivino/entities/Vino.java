package ar.com.distrivino.entities;

public class Vino {
    private int codigo;
    private String bodega;
    private String nombre;
    private String descripcion;
    private int anoElab;
    private int stock;

    public Vino() {
    }

    public Vino(String bodega, String nombre, String descripcion, int anoElab, int stock) {
        this.bodega = bodega;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anoElab = anoElab;
        this.stock = stock;
    }

    public Vino(int codigo, String bodega, String nombre, String descripcion, int anoElab, int stock) {
        this.codigo = codigo;
        this.bodega = bodega;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anoElab = anoElab;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Vino{" + "codigo=" + codigo + ", bodega=" + bodega + ", nombre=" + nombre + ", descripcion=" + descripcion + ", anoElab=" + anoElab + ", stock=" + stock + '}';
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAnoElab() {
        return anoElab;
    }

    public void setAnoElab(int anoElab) {
        this.anoElab = anoElab;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
