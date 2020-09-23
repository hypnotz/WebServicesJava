/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hypnotz
 */
public class NegocioUsuario {
    
        public void insertarUsuario(Usuario usuario){
        
        ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();
        
        
        CallableStatement callableStatement = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn.setAutoCommit(true);
            String sql = "{call SP_AgregarUsuario(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString("v_NOMBRE_USUARIO", usuario.getNombreUsuario());
            callableStatement.setString("v_CONTRASENA", usuario.getContrasena());
            callableStatement.setInt("v_ID_PRIVILEGIO", usuario.getIdPrivilegio());
            callableStatement.setInt("v_ID_ESTADO", usuario.getIdEstado());
            callableStatement.executeQuery();
            conn.close();
            callableStatement.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }

        public void insertarUsuario2(Cliente cliente, Usuario usuario){
        
        ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();
        
        
        CallableStatement callableStatement = null;
        try {
            
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            
            conn.setAutoCommit(true);
            String sql = "{call SP_CREAR_CLIENTE_USUARIO(?,?,?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString("V_RUT", cliente.getRut());
            callableStatement.setString("V_NOMBRES", cliente.getNombres());
            callableStatement.setString("V_APELLIDO_PATERNO", cliente.getApellidoPaterno());
            callableStatement.setString("V_APELLIDO_MATERNO", cliente.getApellidoMaterno());
            callableStatement.setString("V_CORREO", cliente.getCorreo());
            callableStatement.setString("V_FECHA_NACIMIENTO", cliente.getFechaNacimiento());
            callableStatement.setInt("V_TELEFONO", cliente.getTelefono());
            callableStatement.setString("V_NOMBRE_USUARIO", usuario.getNombreUsuario());
            callableStatement.setString("V_CONTRASENA", usuario.getContrasena());
            callableStatement.setInt("V_ID_PRIVILEGIO", usuario.getIdPrivilegio());
            callableStatement.setInt("V_ID_ESTADO", usuario.getIdEstado());
            
           
            callableStatement.executeQuery();
            conn.close();
            callableStatement.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }
      
  
         public void modificarUsuario(Usuario usuario){
        
        ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();
        
        
        CallableStatement callableStatement = null;
        try {
          
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
          
            
            conn.setAutoCommit(true);
            String sql = "{call SP_ModificarUsuario(?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("V_ID_USUARIO", usuario.getIdUsuario());
            callableStatement.setString("V_NOMBRE_USUARIO", usuario.getNombreUsuario());
            callableStatement.setString("V_CONTRASENA", usuario.getContrasena());
            callableStatement.setInt("V_ID_PRIVILEGIO", usuario.getIdPrivilegio());
            callableStatement.setInt("V_ID_ESTADO", usuario.getIdEstado());
            
         
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }      
        
 public void eliminarUsuario(int idUsuario){
        
       ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();
        
        CallableStatement callableStatement = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

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
