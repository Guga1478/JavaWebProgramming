package ar.com.centroeducativo.modelo;

import ar.com.centroeducativo.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MateriasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Materias buscar(int id){
        Materias ma = new Materias();
        String sql = "select * from materias where id="+id;
        try {
            con=cn.Conexion();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ma.setId(rs.getInt(1));
                ma.setNombre(rs.getString(2));
                ma.setTurno(rs.getString(3));
                ma.setDia(rs.getString(4));
                ma.setCupoMaxAlumnos(rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return ma;
    }
    
    public int actualizarCantidad(int id, int cupoMaxAlumnos){
        String sql = "update materias set cupo_max_alumnos=? where id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cupoMaxAlumnos);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public List listar() {
        String sql = "select * from materias";
        List<Materias> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Materias ma = new Materias();
                ma.setId(rs.getInt(1));
                ma.setNombre(rs.getString(2));
                ma.setTurno(rs.getString(3));
                ma.setDia(rs.getString(4));
                ma.setCupoMaxAlumnos(rs.getInt(5));
                lista.add(ma);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
     public int agregar(Materias ma) {
        String sql = "insert into materias(nombre,turno,dia,cupo_max_alumnos)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma.getNombre());
            ps.setString(2, ma.getTurno());
            ps.setString(3, ma.getDia());
            ps.setInt(4, ma.getCupoMaxAlumnos());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     
     public Materias listarId(int id) {
        Materias ma = new Materias();
        String sql = "select * from materias where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                ma.setId(rs.getInt(1));
                ma.setNombre(rs.getString(2));
                ma.setTurno(rs.getString(3));
                ma.setDia(rs.getString(4));
                ma.setCupoMaxAlumnos(rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return ma;
    }
     
     public int actualizar(Materias ma){
        String sql="update materias set nombre=?, turno=?, dia=?, cupo_max_alumnos=? where id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma.getNombre());
            ps.setString(2, ma.getTurno());
            ps.setString(3, ma.getDia());
            ps.setInt(4, ma.getCupoMaxAlumnos());
            ps.setInt(5, ma.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     
     public void delete(int id){
        String sql = "delete from materias where id="+id;
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }
     
     public Materias buscar(String nombre){
        Materias ma = new Materias();
        String sql = "Select * from materias where nombre="+nombre;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                ma.setId(rs.getInt(1));
                ma.setTurno(rs.getString(2));                
                ma.setDia(rs.getString(3));
                ma.setCupoMaxAlumnos(rs.getInt(4));
            }        
        } catch (Exception e) {
        }
        return ma;
    }
     
     public List<Materias> getAll() {
        List<Materias>list=new ArrayList();
        try (ResultSet rs=con.createStatement().executeQuery("select * from materias")){
            while(rs.next()){
                list.add(new Materias(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("turno"),
                        rs.getString("dia"),
                        rs.getInt("cupo_max_alumnos")                       
                ));                          
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
