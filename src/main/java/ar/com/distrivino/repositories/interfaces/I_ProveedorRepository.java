package ar.com.distrivino.repositories.interfaces;

import ar.com.distrivino.entities.Proveedor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ProveedorRepository {
    void save(Proveedor proveedor);
    void remove(Proveedor proveedor);
    void update(Proveedor proveedor);
    List<Proveedor> getAll();
    default Proveedor getById(int id){
        return getAll().stream().filter(p->p.getId()==id).findAny().orElse(new Proveedor());
    }
    default List<Proveedor> getLikeRazonSocial(String razonSocial){
        if(razonSocial==null) return new ArrayList<Proveedor>();
        return getAll().stream().filter(p->p.getRazonSocial().toLowerCase().contains(razonSocial.toLowerCase()))
            .collect(Collectors.toList());
    }
    
}
