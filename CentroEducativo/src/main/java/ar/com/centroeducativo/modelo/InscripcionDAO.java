package ar.com.centroeducativo.modelo;

import ar.com.centroeducativo.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InscripcionDAO {
     Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql = "select max(numeroSerie) from inscripcion";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
                
            }
        } catch (Exception e) {
        }
        return numeroserie;
    }
    
    public String IdInscripcion(){
        String idInscripcion="";
        String sql = "select max(idInscripcion) from inscripcion";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                idInscripcion=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idInscripcion;
    }
    
    public int guardarInscripcion(Inscripcion insc){
        String sql = "Insert into inscripcion(idAlumno,idMaterias,numeroSerie,fecha,estado,cantidad)values(?,?,?,?,?,?)";
        try {
             con=cn.Conexion();
             ps=con.prepareStatement(sql);
             ps.setInt(1, insc.getIdAlumno());
             ps.setInt(2, insc.getIdMaterias());
             ps.setString(3, insc.getNumeroSerie());
             ps.setString(4, insc.getFecha());
             ps.setString(5, insc.getEstado());
             ps.setInt(6, insc.getCantidad());
             ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int guardarDetalleInscripcion(Inscripcion inscripcion){
        String sql = "insert into detalle_inscripcion(idInscripcion,idMaterias,cantidad)values(?,?,?)";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, inscripcion.getIdInscripcion());
            ps.setInt(2, inscripcion.getIdMaterias());
            ps.setInt(3, inscripcion.getCantidad());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
