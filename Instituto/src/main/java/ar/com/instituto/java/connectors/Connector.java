package ar.com.instituto.java.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/instituto";
    private static String user = "root";
    private static String pass = "Amelia2015";
    private static Connection conn = null;
    
    private Connector(){
        
    }
    
    public synchronized static Connection getConnection(){
        try{
        if(conn==null || conn.isClosed()){  
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
          }
        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
    
}
