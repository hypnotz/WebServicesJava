/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.Comuna;
import DTO.DisponibilidadServicio;
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
public class NegocioDisponibilidadServicio {
    

        
    public static ArrayList<DisponibilidadServicio > listaDisponibilidadServicio(){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        
        ArrayList<DisponibilidadServicio > lista = new ArrayList<DisponibilidadServicio >();
        CallableStatement callableStatement = null;
        DisponibilidadServicio auxDisponibilidadServicio = new DisponibilidadServicio();
        try {
            conn.setAutoCommit(true);
            String sql = "{call SP_LISTAR_DISPO_SERVICIO(?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3,java.sql.Types.VARCHAR);
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            
            while (rs.next()){
                DisponibilidadServicio auxDisponibilidad = new DisponibilidadServicio();
                auxDisponibilidad.setIdDisponibilidad(rs.getInt(1));
                auxDisponibilidad.setDescripcion(rs.getString(2));
                lista.add(auxDisponibilidad);
            }
            rs.close();
            conexionOracle.desconexion();
            callableStatement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    
    
    public ArrayList<Comuna> getComuna(){

        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        Comuna auxComuna = new Comuna();
        ArrayList<Comuna> auxLista = new ArrayList<Comuna>();

        try {
            String sql = "{call SP_GET_PROVINCIA(?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxComuna = new Comuna();
                auxComuna.setIdComuna(rs.getInt(1));
                auxComuna.setNombreComuna(rs.getString(2));
                //System.out.println(rs.getString(1));
                //System.out.println(rs.getString(2));
                auxLista.add(auxComuna);
            }


            rs.close();
            conexionOracle.desconexion();

        } catch (Exception ex) {

        }

        return auxLista;


    }
}


