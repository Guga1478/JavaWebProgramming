package ar.com.distrivino.entities;

public class Cliente {
    private int id;
    private String nombre;
    private String telefono;
    private String email;
    private String formaPago;

    public Cliente() {
    }

    public Cliente(String nombre, String telefono, String email, String formaPago) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.formaPago = formaPago;
    }

    public Cliente(int id, String nombre, String telefono, String email, String formaPago) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.formaPago = formaPago;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", formaPago=" + formaPago + '}';
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    
    
    
}
