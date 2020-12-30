/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.ListaTurismo;
import DTO.Turismo;
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
public class NegocioTurismo {
    
    public void IngresarTurismo(Turismo turismo)
    {
       ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();


            CallableStatement callableStatement = null;

            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conn.setAutoCommit(true);
                String sql = "{call SP_AgregarTurismo(?,?,?,?)}";
                callableStatement = conn.prepareCall(sql);
                callableStatement.setString("V_DESCRIPCION",turismo.getDescripcion());
                callableStatement.setInt("V_PRECIO",turismo.getPrecio());
                callableStatement.setInt("V_ID_DISPONIBILIDAD",turismo.getIdDisponibilidad());
                callableStatement.setString("V_FECHA",turismo.getFecha());
                callableStatement.executeQuery();
                callableStatement.close();
                conn.close();
                } catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }
    }
    
    
    public void modificarTurismo(Turismo turismo)
    {
       ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();


            CallableStatement callableStatement = null;

            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conn.setAutoCommit(true);
                String sql = "{call SP_ModificarTurismo(?,?,?,?,?)}";
                callableStatement = conn.prepareCall(sql);
                callableStatement.setInt("V_ID_TURISMO",turismo.getIdTurismo());
                callableStatement.setString("V_DESCRIPCION",turismo.getDescripcion());
                callableStatement.setInt("V_PRECIO",turismo.getPrecio());
                callableStatement.setInt("V_ID_DISPONIBILIDAD",turismo.getIdDisponibilidad());
                callableStatement.setString("V_FECHA",turismo.getFecha());
                callableStatement.executeQuery();
                callableStatement.close();
                conn.close();
                } catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }

    }
    
    public void eliminarTurismo(int idTurismo)
    {
       ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();


            CallableStatement callableStatement = null;

            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conn.setAutoCommit(true);
                String sql = "{call SP_EliminarTurismo(?)}";
                callableStatement = conn.prepareCall(sql);
                callableStatement.setInt("V_ID_TURISMO",idTurismo);
                callableStatement.executeQuery();
                callableStatement.close();
                conn.close();
                } catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }
    }
    
    public ArrayList<ListaTurismo> listarTurismo(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ListaTurismo auxTurismo = new ListaTurismo();
        ArrayList<ListaTurismo> auxLista = new ArrayList<ListaTurismo>();

        try {
            String sql = "{call SP_LISTAR_Turismo(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);

            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxTurismo = new ListaTurismo();
                auxTurismo.setIdTurismo(rs.getInt(1));
                auxTurismo.setDescripcion(rs.getString(2));
                auxTurismo.setPrecio(rs.getInt(3));
                auxTurismo.setDisponibilidad(rs.getString(4));
                auxTurismo.setFecha(rs.getString(5));
                auxLista.add(auxTurismo);
            }
            rs.close();
            conexionOracle.desconexion();

        } catch (Exception ex) {
        }
        return auxLista;
    }
}
