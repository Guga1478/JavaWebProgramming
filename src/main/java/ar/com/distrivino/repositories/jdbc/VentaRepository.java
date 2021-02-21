package ar.com.distrivino.repositories.jdbc;

import ar.com.distrivino.entities.Compra;
import ar.com.distrivino.entities.Venta;
import ar.com.distrivino.repositories.interfaces.I_VentaRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaRepository implements I_VentaRepository{
    private Connection conn;

    public VentaRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Venta venta) {
        if(venta == null)return;
        String query = "insert into venta(clienteId,vinoCodigo,cantidad,precioUnit,factura,fecha,total)values(?,?,?,?,?,?,?)";
        try(PreparedStatement ps=conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, venta.getClienteId());
            ps.setInt(2, venta.getVinoCodigo());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecioUnit());
            ps.setInt(5, venta.getFactura());
            ps.setString(6, venta.getFecha());
            ps.setDouble(7, venta.getTotal());
            ps.execute();         
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())venta.setFactura(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Venta venta) {
        if(venta == null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from venta where factura=?")){
            ps.setInt(1, venta.getFactura());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Venta venta) {
        if(venta == null)return;
        try (PreparedStatement ps=conn.prepareStatement(
                "update venta set clienteId=?, vinocodigo=?, cantidad=?, precioUnit=?, factura=?, fecha=?, total=?")){
            ps.setInt(1, venta.getClienteId());
            ps.setInt(2, venta.getVinoCodigo());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecioUnit());
            ps.setInt(5, venta.getFactura());
            ps.setString(6, venta.getFecha());
            ps.setDouble(7, venta.getTotal());
            ps.execute();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Venta> getAll() {
         List<Venta>list = new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from venta")){
            while(rs.next()){
                list.add(new Venta(
                rs.getInt("clienteId"),
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
    
}
