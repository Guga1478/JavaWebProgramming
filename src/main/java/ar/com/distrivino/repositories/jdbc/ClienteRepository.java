package ar.com.distrivino.repositories.jdbc;

import ar.com.distrivino.entities.Cliente;
import ar.com.distrivino.repositories.interfaces.I_ClienteRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements I_ClienteRepository{
    private Connection conn;

    public ClienteRepository(Connection conn) {
        this.conn = conn;
    }
    

    @Override
    public void save(Cliente cliente) {
        if(cliente==null) return;
        String query="insert into cliente(id,nombre,telefono,email,formaPago)values(?,?,?,?,?)";
        try(PreparedStatement ps=conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getFormaPago());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())cliente.setId(rs.getInt(1));            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Cliente cliente) {
        if(cliente==null)return;
        try (PreparedStatement ps=conn.prepareStatement("delete from cliente where id=?")){
            ps.setInt(1, cliente.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Cliente cliente) {
        if(cliente==null)return;
        try (PreparedStatement ps=conn.prepareStatement(
                "update cliente set id=?, nombre=?, telefono=?, email=?, formaPago=?")){
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getFormaPago());
            ps.execute();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from cliente")){
            while(rs.next()){
                list.add(new Cliente(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("email"),
                rs.getString("formaPago")
                ));
            }            
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
