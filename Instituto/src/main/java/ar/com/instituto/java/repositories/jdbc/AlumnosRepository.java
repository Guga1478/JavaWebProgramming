package ar.com.instituto.java.repositories.jdbc;

import ar.com.instituto.java.entities.Alumnos;
import ar.com.instituto.java.repositories.interfaces.I_AlumnosRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnosRepository implements I_AlumnosRepository{
    private Connection conn;

    public AlumnosRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void save(Alumnos alumnos) {
        if(alumnos==null) return;
        String query = "insert into alumnos (id,nombre,apellido,dni,idMaterias) values(?,?,?,?,?)";
        try (PreparedStatement ps=conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, alumnos.getId());
            ps.setString(2, alumnos.getNombre());
            ps.setString(3, alumnos.getApellido());
            ps.setString(4, alumnos.getDni());
            ps.setInt(5, alumnos.getIdMaterias());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) alumnos.setId(rs.getInt(1));
        }catch (Exception e) {
            e.printStackTrace(); 
        }
       
    }

    @Override
    public void remove(Alumnos alumnos) {
        if(alumnos==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from alumnos where id=?")){
            ps.setInt(1, alumnos.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Alumnos alumnos) {
        if(alumnos==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "update alumnos set id=?, nombre=?, apellido=?, dni=?, idMaterias=? where id=?")){
             ps.setInt(1, alumnos.getId());
            ps.setString(2, alumnos.getNombre());
            ps.setString(3, alumnos.getApellido());
            ps.setString(4, alumnos.getDni());
            ps.setInt(5, alumnos.getIdMaterias());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Alumnos> getAll() {
        List<Alumnos>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from alumnos")){
            while(rs.next()){
                list.add(new Alumnos(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"), 
                        rs.getInt("idMaterias")                       
                ));                          
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
