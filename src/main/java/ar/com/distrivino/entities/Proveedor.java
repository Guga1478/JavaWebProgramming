package ar.com.distrivino.entities;

public class Proveedor {
    private int id;
    private String razonSocial;
    private String email;

    public Proveedor() {
    }

    public Proveedor(String razonSocial, String email) {
        this.razonSocial = razonSocial;
        this.email = email;
    }

    public Proveedor(int id, String razonSocial, String email) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", razonSocial=" + razonSocial + ", email=" + email + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
