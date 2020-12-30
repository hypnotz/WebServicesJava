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
 * @author JorgeAndres
 */
public class NegocioServicioTransporte {

    
    public void insertarServicioTransporte(ServicioTransporte servicioTransporte){
        
        CallableStatement callableStatement = null;
         ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        
        try {
           
            
            conn.setAutoCommit(false);
            String sql = "{call SP_AgregarServicioTransporte(?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("v_ID_TRANSPORTE", servicioTransporte.getIdTransporte());
            callableStatement.setInt("ID_SERVICIO_TRANSPORTE_SEQ.nextval", servicioTransporte.getIdServicioTransporte());
            callableStatement.setString("v_PATENTE", servicioTransporte.getPatente());
            callableStatement.setString("v_CHOFER", servicioTransporte.getChofer());
            callableStatement.setString("v_DIRECCION", servicioTransporte.getDireccion());
            callableStatement.setString("v_HORARIO", servicioTransporte.getHorario());
            callableStatement.setInt("v_ID_DISPONIBILIDAD", servicioTransporte.getIdDisponibilidad());
            callableStatement.setInt("v_ID_RESERVA", servicioTransporte.getIdDisponibilidad());
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   }
    
   public void planificarServicioTransporte(ServicioTransporte servicioTransporte){
        CallableStatement callableStatement = null;
         ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        try {
            
            conn.setAutoCommit(false);
            String sql = "{call SP_PlanificarTransporte(?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("v_ID_TRANSPORTE", servicioTransporte.getIdTransporte());
            callableStatement.setInt("ID_SERVICIO_TRANSPORTE_SEQ.nextval", servicioTransporte.getIdServicioTransporte());
            callableStatement.setString("v_PATENTE", servicioTransporte.getPatente());
            callableStatement.setString("v_CHOFER", servicioTransporte.getChofer());
            callableStatement.setString("v_DIRECCION", servicioTransporte.getDireccion());
            callableStatement.setString("v_HORARIO", servicioTransporte.getHorario());
            callableStatement.setInt("v_ID_DISPONIBILIDAD", servicioTransporte.getIdDisponibilidad());
            callableStatement.setInt("v_ID_RESERVA", servicioTransporte.getIdDisponibilidad());
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
   }    
    
    public static ArrayList<String> listaTransporte(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        ArrayList<String> lista = new ArrayList<String>();
        CallableStatement callableStatement = null;
        Transporte auxTransporte = new Transporte();
        
        
        try {
            

            conn.setAutoCommit(false);
            String sql = "{call SP_LISTAR_TRANSPORTE(?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.setInt("ID_TRANSPORTE_OUT", auxTransporte.getIdTransporte());
            callableStatement.registerOutParameter(3, java.sql.Types.NUMERIC);
            callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC);
            callableStatement.registerOutParameter(5, java.sql.Types.NUMERIC);
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            
            while (rs.next()){
                Transporte transporte = new Transporte();
                transporte.setIdTransporte(rs.getInt(2));
                lista.add(rs.getString("idDisponibilidad"));
            }
            rs.close();
            conexionOracle.desconexion();
            callableStatement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    public void insertServicioTransporte(ServicioTransporteDto transporte){

        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {

            String sql = "{call SP_INSERT_SERVICIO_TRANSPORTE(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, transporte.getIdTransporte());
            callableStatement.setString(2, transporte.getDireccion());
            callableStatement.setString(3, transporte.getHorario());
            callableStatement.setInt(4, transporte.getIdReserva());
            callableStatement.executeQuery();
            conexionOracle.desconexion();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}