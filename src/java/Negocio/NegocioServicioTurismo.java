/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.ServicioTurismoDto;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author hypnotz
 */
public class NegocioServicioTurismo {
    
    
    public void insertServicioTurismo(ServicioTurismoDto turismo){

        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {

            String sql = "{call SP_INSERT_SERVICIO_TURISMO(?, ?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, turismo.getIdTurismo());
            callableStatement.setInt(2, turismo.getIdReserva());
            callableStatement.executeQuery();
            conexionOracle.desconexion();

        }catch(Exception ex){
            System.out.println(ex);
        }

    }

    
}
