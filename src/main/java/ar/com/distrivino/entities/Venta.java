package ar.com.distrivino.entities;

public class Venta {
    private int clienteId;
    private int vinoCodigo;
    protected int cantidad;
    protected double precioUnit;
    private int factura;
    private String fecha;
    private double total;

    public Venta() {
    }

    public Venta(int clienteId, int vinoCodigo, int cantidad, double precioUnit, String fecha, double total) {
        this.clienteId = clienteId;
        this.vinoCodigo = vinoCodigo;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
        this.fecha = fecha;
        this.total = (cantidad * precioUnit);
    }

    public Venta(int clienteId, int vinoCodigo, int cantidad, double precioUnit, int factura, String fecha, double total) {
        this.clienteId = clienteId;
        this.vinoCodigo = vinoCodigo;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
        this.factura = factura;
        this.fecha = fecha;
        this.total = (cantidad * precioUnit);
    }

    @Override
    public String toString() {
        return "Venta{" + "clienteId=" + clienteId + ", vinoCodigo=" + vinoCodigo + ", cantidad=" + cantidad + ", precioUnit=" + precioUnit + ", factura=" + factura + ", fecha=" + fecha + ", total=" + total + '}';
    }

    public int getClienteId(){
        return clienteId;
    }
    
    public void setClienteId(int clienteId){
        this.clienteId = clienteId;
    }
    
    public int getVinoCodigo(){
        return vinoCodigo;
    }
    
    public void setVinoCodigo(int vinoCodigo){
            this.vinoCodigo = vinoCodigo;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public double getPrecioUnit(){
        return precioUnit;
    }
    
    public void setPrecioUnit(double precioUnit){
        this.precioUnit = precioUnit;
    }
    
    public int getFactura(){
        return factura;
    }
    
    public void setFactura(int factura){
        this.factura = factura;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
            
    
}
