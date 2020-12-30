/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import DTO.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author hypnotz
 */
public class NegocioTransporte {
    
    public void IngresarTransporte(Transporte transporte)
    {
       ConexionOracle conexionOracle = new ConexionOracle();
       Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conn.setAutoCommit(true);
                String sql = "{call SP_AgregarTransporte(?,?,?,?)}";
                callableStatement = conn.prepareCall(sql);
                callableStatement.setInt("V_PRECIO",transporte.getPrecio());
                callableStatement.setInt("V_ID_DISPONIBILIDAD",transporte.getIdDisponibilidad());
                callableStatement.setInt("V_CAPACIDAD",transporte.getCapacidad());
                 callableStatement.setString("V_DESCRIPCION",transporte.getDescripcion());
                callableStatement.executeQuery();
                callableStatement.close();
                conn.close();
                } catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }
    }
    
    
    public void modificarTransporte(Transporte transporte)
    {
       ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();

            CallableStatement callableStatement = null;

            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conn.setAutoCommit(true);
                String sql = "{call SP_ModificarTransporte(?,?,?,?,?)}";
                callableStatement = conn.prepareCall(sql);
                callableStatement.setInt("V_ID_TRANSPORTE",transporte.getIdTransporte());
                callableStatement.setInt("V_PRECIO",transporte.getPrecio());
                callableStatement.setInt("V_ID_DISPONIBILIDAD",transporte.getIdDisponibilidad());
                callableStatement.setInt("V_CAPACIDAD",transporte.getCapacidad());
                callableStatement.setString("V_DESCRIPCION",transporte.getDescripcion());
                callableStatement.executeQuery();
                callableStatement.close();
                conn.close();
                } catch (Exception ex) 
                    {
                        ex.printStackTrace();
        }
    }
    public void eliminarTransporte(int idTransporte)
    {
       ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();
            CallableStatement callableStatement = null;
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conn.setAutoCommit(true);
                String sql = "{call SP_EliminarTransporte(?)}";
                callableStatement = conn.prepareCall(sql);
                callableStatement.setInt("V_ID_TRANSPORTE",idTransporte);
                callableStatement.executeQuery();
                callableStatement.close();
                conn.close();
                } catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }
    }
    public ArrayList<ListaTransporte> listarTransporte(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ListaTransporte auxDepartamento = new ListaTransporte();
        ArrayList<ListaTransporte> auxLista = new ArrayList<ListaTransporte>();

        try {
            String sql = "{call SP_LISTAR_Transporte(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);


            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxDepartamento = new ListaTransporte();
                auxDepartamento.setIdTransporte(rs.getInt(1));
                auxDepartamento.setPrecio(rs.getInt(2));
                auxDepartamento.setDisponibilidad(rs.getString(3));
                auxDepartamento.setCapacidad(rs.getInt(4));
               auxDepartamento.setDescripcion(rs.getString(5));
                auxLista.add(auxDepartamento);
            }
            rs.close();
            conexionOracle.desconexion();
        } catch (Exception ex) {
        }
        return auxLista;
    }
    
}
