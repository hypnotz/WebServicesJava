package Negocio;

import Conexion.ConexionOracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DTO.*;
import java.io.Console;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;


public class NegocioReserva {

     public void insertReserva(ReservaDto reserva){

        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {

            String sql = "{call SP_CREAR_RESERVA(?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, reserva.getFechaInicio());
            callableStatement.setString(2, reserva.getFechaFin());
            callableStatement.setInt(3, reserva.getPago());
            callableStatement.setInt(4, reserva.getIdDpto());
            callableStatement.setInt(5, reserva.getIdCliente());
            callableStatement.executeQuery();
            conexionOracle.desconexion();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }

     public int cancelarReserva(int idReserva){
        int resp =0;
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {
            String sql = "{call SP_CANCELAR_RESERVA(?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, idReserva);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.executeQuery();

            resp = callableStatement.getInt(2);

            conexionOracle.desconexion();
            return resp;

        }catch(Exception ex){
            
            return -1;
        }
    }
     
     public ArrayList<Reserva> listarReservas(String id_depto){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        Reserva auxReserva = new Reserva();
        ArrayList<Reserva> auxLista = new ArrayList<Reserva>();
        
        if(id_depto == "")
        {
            try {
            
            String sql = "{call SP_LISTAR_ALL_RESERVAS_ACTIVAS(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(8, java.sql.Types.INTEGER);
            
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            
            while (rs.next()){
                auxReserva = new Reserva();
                auxReserva.setId_reserva(rs.getInt(1));
                auxReserva.setFecha(rs.getString(2));
                auxReserva.setFecha_inicio(rs.getString(3));
                auxReserva.setFecha_fin(rs.getString(4));
                auxReserva.setPago(rs.getInt(5));
                auxReserva.setId_departamento(rs.getInt(6));
                auxReserva.setId_cliente(rs.getInt(7));
                
                auxLista.add(auxReserva);
            }
            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return auxLista;
        }
    //----------------------------------------------------------    
        else
        {
            try {
            String sql = "{call SP_LISTAR_ALL_RESERVAS_ACTIVAS(?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(8, java.sql.Types.INTEGER);
            callableStatement.setString(9, id_depto);
            
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            
            /*char cable =rs.getString(2).charAt(0);
            char internet =rs.getString(3).charAt(0);
            char calefaccion =rs.getString(4).charAt(0);
            char amoblado =rs.getString(5).charAt(0);*/
            
            while (rs.next()){
                auxReserva = new Reserva();
                auxReserva.setId_reserva(rs.getInt(1));
                auxReserva.setFecha(rs.getString(2));
                auxReserva.setFecha_inicio(rs.getString(3));
                auxReserva.setFecha_fin(rs.getString(4));
                auxReserva.setPago(rs.getInt(5));
                auxReserva.setId_departamento(rs.getInt(6));
                auxReserva.setId_cliente(rs.getInt(7));
                auxLista.add(auxReserva);
            }
            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return auxLista;
        }
    }
     
     public ArrayList<Reserva> listarReservasSinCheckOut(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        Reserva auxReserva = new Reserva();
        ArrayList<Reserva> auxLista = new ArrayList<Reserva>();
        
        
        
            try {
            
            String sql = "{call SP_LIST_RESERVAS_SIN_CHECK_OUT(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(8, java.sql.Types.INTEGER);
            
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            
            
            
            while (rs.next()){
                auxReserva = new Reserva();
                auxReserva.setId_reserva(rs.getInt(1));
                auxReserva.setFecha(rs.getString(2));
                auxReserva.setFecha_inicio(rs.getString(3));
                auxReserva.setFecha_fin(rs.getString(4));
                auxReserva.setPago(rs.getInt(5));
                auxReserva.setId_departamento(rs.getInt(6));
                auxReserva.setId_cliente(rs.getInt(7));
                
                              
                auxLista.add(auxReserva);
            }


            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        
            return auxLista;      
        
    }
     public ArrayList<ReservaDto> listarReserva(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;

        ReservaDto auxReserva = new ReservaDto();

        ArrayList<ReservaDto> auxLista = new ArrayList<ReservaDto>();

        try {
            String sql = "{call SP_LISTAR_RESERVAS(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxReserva = new ReservaDto();
                auxReserva.setIdReserva(rs.getInt(1));
                auxReserva.setIdDpto(rs.getInt(2));
                auxReserva.setIdCliente(rs.getInt(3));
                auxReserva.setPago(rs.getInt(4));
                auxReserva.setFechaInicio(rs.getString(5));
                auxReserva.setFecha(rs.getString(6));
                auxReserva.setFechaFin(rs.getString(7));
                auxLista.add(auxReserva);
            }
            rs.close();
            conexionOracle.desconexion();
        } catch (Exception ex) {

        }
        return auxLista;
    }
     public ArrayList<ServicioReservaList> GetTurismoByReserva(int idReserva){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ServicioReservaList auxReserva = new ServicioReservaList();
        ArrayList<ServicioReservaList> auxLista = new ArrayList<ServicioReservaList>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {
            String sql = "{call SP_TURISMO_BY_RESERVA(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.setInt(4, idReserva);

            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxReserva = new ServicioReservaList();
                auxReserva.setDescripcion(rs.getString(1));
                auxReserva.setFecha(rs.getString(2));

                auxLista.add(auxReserva);
            }

            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
                
            }
            return auxLista;

    }
     
     public ArrayList<ServicioReservaList> GetTransporteByReserva(int idReserva){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ServicioReservaList auxReserva = new ServicioReservaList();
        ArrayList<ServicioReservaList> auxLista = new ArrayList<ServicioReservaList>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {

            String sql = "{call SP_TRANSPORTE_BY_RESERVA(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.setInt(4, idReserva);


            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);



            while (rs.next()){
                auxReserva = new ServicioReservaList();
                auxReserva.setDescripcion(rs.getString(1));
                auxReserva.setFecha(rs.getString(2));


                auxLista.add(auxReserva);
            }
            rs.close();
            conexionOracle.desconexion();
            } catch (Exception ex) {
                
            }
            return auxLista;

    }
     public ArrayList<AcompanianteReserva> GetAcompaniantesByReserva(int idReserva){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        AcompanianteReserva auxReserva = new AcompanianteReserva();
        ArrayList<AcompanianteReserva> auxLista = new ArrayList<AcompanianteReserva>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {

            String sql = "{call SP_ACOMPANIANTES_BY_RESERVA(?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.setInt(3, idReserva);


            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);



            while (rs.next()){
                auxReserva = new AcompanianteReserva();
                auxReserva.setNombre(rs.getString(1));



                auxLista.add(auxReserva);
            }


            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {

            }

            return auxLista;

    }
     
     public ArrayList<String> validarFechaReserva(int idDepto,String fecha_inicio, String fecha_fin){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
       
        ArrayList<String> auxLista = new ArrayList<String>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {

            String sql = "{call SP_VALIDAR_FECHA_RESERVA(?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.setInt(1, idDepto);
            callableStatement.setString(2, fecha_inicio);
            callableStatement.setString(3, fecha_fin);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);



            callableStatement.executeQuery();
            String ini;
            String fin;
            ini = callableStatement.getString(4);
            fin = callableStatement.getString(5);



            //while (rs.next()){
                //auxReserva = new AcompanianteReserva();
                //auxReserva.setNombre(rs.getString(1));



                auxLista.add(ini);
                auxLista.add(fin);
            //}


            //rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            return auxLista;

    }
}
