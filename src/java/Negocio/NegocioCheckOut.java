/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.CheckOut;
import java.sql.CallableStatement;
import java.sql.Connection;

public class NegocioCheckOut {
    
    public void insertCheckOut(CheckOut checkout){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        
        CheckOut auxCheckOut = new CheckOut();
        try {
            String sql = "{call SP_INGRESAR_CHECK_OUT(?,?,?)}";
            
            callableStatement = conn.prepareCall(sql);
            //callableStatement.setInt(1, checkin.getIdCheckin());
             callableStatement.setInt(1, checkout.getIdCheckIn());
            callableStatement.setString(2, checkout.getFecha());
            callableStatement.setInt(3, checkout.getIdRecursoHumano());
            callableStatement.executeQuery();
            conexionOracle.desconexion();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }    
    
    
    
    
}
