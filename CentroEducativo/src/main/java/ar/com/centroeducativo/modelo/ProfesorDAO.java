package ar.com.centroeducativo.modelo;

import ar.com.centroeducativo.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
     public Profesor validar(String user, String dni){
        Profesor pr=new Profesor();
        String sql="select * from profesor where user=? and dni=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while(rs.next()){
                pr.setId(rs.getInt("id"));
                pr.setUser(rs.getString("user"));
                pr.setDni(rs.getString("dni"));
                pr.setNombres(rs.getString("nombres"));
                pr.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return pr;
    }
    
    public List listar() {
        String sql = "select * from profesor";
        List<Profesor> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profesor pr = new Profesor();
                pr.setId(rs.getInt(1));
                pr.setNombres(rs.getString(2));
                pr.setDni(rs.getString(3));
                pr.setEstado(rs.getString(4));
                pr.setUser(rs.getString(5));
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Profesor pr) {
        String sql = "insert into profesor(nombres,dni,estado,user)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombres());
            ps.setString(2, pr.getDni());
            ps.setString(3, pr.getEstado());
            ps.setString(4, pr.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Profesor listarId(int id) {
        Profesor pr = new Profesor();
        String sql = "select * from profesor where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pr.setNombres(rs.getString(2));
                pr.setDni(rs.getString(3));
                pr.setEstado(rs.getString(4));
                pr.setUser(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return pr;
    }
    
    public int actualizar(Profesor pr){
        String sql="update profesor set nombres=?, dni=?, estado=?, user=? where id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombres());
            ps.setString(2, pr.getDni());
            ps.setString(3, pr.getEstado());
            ps.setString(4, pr.getUser());
            ps.setInt(5, pr.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id){
        String sql = "delete from profesor where id="+id;
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    
    public Profesor buscar(String dni){
        Profesor pr = new Profesor();
        String sql = "Select * from profesor where Dni="+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pr.setId(rs.getInt(1));
                pr.setNombres(rs.getString(2));
                pr.setDni(rs.getString(3));                
                pr.setEstado(rs.getString(4));
                pr.setUser(rs.getString(5));
            }        
        } catch (Exception e) {
        }
        return pr;
    }
    
}
