package ar.com.distrivino.repositories.jdbc;

import ar.com.distrivino.entities.Proveedor;
import ar.com.distrivino.repositories.interfaces.I_ProveedorRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProveedorRepository implements I_ProveedorRepository {
    private Connection conn;

    public ProveedorRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void save(Proveedor proveedor) {
        if(proveedor == null) return;
        String query ="insert into proveedor(id,razonSocial,email)values(?,?,?)";
        try (PreparedStatement ps=conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, proveedor.getId());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getEmail());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())proveedor.setId(rs.getInt(1));          
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Proveedor proveedor) {
        if(proveedor==null)return;
        try (PreparedStatement ps=conn.prepareStatement("delete from proveedor where id=?")){
            ps.setInt(1, proveedor.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Proveedor proveedor) {
        if(proveedor == null)return;
        try (PreparedStatement ps=conn.prepareStatement(
                "update proveedor set id:?, razonSocial=?, email=?")){
            ps.setInt(1, proveedor.getId());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getEmail());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Proveedor> getAll() {
        List<Proveedor>list = new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from proveedor")){
            while(rs.next()){
                list.add(new Proveedor(
                rs.getInt("id"),
                rs.getString("razonSocial"),
                rs.getString("email")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
