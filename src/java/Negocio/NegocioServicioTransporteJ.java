package Negocio;

import Conexion.ConexionOracle;
import DTO.ServicioTransporte;
import DTO.ServicioTransporteJ;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

public class NegocioServicioTransporteJ {

    public void planificarTransporte(ServicioTransporteJ servicioTransporte){

        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn.setAutoCommit(true);
            String sql = "{call SP_PlanificarTransporte(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("V_ID_TRANSPORTE", servicioTransporte.getIdTransporte());
            callableStatement.setString("V_PATENTE", servicioTransporte.getPatente());
            callableStatement.setString("V_CHOFER", servicioTransporte.getChofer());
            callableStatement.setString("V_DIRECCION", servicioTransporte.getDireccion());
            callableStatement.setString("V_HORARIO", servicioTransporte.getHorario());
            callableStatement.setInt("V_ID_RESERVA", servicioTransporte.getIdReserva());
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void actualizarPlaniTransporte(ServicioTransporteJ servicioTransporte){

        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();

        CallableStatement callableStatement = null;

        try {

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            conn.setAutoCommit(false);
            String sql = "{call SP_ActualizarPlaniTransporte(?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt("V_ID_TRANSPORTE", servicioTransporte.getIdTransporte());
            callableStatement.setString("V_PATENTE", servicioTransporte.getPatente());
            callableStatement.setString("V_CHOFER", servicioTransporte.getChofer());
            callableStatement.executeQuery();
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        public ArrayList<ServicioTransporteJ> listarServiTransporte(){
        ConexionOracle conexionOracle = new ConexionOracle();
        Connection conn = conexionOracle.getConnection();
        CallableStatement callableStatement = null;
        ServicioTransporteJ auxServicioTransporte = new ServicioTransporteJ();
        ArrayList<ServicioTransporteJ> auxLista = new ArrayList<ServicioTransporteJ>();

        try {
            String sql = "{call SP_ListarServiTransporte(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(8, java.sql.Types.INTEGER);

            callableStatement.executeQuery();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                auxServicioTransporte = new ServicioTransporteJ();
                auxServicioTransporte.setIdTransporte(rs.getInt(1));
                auxServicioTransporte.setIdServiciotransporte(rs.getInt(2));
                auxServicioTransporte.setPatente(rs.getString(3));
                auxServicioTransporte.setChofer(rs.getString(4));
                auxServicioTransporte.setDireccion(rs.getString(5));
                auxServicioTransporte.setHorario(rs.getString(6));                
                auxServicioTransporte.setIdReserva(rs.getInt(7));
                
                auxLista.add(auxServicioTransporte);
            }
            rs.close();
            conexionOracle.desconexion();
        } catch (Exception ex) {
        }
        return auxLista;
    }
  }



