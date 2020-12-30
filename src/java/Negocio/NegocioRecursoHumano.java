/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author hypnotz
 */
public class NegocioRecursoHumano {
    
    
      public int traerIdByIdUser(String user){
        int resp = 0;
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = ConexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {
            String sql = "{call SP_GetIdByUserNameRecurso(?,?)}";
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
}
