/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DTO.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hypnotz
 */
public class NegocioUsuario {
    
        private static Connection conn = null;
        private static String login = "aRRIENDOTEMPORADA";
        private static String clave = "123";
        private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
        
        public void insertarUsuario(Usuario usuario){
        
        CallableStatement callableStatement = null;
        Connection conn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(url,login,clave);
            
            conn.setAutoCommit(true);
            String sql = "{call SP_AgregarUsuario(?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString("v_NOMBRE_USUARIO", usuario.getNombreUsuario());
            callableStatement.setString("v_CONTRASENA", usuario.getContrasena());
            callableStatement.setInt("v_ID_PRIVILEGIO", usuario.getIdPrivilegio());
            callableStatement.executeQuery();
            conn.close();
            callableStatement.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }
        
         public void modificarUsuario(Usuario usuario){
        
        CallableStatement callableStatement = null;
        Connection conn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(url,login,clave);
            
            conn.setAutoCommit(true);
            String sql = "{call SP_ModificarUsuario(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("V_ID_USUARIO", usuario.getIdUsuario());
            callableStatement.setString("V_NOMBRE_USUARIO", usuario.getNombreUsuario());
            callableStatement.setString("V_CONTRASENA", usuario.getContrasena());
            callableStatement.setInt("V_ID_PRIVILEGIO", usuario.getIdPrivilegio());
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }      
        
         
             public void eliminarUsuario(int idUsuario){
        
        CallableStatement callableStatement = null;
        Connection conn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(url,login,clave);
            
            conn.setAutoCommit(false);
            String sql = "{call SP_EliminarUsuario(?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("idUsuario",idUsuario);
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }
    
}
