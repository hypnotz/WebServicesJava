/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.Provincia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author hypnotz
 */
public class NegocioProvincia {
    
    public ArrayList<Provincia> getProvincia(){

        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        Provincia auxProvincia = new Provincia();
        ArrayList<Provincia> auxLista = new ArrayList<Provincia>();

        try {
            String sql = "{call SP_GET_PROVINCIA(?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxProvincia = new Provincia();
                auxProvincia.setIdProvincia(rs.getInt(1));
                auxProvincia.setNombreProvincia(rs.getString(2));
                //System.out.println(rs.getString(1));
                //System.out.println(rs.getString(2));
                auxLista.add(auxProvincia);
            }


            rs.close();
            conexionOracle.desconexion();

        } catch (Exception ex) {
        }
        return auxLista;

    }
    
    public ArrayList<Provincia> getProvinciaById(int idRegion){

        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        Provincia auxProvincia = new Provincia();
        ArrayList<Provincia> auxLista = new ArrayList<Provincia>();

        try {
            String sql = "{call SP_LISTAR_PROVINCIA_X_REGION(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.setInt(4, idRegion);

            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxProvincia = new Provincia();
                auxProvincia.setIdProvincia(rs.getInt(1));
                auxProvincia.setNombreProvincia(rs.getString(2));
                //System.out.println(rs.getString(1));
                //System.out.println(rs.getString(2));
                auxLista.add(auxProvincia);
            }
            rs.close();
            conexionOracle.desconexion();
        } catch (Exception ex) {
        }
        return auxLista;
    }

    
}
