/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

/**
 *
 * @author hypnotz
 */
public class NegocioLogin {
    
    public String iniciarSesion(String user, String pass){
        String resp = "";
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {
            String sql = "{call SP_INICIAR_SESION(?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, user);
            callableStatement.setString(2, pass);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.executeQuery();

            resp = callableStatement.getString(3);

            if(resp != "")
            {
                conexionOracle.desconexion();
                return resp;
            }
            else
            {
                conexionOracle.desconexion();
                return resp;
                
            }
        }catch(Exception ex){
            return resp;
        }
    }
    
    
    public int traerIdByNombre(String user){
        int resp = 0;
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {
            String sql = "{call SP_GetIdByUserName(?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, user);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.executeQuery();

            resp = callableStatement.getInt(2);

            return resp;
        }catch(Exception ex){
            return resp;
        }
    }
    
    public String obtenerCorreoByID(int idUser){
        String resp = "";
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {
            String sql = "{call SP_GetCorreoID(?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, idUser);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.executeQuery();

            resp = callableStatement.getString(2);

            return resp;
        }catch(Exception ex){
            return resp;
        }
    }

       public int calcularPago(int idDepto, String fecha_ini, String fecha_fin){
        int resp =0;
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;


        try {
            String sql = "{call SP_CALCULAR_PAGO_TARIFA(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, idDepto);
            callableStatement.setString(2, fecha_ini);
            callableStatement.setString(3, fecha_fin);
            callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
            callableStatement.executeQuery();

            resp = callableStatement.getInt(4);

            conexionOracle.desconexion();
            return resp;

        }catch(Exception ex){

            return 0;
        }
        
       }
        
        public int traeridEstadoByIDuSer(int idEstado){
        int resp = 0;
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {
            String sql = "{call SP_CONSULTAR_ESTCUENTA(?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, idEstado);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.executeQuery();

            resp = callableStatement.getInt(2);

            return resp;
        }catch(Exception ex){
            return resp;
        }
    }
        
        public Boolean validarUsernameExists(String user){
        String resp ="";
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;


        try {
            String sql = "{call SP_VALIDAR_USERNAME_EXISTS(?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, user);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.executeQuery();

            resp = callableStatement.getString(2);

            if(resp == null)
            {
                return true;
            }
            else{return false;}


        }catch(Exception ex){
           
            return false;
        }

    }
}
