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
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author hypnotz
 */
public class NegocioTipoEstado {
    
     public ArrayList<TipoEstado> listarTipo(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        
        TipoEstado auxTipo = new TipoEstado();
        
        ArrayList<TipoEstado> auxLista = new ArrayList<TipoEstado>();

        try {
            String sql = "{call SP_LISTAR_TipoEstado(?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxTipo = new TipoEstado();
                auxTipo.setTipoEstado(rs.getInt(1));
                auxTipo.setDescripcion(rs.getString(2));
                //System.out.println(rs.getString(1));
                //System.out.println(rs.getString(2));
                auxLista.add(auxTipo);
            }

            rs.close();
            conexionOracle.desconexion();

        } catch (Exception ex) {

        }

        return auxLista;
    }
    
}
