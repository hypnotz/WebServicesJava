/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.ReporteGanancia;
import DTO.ReporteMensualReservas;
import DTO.ReporteZona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author hypnotz
 */
public class NegocioReporteM {
    public ArrayList<ReporteMensualReservas> reporteMensualReservas(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ReporteMensualReservas auxReserva = new ReporteMensualReservas();
        ArrayList<ReporteMensualReservas> auxLista = new ArrayList<ReporteMensualReservas>();

            try {

            String sql = "{call SP_REPORTE_MENSUAL(?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);

            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxReserva = new ReporteMensualReservas();
                auxReserva.setMes(rs.getString(1));
                auxReserva.setArriendos(rs.getInt(2));

                auxLista.add(auxReserva);
            }
            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
               
            }
            return auxLista;
    }
    
    public ArrayList<ReporteGanancia> reporteGanancia(int ano){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ReporteGanancia auxReserva = new ReporteGanancia();
        ArrayList<ReporteGanancia> auxLista = new ArrayList<ReporteGanancia>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {

            String sql = "{call SP_GANANCIA_MENSUAL_ANUAL(?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC);
            callableStatement.setInt(5, ano);

            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);


            while (rs.next()){
                auxReserva = new ReporteGanancia();
                auxReserva.setIdDepto(rs.getInt(1));
                auxReserva.setDireccion(rs.getString(2));
                auxReserva.setGanancia(rs.getInt(3));

                auxLista.add(auxReserva);
            }
            rs.close();
            conexionOracle.desconexion();
            } catch (Exception ex) {
                
            }
            return auxLista;

    }
    public ArrayList<ReporteGanancia> reporteGananciaMensual(int mes, int ano){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ReporteGanancia auxReserva = new ReporteGanancia();
        ArrayList<ReporteGanancia> auxLista = new ArrayList<ReporteGanancia>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {

            String sql = "{call SP_GANANCIA_MENSUAL(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC);
            callableStatement.setInt(5, mes);
            callableStatement.setInt(6, ano);



            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);



            while (rs.next()){
                auxReserva = new ReporteGanancia();
                auxReserva.setIdDepto(rs.getInt(1));
                auxReserva.setDireccion(rs.getString(2));
                auxReserva.setGanancia(rs.getInt(3));

                auxLista.add(auxReserva);
            }


            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
              
            }

            return auxLista;

    }
    
    public ArrayList<ReporteGanancia> reporteGananciaDiaria(int dia,int mes, int ano){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ReporteGanancia auxReserva = new ReporteGanancia();
        ArrayList<ReporteGanancia> auxLista = new ArrayList<ReporteGanancia>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {

            String sql = "{call SP_GANANCIA_DIARIA(?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC);
            callableStatement.setInt(5, dia);
            callableStatement.setInt(6, mes);
            callableStatement.setInt(7, ano);

            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxReserva = new ReporteGanancia();
                auxReserva.setIdDepto(rs.getInt(1));
                auxReserva.setDireccion(rs.getString(2));
                auxReserva.setGanancia(rs.getInt(3));

                auxLista.add(auxReserva);
            }
            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
               
            }
            return auxLista;
    }
    public ArrayList<ReporteZona> reporteGananciaAnualZona(int ano){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ReporteZona auxReserva = new ReporteZona();
        ArrayList<ReporteZona> auxLista = new ArrayList<ReporteZona>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {

            String sql = "{call SP_GANANCIA_ANUAL_ZONA(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
            callableStatement.setInt(4, ano);

            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);



            while (rs.next()){
                auxReserva = new ReporteZona();
                auxReserva.setRegion(rs.getString(1));
                auxReserva.setGanancia(rs.getInt(2));


                auxLista.add(auxReserva);
            }


            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
               
            }

            return auxLista;

    }

    public ArrayList<ReporteZona> reporteGananciaMensualZona(int mes,int ano){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ReporteZona auxReserva = new ReporteZona();
        ArrayList<ReporteZona> auxLista = new ArrayList<ReporteZona>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {

            String sql = "{call SP_GANANCIA_MENSUAL_ZONA(?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
            callableStatement.setInt(4, mes);
            callableStatement.setInt(5, ano);

            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);



            while (rs.next()){
                auxReserva = new ReporteZona();
                auxReserva.setRegion(rs.getString(1));
                auxReserva.setGanancia(rs.getInt(2));


                auxLista.add(auxReserva);
            }
            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
                
            }

            return auxLista;

    }
    public ArrayList<ReporteZona> reporteGananciaDiariaZona(int dia,int mes, int ano){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ReporteZona auxReserva = new ReporteZona();
        ArrayList<ReporteZona> auxLista = new ArrayList<ReporteZona>();
             //int year = Calendar.getInstance().get(Calendar.YEAR);
            try {

            String sql = "{call SP_GANANCIA_DIARIA_ZONA(?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC);
            callableStatement.setInt(5, dia);
            callableStatement.setInt(6, mes);
            callableStatement.setInt(7, ano);



            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);



            while (rs.next()){
                auxReserva = new ReporteZona();
                auxReserva.setRegion(rs.getString(1));
                auxReserva.setGanancia(rs.getInt(2));
                

                auxLista.add(auxReserva);
            }


            rs.close();
            conexionOracle.desconexion();

            } catch (Exception ex) {
                
            }

            return auxLista;

    }
    
}


    
    
