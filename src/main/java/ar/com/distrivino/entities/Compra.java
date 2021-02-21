package ar.com.distrivino.entities;

public class Compra {
    private int proveedorId;
    private int vinoCodigo;
    private int cantidad;
    private double precioUnit;
    private int factura;
    private String fecha;
    private double total;
    
    public Compra(){
        
    }

    public Compra(int proveedorId, int vinoCodigo, int cantidad, double precioUnit, String fecha, double total) {
        this.proveedorId = proveedorId;
        this.vinoCodigo = vinoCodigo;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
        this.fecha = fecha;
        this.total = (cantidad * precioUnit);
        
    }
    

    public Compra(int proveedorId, int vinoCodigo, int cantidad, double precioUnit, int factura, String fecha, double total) {
        this.proveedorId = proveedorId;
        this.vinoCodigo = vinoCodigo;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
        this.factura = factura;
        this.fecha = fecha;
        this.total = (cantidad * precioUnit);
    }

    @Override
    public String toString() {
        return "Compra{" + "proveedorId=" + proveedorId + ", vinoCodigo=" + vinoCodigo + ", cantidad=" + cantidad + ", precioUnit=" + precioUnit + ", factura=" + factura + ", fecha=" + fecha + ", total=" + total + '}';
    }


    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public int getVinoCodigo() {
        return vinoCodigo;
    }

    public void setVinoCodigo(int vinoCodigo) {
        this.vinoCodigo = vinoCodigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
   
    
}
