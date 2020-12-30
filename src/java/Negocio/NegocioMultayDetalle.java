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
public class NegocioMultayDetalle {
    
    
    public void insertarCheckOutMultaDetalle(CheckOut checkOut, Multa multa){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        
        CallableStatement callableStatement = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            conn.setAutoCommit(true);
            String sql = "{call SP_CheckOutMultaDetalle(?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("V_TOTAL_MULTA", multa.getTotal());
            callableStatement.setInt("V_ID_CHECK_OUT", multa.getIdCheckIn());
            callableStatement.setInt("V_ID_CHECK_IN", checkOut.getIdCheckIn());
            callableStatement.setString("V_FECHA", checkOut.getFecha());
            callableStatement.setInt("V_ID_RECURSOS", checkOut.getIdRecursoHumano());

            callableStatement.executeQuery();
            conn.close();
            callableStatement.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }
    
 public int retornaIdMultaLast(CheckOut checkOut, Multa multa){
        int resp = 0;
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {
            String sql = "{call SP_CheckOutMultaDetalle2(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, multa.getTotal());
            callableStatement.setInt(2, multa.getIdCheckIn());
            callableStatement.setInt(3, checkOut.getIdCheckIn());
            callableStatement.setString(4, checkOut.getFecha());
            callableStatement.setInt(5, checkOut.getIdRecursoHumano());
            callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
            callableStatement.executeQuery();

            resp = callableStatement.getInt(6);
           
        }catch(Exception ex){
            return resp;
        }
        
        return resp;
    }
 
 public int retornaIDInsert(){
        int resp = 0;
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        try {
            String sql = "{call SP_TRAERULTIMAMULTA(?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
            callableStatement.executeQuery();
            resp = callableStatement.getInt(1);
        }catch(Exception ex){
            return resp;
        }
        return resp;
    }
 
 public void insertarDetalle(MultaDetalle multad){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        
        CallableStatement callableStatement = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn.setAutoCommit(true);
            String sql = "{call SP_DetalleMulta(?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("V_TOTAL_MULTA", multad.getValorMulta());
            callableStatement.setString("V_DESCRIPCION", multad.getDescripcion());
            callableStatement.setInt("V_ID_MAXMULTA", multad.getIdMulta());
            
            callableStatement.executeQuery();
            conn.close();
            callableStatement.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }
}
