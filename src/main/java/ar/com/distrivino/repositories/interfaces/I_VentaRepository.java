package ar.com.distrivino.repositories.interfaces;

import ar.com.distrivino.entities.Venta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_VentaRepository {
    void save(Venta venta);
    void remove(Venta venta);
    void update(Venta venta);
    List<Venta> getAll();
    default Venta getByFactura(int factura){
        return getAll().stream().filter(ve->ve.getFactura()==factura).findAny().orElse(new Venta());
    }
    
    default List<Venta> getLikeClienteId(int clienteId){
        return getAll().stream().filter(ve->ve.getClienteId()==clienteId)
                .collect(Collectors.toList());
    }
    
    default List<Venta> getLikeFecha(String fecha){
        if(fecha == null) return new ArrayList<Venta>();
        return getAll().stream().filter(ve->ve.getFecha().toLowerCase().contains(fecha.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    
}
