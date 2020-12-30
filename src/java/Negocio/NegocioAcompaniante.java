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

/**
 *
 * @author hypnotz
 */
public class NegocioAcompaniante {
    
    public void insertMantenimiento(Acompaniantes acompaniante){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        MantenimientoDto auxMantenimiento = new MantenimientoDto();
        
        try {
            String sql = "{call SP_INSERTAR_ACOMPANIANTE(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, acompaniante.getRut());
            callableStatement.setInt(2, acompaniante.getIdReserva());
            callableStatement.setString(3, acompaniante.getNombre());
            callableStatement.setString(4, acompaniante.getApellidos());
            callableStatement.executeQuery();
            conexionOracle.desconexion();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }    
}
