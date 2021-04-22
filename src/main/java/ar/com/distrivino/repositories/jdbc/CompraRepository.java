package ar.com.distrivino.repositories.jdbc;

import ar.com.distrivino.entities.Compra;
import ar.com.distrivino.repositories.interfaces.I_CompraRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompraRepository implements I_CompraRepository{
    private Connection conn;

    public CompraRepository(Connection conn) {
        this.conn = conn;
    }
    
    
    @Override
    public void save(Compra compra) {
        if (compra==null)return;
        String query="insert into compra(proveedorId,vinoCodigo,cantidad,precioUnit,factura,fecha,total)values(?,?,?,?,?,?,?)";
        try (PreparedStatement ps=conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, compra.getProveedorId());
            ps.setInt(2, compra.getVinoCodigo());
            ps.setInt(3, compra.getCantidad());
            ps.setDouble(4,compra.getPrecioUnit());
            ps.setInt(5, compra.getFactura());
            ps.setString(6, compra.getFecha());
            ps.setDouble(7, compra.getTotal());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())compra.setFactura(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Compra compra) {
        if(compra==null)return;
        try (PreparedStatement ps=conn.prepareStatement("delete from compra where factura=?")){
            ps.setInt(1, compra.getFactura());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Compra compra) {
        if(compra == null)return;
        try (PreparedStatement ps=conn.prepareStatement(
                "update compra set proveedorId=?, vinocodigo=?, cantidad=?, precioUnit=?, factura=?, fecha=?, total=?")){
            ps.setInt(1, compra.getProveedorId());
            ps.setInt(2, compra.getVinoCodigo());
            ps.setInt(3, compra.getCantidad());
            ps.setDouble(4, compra.getPrecioUnit());
            ps.setInt(5, compra.getFactura());
            ps.setString(6, compra.getFecha());
            ps.setDouble(7, compra.getTotal());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Compra> getAll() {
        List<Compra>list = new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from compra")){
            while(rs.next()){
                list.add(new Compra(
                rs.getInt("proveedorId"),
                rs.getInt("vinoCodigo"),
                rs.getInt("cantidad"),
                rs.getDouble("precioUnit"),
                rs.getInt("factura"),
                rs.getString("fecha"),
                rs.getDouble("total")
                ));
            }              
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

//    @Override
//    public void sum(Compra compra) {
//        if(compra == null) return;
//        try(PreparedStatement ps=conn.prepareStatement("select SUM(cantidad*precioUnit)from compra")){
//           ps.setInt(1, compra.getCantidad());
//           ps.setDouble(2, compra.getPrecioUnit());
//           ps.setDouble(3, compra.getTotal());
//           ps.execute();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

//    @Override
//    public void sum(Compra compra) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    
}
