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
import java.sql.DriverManager;

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
        
        public ArrayList<Cliente_Usuario> traerSoloCliente(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        Cliente_Usuario auxClienteUsuario = new Cliente_Usuario();
        ArrayList<Cliente_Usuario> auxListaClienteUsuario = new ArrayList<Cliente_Usuario>();

        try {
            String sql = "{call SP_TRAER_CLIENTEUSUARIO(?,?,?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(11, java.sql.Types.INTEGER);
            
            callableStatement.executeQuery();
            
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxClienteUsuario = new Cliente_Usuario();
                auxClienteUsuario.setIdUsuario(rs.getInt(1));
                auxClienteUsuario.setNombreUsuario(rs.getString(2));
                auxClienteUsuario.setRut(rs.getString(3));
                auxClienteUsuario.setNombres(rs.getString(4));
                auxClienteUsuario.setApellidoPaterno(rs.getString(5));
                auxClienteUsuario.setApellidoMaterno(rs.getString(6));
                auxClienteUsuario.setCorreo(rs.getString(7));
                auxClienteUsuario.setFechaNacimiento(rs.getString(8));
                auxClienteUsuario.setTelefono(rs.getInt(9));
                auxClienteUsuario.setIdPrivilegio(rs.getInt(10));
               auxListaClienteUsuario.add(auxClienteUsuario);
            }
            rs.close();
            conexionOracle.desconexion();
        } catch (Exception ex) {
        }
        return auxListaClienteUsuario;
    }
        
        public ClienteDto getUserById(int id){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ClienteDto auxCliente = new ClienteDto();
        
        try {
            String sql = "{call GET_USER_BY_ID(?,?,?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(9, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(10, java.sql.Types.VARCHAR);
            callableStatement.setInt(11, id);
            callableStatement.executeQuery();
            ResultSet rs  = (ResultSet) callableStatement.getObject(1);
            while (rs.next()){
                auxCliente.setNombreUsuario(rs.getString(1));
                auxCliente.setRut(rs.getString(2));
                auxCliente.setNombres(rs.getString(3));
                auxCliente.setApellidoPaterno(rs.getString(4));
                auxCliente.setApellidoMaterno(rs.getString(5));
                auxCliente.setCorreo(rs.getString(6));
                auxCliente.setFechaNacimiento(rs.getString(7));
                auxCliente.setTelefono(rs.getInt(8));
                auxCliente.setPrivilegio(rs.getString(9));
            }
            conexionOracle.desconexion();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return auxCliente;
    }
        public ArrayList<Cliente_Usuario> traerClienteDeshabilitado(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        Cliente_Usuario auxClienteUsuario = new Cliente_Usuario();
        ArrayList<Cliente_Usuario> auxListaClienteUsuario = new ArrayList<Cliente_Usuario>();

        try {
            String sql = "{call SP_TRAER_CLIENTEUSUARIO_Des(?,?,?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(11, java.sql.Types.INTEGER);
            
            callableStatement.executeQuery();
            
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxClienteUsuario = new Cliente_Usuario();
                auxClienteUsuario.setIdUsuario(rs.getInt(1));
                auxClienteUsuario.setNombreUsuario(rs.getString(2));
                auxClienteUsuario.setRut(rs.getString(3));
                auxClienteUsuario.setNombres(rs.getString(4));
                auxClienteUsuario.setApellidoPaterno(rs.getString(5));
                auxClienteUsuario.setApellidoMaterno(rs.getString(6));
                auxClienteUsuario.setCorreo(rs.getString(7));
                auxClienteUsuario.setFechaNacimiento(rs.getString(8));
                auxClienteUsuario.setTelefono(rs.getInt(9));
                auxClienteUsuario.setIdPrivilegio(rs.getInt(10));
               auxListaClienteUsuario.add(auxClienteUsuario);
            }
            rs.close();
            conexionOracle.desconexion();
        } catch (Exception ex) {
        }
        return auxListaClienteUsuario;
    }
        
     public Cliente_Usuario getUserByRut(String rut){
        
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;
         Cliente_Usuario auxCliente = new Cliente_Usuario();
        try {
            String sql = "{call SP_TRAER_CLIENTEUSUARIO_Rut(?,?,?,?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(11, java.sql.Types.INTEGER);
            callableStatement.setString(12, rut);

            callableStatement.executeQuery();
            ResultSet rs  = (ResultSet) callableStatement.getObject(1);
            while (rs.next()){
                auxCliente.setIdUsuario(rs.getInt(1));
                auxCliente.setNombreUsuario(rs.getString(2));
                auxCliente.setRut(rs.getString(3));
                auxCliente.setNombres(rs.getString(4));
                auxCliente.setApellidoPaterno(rs.getString(5));
                auxCliente.setApellidoMaterno(rs.getString(6));
                auxCliente.setCorreo(rs.getString(7));
                auxCliente.setFechaNacimiento(rs.getString(8));
                auxCliente.setTelefono(rs.getInt(9));
                auxCliente.setIdPrivilegio(rs.getInt(10));
            }
            conexionOracle.desconexion();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        return auxCliente;
    } 
     
     public void updateUsuarioCliente(ClienteDto clientex){

       ConexionOracle conexionOracle = new ConexionOracle();
       Connection conn = ConexionOracle.getConnection();
       CallableStatement callableStatement = null;
     
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn.setAutoCommit(true);
            String sql = "{call SP_UPDATE_CLIENTE_USUARIO(?,?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString("V_RUT", clientex.getRut());
            callableStatement.setString("V_NOMBRES", clientex.getNombres());
            callableStatement.setString("V_APELLIDO_PATERNO", clientex.getApellidoPaterno());
            callableStatement.setString("V_APELLIDO_MATERNO", clientex.getApellidoMaterno());
            callableStatement.setString("V_CORREO", clientex.getCorreo());
            callableStatement.setString("V_FECHA_NACIMIENTO", clientex.getFechaNacimiento());
            callableStatement.setInt("V_TELEFONO", clientex.getTelefono());
            callableStatement.setString("V_NOMBRE_USUARIO", clientex.getNombreUsuario());
            callableStatement.setString("V_CONTRASENA", clientex.getContrasena());
            callableStatement.setInt("V_ID_USUARIO", clientex.getIdUsuario());
            callableStatement.executeQuery();
            conexionOracle.desconexion();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
