/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.ReservaUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author hypnotz
 */
public class NegocioReservaUsuario {
    
    public ArrayList<ReservaUsuario> listarReservaUsuario(String usuario){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ReservaUsuario auxReservaUsuario = new ReservaUsuario();
        ArrayList<ReservaUsuario> auxLista = new ArrayList<ReservaUsuario>();

        try {
            String sql = "{call SP_RESERVAS_ACTIVAS_X_USUARIO(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.setString(8, usuario);
            
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxReservaUsuario = new ReservaUsuario();
                auxReservaUsuario.setIdReserva(rs.getInt(1));
                auxReservaUsuario.setDepto(rs.getString(2));
                auxReservaUsuario.setFecha(rs.getString(3));
                auxReservaUsuario.setFechaInicio(rs.getString(4));
                auxReservaUsuario.setFechaFin(rs.getString(5));
                auxReservaUsuario.setPago(rs.getInt(6));
                
                auxLista.add(auxReservaUsuario);
            }
            rs.close();
            conexionOracle.desconexion();
        } catch (Exception ex) {
        }
        return auxLista;
    }
}
