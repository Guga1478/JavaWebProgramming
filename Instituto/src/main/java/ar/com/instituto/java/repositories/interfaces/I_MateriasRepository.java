package ar.com.instituto.java.repositories.interfaces;

import ar.com.instituto.java.entities.Materias;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_MateriasRepository {
    void save(Materias materias);
    void remove(Materias materias);
    void update(Materias materias);
    List<Materias>getAll();
    default Materias getById(int id){
        return getAll().stream()
                       .filter(m->m.getId()==id).findAny().orElse(new Materias());                
    }
    default List<Materias> getByNombre(String nombre){
        if(nombre == null)return new ArrayList<Materias>();
        return getAll().stream().filter(m->m.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }
    
}
