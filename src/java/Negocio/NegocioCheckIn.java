/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.Checkin;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author hypnotz
 */
public class NegocioCheckIn {
    
    public void insertCheckIn(Checkin checkin){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        
        Checkin auxCheckIn = new Checkin();
        try {
            String sql = "{call SP_INGRESAR_CHECK_IN(?,?,?,?)}";
            
            callableStatement = conn.prepareCall(sql);
            //callableStatement.setInt(1, checkin.getIdCheckin());
            callableStatement.setString(1, checkin.getFecha());
            callableStatement.setInt(2, checkin.getPagoRestante());
            callableStatement.setInt(3, checkin.getIdReserva());
            callableStatement.setInt(4, checkin.getIdRecursoHumano());
            callableStatement.executeQuery();
            conexionOracle.desconexion();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }    
}
