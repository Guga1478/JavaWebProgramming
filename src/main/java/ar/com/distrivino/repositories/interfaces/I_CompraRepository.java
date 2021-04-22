package ar.com.distrivino.repositories.interfaces;

import ar.com.distrivino.entities.Compra;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_CompraRepository {
    void save(Compra compra);
    void remove (Compra compra);
    void update(Compra compra);
//    void sum(Compra compra);
    List<Compra> getAll();
    default Compra getByFactura(int factura){
        return getAll().stream().filter(c->c.getFactura()==factura).findAny().orElse(new Compra());
    }
    
    default List<Compra> getByProveedorId(int proveedorId){
        return getAll().stream().filter(c->c.getProveedorId()==proveedorId)
                .collect(Collectors.toList());
    }
    
    default List<Compra> getLikeFecha(String fecha){
        if(fecha == null) return new ArrayList<Compra>();
        return getAll().stream().filter(c->c.getFecha().toLowerCase().contains(fecha.toLowerCase()))
                .collect(Collectors.toList());
    }
    
}
