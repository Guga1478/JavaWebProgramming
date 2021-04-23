package ar.com.instituto.java.repositories.interfaces;

import ar.com.instituto.java.entities.Alumnos;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_AlumnosRepository {
    void save(Alumnos alumnos);
    void remove(Alumnos alumnos);
    void update(Alumnos alumnos);
    List<Alumnos>getAll();
    default Alumnos getById(int id){
        return getAll().stream()
                       .filter(a->a.getId()==id).findAny().orElse(new Alumnos());                
    }
    default List<Alumnos>getByApellido(String apellido){
        if(apellido==null) return new ArrayList<Alumnos>();
        return getAll().stream()
                       .filter(a->a.getApellido().equalsIgnoreCase(apellido))
                       .collect(Collectors.toList());
    }
    default List<Alumnos>getLikeApellido(String apellido){
        if(apellido==null)return new ArrayList<Alumnos>();
        return getAll().stream()
                       .filter(a->a.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                       .collect(Collectors.toList());
    }
    default List<Alumnos>getLikeApellidoNombre(String apellido, String nombre){
        if(apellido==null || nombre==null)return new ArrayList<Alumnos>();
        return getAll().stream()
                       .filter(a->a.getApellido().toLowerCase().contains(apellido.toLowerCase())
                       && a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                       .collect(Collectors.toList());
    }
   
   
    
}
