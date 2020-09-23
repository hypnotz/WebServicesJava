/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hypnotz
 */
public class ConexionOracle {
    private static Connection conn = null;
    private static String login = "aRRIENDOTEMPORADA";
    private static String clave = "123";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);
            if(conn != null){
                System.out.println("Conexion exitosa");
            }else{
                System.out.println("Conexion es erronea");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexión erronea " + e.getMessage());

        }
        return conn;
    }

    public void desconexion(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar " + e.getMessage());
        }
  
    }
}

