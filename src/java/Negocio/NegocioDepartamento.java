/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DTO.Departamento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hypnotz
 */
public class NegocioDepartamento {
    
        private static Connection conn = null;
        private static String login = "aRRIENDOTEMPORADA";
        private static String clave = "123";
        private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
        
        
        public void insertarDepto(Departamento departamento){
        
        CallableStatement callableStatement = null;
        Connection conn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(url,login,clave);
            
            conn.setAutoCommit(false);
            String sql = "{call SP_AgregarDepartamento(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString("v_DIRECCION", departamento.getDireccion());
            callableStatement.setInt("v_CANTIDAD_PIEZAS", departamento.getCantidadPiezas());
            callableStatement.setInt("v_ID_eSTADO", departamento.getIdEstado());
            callableStatement.setInt("v_CANTIDAD_BAÑOS", departamento.getCantidadBanos());
            callableStatement.setString("v_CONDICIONES", departamento.getCondiciones());
            callableStatement.setInt("v_ID_TIPO_ESTADO", departamento.getIdTipoEstado());
            callableStatement.setInt("v_ID_COMUNA", departamento.getIdComuna());
            callableStatement.setInt("v_ID_TARIFA", departamento.getIdTarifa());
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }
        
        public void eliminarDepto(int idDepto){
        
        CallableStatement callableStatement = null;
        Connection conn = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(url,login,clave);
            
            conn.setAutoCommit(false);
            String sql = "{call SP_EliminarDepartamento(?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("idDepto",idDepto);
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }
        
        public void actualizarDepto(Departamento  departamento){
        
        CallableStatement callableStatement = null;
        Connection conn = null;
        /*Departamento departamento = new Departamento();*/
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(url,login,clave);
            
            conn.setAutoCommit(false);
            String sql = "{call SP_ModificarDepartamento(?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("v_ID_DEPARTAMENTO", departamento.getIdDepto());
            callableStatement.setString("v_DIRECCION", departamento.getDireccion());
            callableStatement.setInt("v_CANTIDAD_PIEZAS", departamento.getCantidadPiezas());
            callableStatement.setInt("v_ID_eSTADO", departamento.getIdEstado());
            callableStatement.setInt("v_CANTIDAD_BAÑOS", departamento.getCantidadBanos());
            callableStatement.setString("v_CONDICIONES", departamento.getCondiciones());
            callableStatement.setInt("v_ID_TIPO_ESTADO", departamento.getIdTipoEstado());
            callableStatement.setInt("v_ID_COMUNA", departamento.getIdComuna());
            callableStatement.setInt("v_ID_TARIFA", departamento.getIdTarifa());
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }      

}

