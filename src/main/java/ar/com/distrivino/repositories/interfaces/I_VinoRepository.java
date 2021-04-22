package ar.com.distrivino.repositories.interfaces;

import ar.com.distrivino.entities.Vino;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_VinoRepository {
    void save (Vino vino);
    void remove (Vino vino);
    void update (Vino vino);
    List<Vino> getAll();
    default Vino getByCodigo(int codigo){
        return getAll().stream().filter(v->v.getCodigo()==codigo).findAny().orElse(new Vino());
    }
    default List<Vino> getLikeNombre(String nombre){
        if(nombre==null) return new ArrayList<Vino>();
        return getAll().stream().filter(v->v.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                       .collect(Collectors.toList());
    }
    
    default List<Vino>getLikeNombreBodega(String nombre, String bodega){
        if(nombre==null || bodega==null) return new ArrayList<Vino>();
        return getAll().stream().filter(v->v.getNombre().toLowerCase().contains(nombre.toLowerCase())
                    && v.getBodega().toLowerCase().contains(bodega.toLowerCase()))
                    .collect(Collectors.toList());                       
    }
    
}
