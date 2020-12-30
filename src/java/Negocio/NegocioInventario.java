/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.Inventario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author hypnotz
 */
public class NegocioInventario {
    
    public void IngresarInventario(Inventario inventario)
    {
       ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();


            CallableStatement callableStatement = null;

            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conn.setAutoCommit(true);
                String sql = "{call SP_INGRESAR_INVENTARIO(?,?,?,?,?)}";
                callableStatement = conn.prepareCall(sql);
                callableStatement.setInt("V_ID_DEPTO",inventario.getId_departamento());
                callableStatement.setString("V_CABLE", String.valueOf(inventario.getCable()));
                callableStatement.setString("V_INTERNET", String.valueOf(inventario.getInternet()));
                callableStatement.setString("V_CALEFACCION", String.valueOf(inventario.getCalefaccion()));
                callableStatement.setString("V_AMOBLADO", String.valueOf(inventario.getAmoblado()));
                callableStatement.executeQuery();
                callableStatement.close();
                conn.close();
                } catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }
    }
    
    public void actualizarInventario(Inventario inventario)
    {
       ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();

            CallableStatement callableStatement = null;

            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conn.setAutoCommit(true);
                String sql = "{call SP_ACTUALIZAR_INVENTARIO(?,?,?,?,?)}";
                callableStatement = conn.prepareCall(sql);
                callableStatement.setInt("V_ID_DEPTO",inventario.getId_departamento());
                callableStatement.setString("V_CABLE", String.valueOf(inventario.getCable()));
                callableStatement.setString("V_INTERNET", String.valueOf(inventario.getInternet()));
                callableStatement.setString("V_CALEFACCION", String.valueOf(inventario.getCalefaccion()));
                callableStatement.setString("V_AMOBLADO", String.valueOf(inventario.getAmoblado()));
                callableStatement.executeQuery();
                callableStatement.close();
                conn.close();
                } catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }
    }
    
    public ArrayList<Inventario> listarInventario(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        Inventario auxInventario = new Inventario();
        ArrayList<Inventario> auxLista = new ArrayList<Inventario>();

        try {
            String sql = "{call SP_LISTAR_INVENTARIO(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            
            while (rs.next()){
                auxInventario = new Inventario();
                auxInventario.setId_departamento(rs.getInt(1));
                auxInventario.setCable(rs.getString(2));
                auxInventario.setInternet(rs.getString(3));
                auxInventario.setCalefaccion(rs.getString(4));
                auxInventario.setAmoblado(rs.getString(5));
                
                auxLista.add(auxInventario);
            }

            rs.close();
            conexionOracle.desconexion();

        } catch (Exception ex) {

        }

        return auxLista;
    }
}
