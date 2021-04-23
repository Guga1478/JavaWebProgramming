package ar.com.instituto.java.repositories.interfaces;

import ar.com.instituto.java.entities.Materias;
import ar.com.instituto.java.entities.Profesores;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ProfesoresRepository {
    void save(Profesores profesores);
    void remove(Profesores profesores);
    void update(Profesores profesores);
    List<Profesores>getAll();
    default Profesores getById(int id){
        return getAll().stream()
                       .filter(p->p.getId()==id).findAny().orElse(new Profesores());                
    }
    default List<Profesores> getByNombre(String nombre){
        if(nombre == null)return new ArrayList<Profesores>();
        return getAll().stream().filter(p->p.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }
    default List<Profesores>getLikeApellidoNombre(String apellido, String nombre){
        if(apellido==null || nombre==null)return new ArrayList<Profesores>();
        return getAll().stream()
                       .filter(p->p.getApellido().toLowerCase().contains(apellido.toLowerCase())
                       && p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                       .collect(Collectors.toList());
    }
    default List<Profesores> getByApellido(String apellido){
        if(apellido == null)return new ArrayList<Profesores>();
        return getAll().stream().filter(p->p.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toList());
    }
    
    
}
