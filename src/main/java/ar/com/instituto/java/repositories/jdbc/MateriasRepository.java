package ar.com.instituto.java.repositories.jdbc;

import ar.com.instituto.java.entities.Materias;
import ar.com.instituto.java.enums.Dia;
import ar.com.instituto.java.enums.Turno;
import ar.com.instituto.java.repositories.interfaces.I_MateriasRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MateriasRepository implements I_MateriasRepository{
    
    private Connection conn;

    public MateriasRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Materias materias) {
        if(materias==null) return;
       String query = "insert into materias (id,nombre,turno,dia,profesor,cupo_max_alumnos) values(?,?,?,?,?,?)";
        try (PreparedStatement ps=conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, materias.getId());
            ps.setString(2, materias.getNombre());
            ps.setString(3, materias.getTurno().toString());
            ps.setString(4, materias.getDia().toString());
            ps.setString(5, materias.getProfesor());
            ps.setInt(6, materias.getCupoMaxAlumnos());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) materias.setId(rs.getInt(1));
        }catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @Override
    public void remove(Materias materias) {
        if(materias==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from materias where id=?")){
            ps.setInt(1, materias.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Materias materias) {
        if(materias==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "update materias set id=?, nombre=?, turno=?, dia=?, profesor=?, cupo_max_alumnos=? where id=?")){
             ps.setInt(1, materias.getId());
            ps.setString(2, materias.getNombre());
            ps.setString(3, materias.getTurno().toString());
            ps.setString(4, materias.getDia().toString());
            ps.setString(5, materias.getProfesor());
            ps.setInt(6, materias.getCupoMaxAlumnos());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Materias> getAll() {
        List<Materias>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from materias")){
            while(rs.next()){
                list.add(new Materias(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        Turno.valueOf(rs.getString("turno")),
                        Dia.valueOf(rs.getString("dia")),
                        rs.getString("profesor"), 
                        rs.getInt("cupo_max_alumnos")                       
                ));                          
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
