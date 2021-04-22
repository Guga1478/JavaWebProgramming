package ar.com.distrivino.repositories.jdbc;

import ar.com.distrivino.entities.Vino;
import ar.com.distrivino.repositories.interfaces.I_VinoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VinoRepository implements I_VinoRepository{
    private Connection conn;

    public VinoRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Vino vino) {
        if(vino == null) return;
        String query="insert into vinos(codigo,bodega,nombre,descripcion,anoElab,stock)values(?,?,?,?,?,?)";
        try (PreparedStatement ps=conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, vino.getCodigo());
            ps.setString(2, vino.getBodega());
            ps.setString(3, vino.getNombre());
            ps.setString(4, vino.getDescripcion());
            ps.setInt(5, vino.getAnoElab());
            ps.setInt(6, vino.getStock());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())vino.setCodigo(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Vino vino) {
        if(vino == null)return;
        try(PreparedStatement ps=conn.prepareStatement("delete form vino where codigo=?")) {
            ps.setInt(1, vino.getCodigo());
            ps.execute();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Vino vino) {
        if(vino == null)return;
        try (PreparedStatement ps=conn.prepareStatement(
                "update vino set codigo=?,bodega=?,nombre=?,descripcion=?,anoElab=?,stock=?" )){
            ps.setInt(1, vino.getCodigo());
            ps.setString(2, vino.getBodega());
            ps.setString(3, vino.getNombre());
            ps.setString(4, vino.getDescripcion());
            ps.setInt(5, vino.getAnoElab());
            ps.setInt(6, vino.getStock());
            ps.execute();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Vino> getAll() {
        List<Vino>list = new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from vinos")){
            while(rs.next()){
                list.add(new Vino(
                rs.getInt("codigo"),
                rs.getString("bodega"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getInt("anoElab"),
                rs.getInt("stock")
                ));
            }
                        
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    
    
}
