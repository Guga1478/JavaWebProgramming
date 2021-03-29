package ar.com.instituto.java.repositories.jdbc;

import ar.com.instituto.java.entities.Alumnos;
import ar.com.instituto.java.entities.Profesores;
import ar.com.instituto.java.repositories.interfaces.I_ProfesoresRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfesoresRepository implements I_ProfesoresRepository{
    
    private Connection conn;

    public ProfesoresRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Profesores profesores) {
        if(profesores==null) return;
        String query = "insert into profesores (id,nombre,apellido,dni,estado) values(?,?,?,?,?)";
        try (PreparedStatement ps=conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, profesores.getId());
            ps.setString(2, profesores.getNombre());
            ps.setString(3, profesores.getApellido());
            ps.setString(4, profesores.getDni());
            ps.setString(5, profesores.getEstado());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) profesores.setId(rs.getInt(1));
        }catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @Override
    public void remove(Profesores profesores) {
        if(profesores==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from profesores where id=?")){
            ps.setInt(1, profesores.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Profesores profesores) {
        if(profesores==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "update profesores set id=?, nombre=?, apellido=?, dni=?, estado=? where id=?")){
             ps.setInt(1, profesores.getId());
            ps.setString(2, profesores.getNombre());
            ps.setString(3, profesores.getApellido());
            ps.setString(4, profesores.getDni());
            ps.setString(5, profesores.getEstado());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Profesores> getAll() {
        List<Profesores>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from profesores")){
            while(rs.next()){
                list.add(new Profesores(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"), 
                        rs.getString("estado")                       
                ));                          
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    
    
}
