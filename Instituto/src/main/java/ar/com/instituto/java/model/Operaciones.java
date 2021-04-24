package ar.com.instituto.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operaciones {
    private String driver;
    private  String url;
    private  String user;
    private  String pass;
//    private static Connection conn = null;

    public Operaciones() {
     driver = "com.mysql.cj.jdbc.Driver";
     url = "jdbc:mysql://localhost:3306/log";
     user = "root";
     pass = "Amelia2015";
    }
    public int loguear(String us, String pasw){
       Connection cnx;
       PreparedStatement ps;
       ResultSet rs;
       int nivel=0;
       String sql = "select nivel from login where usuario='" + us + "'and contra='" + pasw + "'";
        try {
            Class.forName(this.driver);
            cnx = DriverManager.getConnection(
            this.url, 
            this.user,
            this.pass            
            );
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                nivel = rs.getInt(1);
            }
            cnx.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return nivel; 
    }
    
}
