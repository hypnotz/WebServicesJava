/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import DTO.Departamento;
import DTO.ListaDepto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author hypnotz
 */
public class NegocioDepartamento {
    
        public void insertarDepto(Departamento departamento){
            
         ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();
        
        
        CallableStatement callableStatement = null;
        
        try {
          
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            conn.setAutoCommit(true);
            String sql = "{call SP_INSERT_DPTO_IMG2(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString("v_DIRECCION", departamento.getDireccion());
            callableStatement.setInt("v_CANTIDAD_PIEZAS", departamento.getCantidadPiezas());
            callableStatement.setInt("v_CANTIDAD_BAÑOS", departamento.getCantidadBanos());
            callableStatement.setString("v_CONDICIONES", departamento.getCondiciones());
            callableStatement.setInt("v_ID_TIPO_ESTADO", departamento.getIdTipoEstado());
            callableStatement.setInt("v_ID_COMUNA", departamento.getIdComuna());
            callableStatement.setInt("v_ID_TARIFA", departamento.getIdTarifa());
            callableStatement.setString("V_PATH", departamento.getPath());
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }
        
        public void eliminarDepto(int idDepto){
          ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();
        
        
        CallableStatement callableStatement = null;
        
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            conn.setAutoCommit(false);
            String sql = "{call SP_EliminarDepartamento(?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("idDepto",idDepto);
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }
        
        public void actualizarDepto(Departamento  departamento){
        
          ConexionOracle conexionOracle = new ConexionOracle();
         Connection conn = conexionOracle.getConnection();  
        
        
        CallableStatement callableStatement = null;
       
        try {
             
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            
            conn.setAutoCommit(false);
            String sql = "{call SP_ModificarDepartamento(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("v_ID_DEPARTAMENTO", departamento.getIdDepto());
            callableStatement.setString("v_DIRECCION", departamento.getDireccion());
            callableStatement.setInt("v_CANTIDAD_PIEZAS", departamento.getCantidadPiezas());
            callableStatement.setInt("v_CANTIDAD_BAÑOS", departamento.getCantidadBanos());
            callableStatement.setString("v_CONDICIONES", departamento.getCondiciones());
            callableStatement.setInt("v_ID_TIPO_ESTADO", departamento.getIdTipoEstado());
            callableStatement.setInt("v_ID_COMUNA", departamento.getIdComuna());
            callableStatement.setInt("v_ID_TARIFA", departamento.getIdTarifa());
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
     }
        }      

       public ArrayList<ListaDepto> listarDepto(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ListaDepto auxDepartamento = new ListaDepto();
        ArrayList<ListaDepto> auxLista = new ArrayList<ListaDepto>();

        try {
            String sql = "{call SP_LISTAR_DEPTO(?,?,?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(9, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(10, java.sql.Types.BLOB);
            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxDepartamento = new ListaDepto();
                auxDepartamento.setIdDepartamento(rs.getInt(1));
                auxDepartamento.setDireccion(rs.getString(2));
                auxDepartamento.setCantidadPiezas(rs.getInt(3));
                auxDepartamento.setCantidadBanos(rs.getInt(4));
                auxDepartamento.setCondiciones(rs.getString(5));
                auxDepartamento.setTipoEstado(rs.getString(6));
                auxDepartamento.setComuna(rs.getString(7));
                auxDepartamento.setTarifa(rs.getInt(8));

                if (rs.getBlob(9) == null){

                }else {
                    int blobLength = (int) rs.getBlob(9).length();
                    byte[] blobAsByte = rs.getBlob(9).getBytes(1, blobLength);
                    auxDepartamento.setImage(blobAsByte);
                }

                auxLista.add(auxDepartamento);
            }
            rs.close();
            conexionOracle.desconexion();

        } catch (Exception ex) {

        }
        return auxLista;
    }
        
      @WebMethod(operationName = "cancelarReservax")
     public void cancelarReservax(@WebParam(name = "idReserva") int idReserva){
          NegocioReserva auxNegocio = new NegocioReserva();
         
         auxNegocio.cancelarReserva(idReserva);
     }

}

