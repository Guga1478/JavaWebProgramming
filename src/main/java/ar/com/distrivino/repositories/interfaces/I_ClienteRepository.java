package ar.com.distrivino.repositories.interfaces;

import ar.com.distrivino.entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ClienteRepository {
    void save(Cliente cliente);
    void remove(Cliente cliente);
    void update(Cliente cliente);
    List<Cliente> getAll();
    default Cliente getById(int id){
        return getAll().stream().filter(cl->cl.getId()==id).findAny().orElse(new Cliente());
    }
    
    default List<Cliente> getLikeNombre(String nombre){
        if(nombre == null)return new ArrayList<Cliente>();
        return getAll().stream().filter(cl->cl.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
}
