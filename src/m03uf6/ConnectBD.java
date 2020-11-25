/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03uf6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author arnaugarciaalvarez
 */
public class ConnectBD {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/jugadores";
        String username = "root";
        String password = "";

        Connection con = DriverManager.getConnection(url, username, password);
        
        if (con != null) {
            System.out.println("Conexión correctamente realizada!");
        } else {
            System.out.println("Conexión fallida...");
        }
        
        Statement statement = con.createStatement();
        
        String consulta = "select nombreJugador FROM jugadores";
        ResultSet r1 = statement.executeQuery(consulta);
        
        while(r1.next()){
            String nombreJugador = r1.getString("nombreJugador");  
            System.out.println("Jugador:" + nombreJugador + "\n");
        
        }
        
        

        
    }
}
