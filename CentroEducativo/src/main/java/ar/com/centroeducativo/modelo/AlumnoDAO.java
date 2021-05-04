package ar.com.centroeducativo.modelo;

import ar.com.centroeducativo.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar() {
        String sql = "select * from alumno";
        List<Alumno>lista=new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alu = new Alumno();
                alu.setId(rs.getInt(1));
                alu.setNombres(rs.getString(2));
                alu.setDni(rs.getString(3));
                alu.setIdMaterias(rs.getInt(4));
                alu.setUser(rs.getString(5));
                lista.add(alu);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Alumno alu) {
        String sql = "insert into alumno(nombres,dni,idMaterias,user)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, alu.getNombres());
            ps.setString(2, alu.getDni());
            ps.setInt(3, alu.getIdMaterias());
            ps.setString(4, alu.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Alumno listarId(int id) {
        Alumno alu = new Alumno();
        String sql = "select * from alumno where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                alu.setNombres(rs.getString(2));
                alu.setDni(rs.getString(3));
                alu.setIdMaterias(rs.getInt(4));
                alu.setUser(rs.getString(5));
            }

        } catch (Exception e) {
        }
        return alu;
    }
    
    public int actualizar(Alumno alu){
        String sql="update alumno set nombres=?, dni=?, idMaterias=?, user=? where id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, alu.getNombres());
            ps.setString(2, alu.getDni());
            ps.setInt(3, alu.getIdMaterias());
            ps.setString(4, alu.getUser());
            ps.setInt(5, alu.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id){
        String sql = "delete from alumno where id="+id;
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    
    public Alumno buscar(String dni){
        Alumno alu = new Alumno();
        String sql = "Select * from alumno where Dni="+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                alu.setId(rs.getInt(1));
                alu.setNombres(rs.getString(2));
                alu.setDni(rs.getString(3));                
                alu.setIdMaterias(rs.getInt(4));
                alu.setUser(rs.getString(5));
            }        
        } catch (Exception e) {
        }
        return alu;
    }

}
