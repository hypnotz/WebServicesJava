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
public class NegocioCliente {
        
        public ArrayList<Cliente> listarCliente(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        Cliente auxCliente = new Cliente();
        
        ArrayList<Cliente> auxListaCliente = new ArrayList<Cliente>();

        try {
            String sql = "{call SP_LISTAR_CLIENTE(?,?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(9, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
            
            callableStatement.executeQuery();
            
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxCliente = new Cliente();
                /*auxRegion.setIdRegion(rs.getInt(1));
                auxRegion.setNombreRegion(rs.getString(2));
                //System.out.println(rs.getString(1));
                //System.out.println(rs.getString(2));
                auxLista.add(auxRegion);*/
               auxCliente.setIdCliente(rs.getInt(1));
               auxCliente.setRut(rs.getString(2));
               auxCliente.setNombres(rs.getString(3));
               auxCliente.setApellidoPaterno(rs.getString(4));
               auxCliente.setApellidoMaterno(rs.getString(5));
               auxCliente.setCorreo(rs.getString(6));
               auxCliente.setFechaNacimiento(rs.getString(7));
               auxCliente.setTelefono(rs.getInt(8));
               auxCliente.setIdUsuario(rs.getInt(9));
               auxListaCliente.add(auxCliente);
            }

            rs.close();
            conexionOracle.desconexion();

        } catch (Exception ex) {

        }

        return auxListaCliente;
    }
        
        
}
