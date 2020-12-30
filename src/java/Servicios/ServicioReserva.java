/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.*;
import Negocio.NegocioReserva;
import Negocio.NegocioReservaUsuario;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioReserva")
public class ServicioReserva {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertReserva")
    public void insertReserva(@WebParam(name="fechaInicio") String fechaInicio, @WebParam(name="fechaFin") String fechaFin, @WebParam(name="pago") int pago,
    @WebParam(name="idDpto") int idDpto, @WebParam(name="idCliente") int idCliente){

        NegocioReserva auxNegocio = new NegocioReserva();
        ReservaDto auxReserva = new ReservaDto();
        auxReserva.setFechaInicio(fechaInicio);
        auxReserva.setFechaFin(fechaFin);
        auxReserva.setPago(pago);
        auxReserva.setIdDpto(idDpto);
        auxReserva.setIdCliente(idCliente);
        auxNegocio.insertReserva(auxReserva);

    }
      @WebMethod(operationName = "reservaUsuario2")
    public ArrayList<ReservaUsuario> reservaUsuario2(@WebParam(name = "nombreUsuario") String nombreUsuario) {
        
        NegocioReservaUsuario auxNegocio = new NegocioReservaUsuario();
        
        return auxNegocio.listarReservaUsuario(nombreUsuario);
    }
    
     @WebMethod(operationName = "consultaReservas")
    public ArrayList<Reserva> consultaReservas(@WebParam(name = "idDepto") String idDepto) {
        
        NegocioReserva auxNegocio = new NegocioReserva();
        
        return auxNegocio.listarReservas(idDepto);
    }
    
    @WebMethod(operationName = "consultaReservasOut")
    public ArrayList<Reserva> consultaReservasOut() {
        
        NegocioReserva auxNegocio = new NegocioReserva();
        
        return auxNegocio.listarReservasSinCheckOut();
    }
    @WebMethod(operationName = "listarReserva")
    public ArrayList<ReservaDto> listarReserva(){
        NegocioReserva auxNegocio = new NegocioReserva();

        return auxNegocio.listarReserva();
    }
    
    @WebMethod(operationName = "GetTurismoByReserva")
    public ArrayList<ServicioReservaList> GetTurismoByReserva(@WebParam(name = "idReserva") int idReserva){
        NegocioReserva auxNegocio = new NegocioReserva();
        
        
        return auxNegocio.GetTurismoByReserva(idReserva);
    }
    
    @WebMethod(operationName = "GetTransporteByReserva")
    public ArrayList<ServicioReservaList> GetTransporteByReserva(@WebParam(name = "idReserva") int idReserva){
        NegocioReserva auxNegocio = new NegocioReserva();
        
        return auxNegocio.GetTransporteByReserva(idReserva);
    }
    
    @WebMethod(operationName = "GetAcompaniantesByReserva")
    public ArrayList<AcompanianteReserva> GetAcompaniantesByReserva(@WebParam(name = "idReserva") int idReserva){
        NegocioReserva auxNegocio = new NegocioReserva();
        
        return auxNegocio.GetAcompaniantesByReserva(idReserva);
    }
    
    @WebMethod(operationName = "validarFechaReserva")
    public ArrayList<String> validarFechaReserva(@WebParam(name = "idDepto") int idDepto,@WebParam(name = "fecha_inicio") String fecha_inicio,@WebParam(name = "fecha_fin") String fecha_fin){
        NegocioReserva auxNegocio = new NegocioReserva();
        
        return auxNegocio.validarFechaReserva(idDepto, fecha_inicio, fecha_fin);
    }
    
}
