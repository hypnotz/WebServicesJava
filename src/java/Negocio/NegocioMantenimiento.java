/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.MantenimientoDto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author hypnotz
 */
public class NegocioMantenimiento {
    
    
    public ArrayList<MantenimientoDto> getMantenimiento(){

        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        MantenimientoDto auxMantenimiento = null;
        ArrayList<MantenimientoDto> lista = new ArrayList<MantenimientoDto>();

        try {

            String sql = "{call SP_GET_MANTENIMIENTO(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);

            callableStatement.executeQuery();
            ResultSet rs  = (ResultSet) callableStatement.getObject(1);
            while (rs.next()){
                auxMantenimiento = new MantenimientoDto();
                auxMantenimiento.setIdMantenimiento(rs.getInt(1));
                auxMantenimiento.setDescripcion(rs.getString(2));
                auxMantenimiento.setTotal(Integer.parseInt( rs.getString(3)));
                auxMantenimiento.setIdDepartamento(Integer.parseInt( rs.getString(4)));
                auxMantenimiento.setFecha(rs.getString(5));
                lista.add(auxMantenimiento);

            }
            conexionOracle.desconexion();

        }catch(Exception ex){
            System.out.println(ex);
        }

        return lista;

    }
    
    public MantenimientoDto getMantenimientoById(int id){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        MantenimientoDto auxMantenimiento = new MantenimientoDto();
        
        try {
            
            String sql = "{call GET_MANTENIMIENTO_BY_ID(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.setInt(2, id);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);

            callableStatement.executeQuery();
            ResultSet rs  = (ResultSet) callableStatement.getObject(1);
            while (rs.next()){
                
                auxMantenimiento.setDescripcion(rs.getString(1));
                auxMantenimiento.setTotal(Integer.parseInt( rs.getString(2)));
                auxMantenimiento.setIdDepartamento(Integer.parseInt( rs.getString(3)));
                auxMantenimiento.setFecha(rs.getString(4));

            }
            conexionOracle.desconexion();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        return auxMantenimiento;
        
    }    
    
    public void insertMantenimiento(MantenimientoDto mantenimiento){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        MantenimientoDto auxMantenimiento = new MantenimientoDto();
        
        try {
            
            String sql = "{call SP_INSERT_MANTENIMIENTO(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, mantenimiento.getDescripcion());
            callableStatement.setInt(2, mantenimiento.getTotal());
            callableStatement.setInt(3, mantenimiento.getIdDepartamento());
            callableStatement.setString(4, mantenimiento.getFecha());
            callableStatement.executeQuery();
            conexionOracle.desconexion();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
                
    }    
    
    
        public void updateMantenimiento(MantenimientoDto mantenimiento){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        MantenimientoDto auxMantenimiento = new MantenimientoDto();
        
        try {
            
            String sql = "{call UPDATE_MANTENIMIENTO(?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, mantenimiento.getIdMantenimiento());
            callableStatement.setString(2, mantenimiento.getDescripcion());
            callableStatement.setInt(3, mantenimiento.getTotal());
            callableStatement.setInt(4, mantenimiento.getIdDepartamento());
            callableStatement.setString(5, mantenimiento.getFecha());
            callableStatement.executeQuery();
            conexionOracle.desconexion();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
                
    }    

     public void deleteMantenimiento(int id){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        MantenimientoDto auxMantenimiento = new MantenimientoDto();
        
        try {
            
            String sql = "{call SP_DELETE_MANTENIMIENTO(?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, id);
            callableStatement.executeQuery();
            conexionOracle.desconexion();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }    
}
