/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.Checkin;
import Negocio.NegocioCheckIn;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioCheckIn")
public class ServicioCheckIn {

@WebMethod(operationName = "insertarCheckIn")
public void insertarCheckIn(@WebParam(name="Fecha") String fecha,
            @WebParam(name="pagoRestante") int pagoRestante, @WebParam(name="idReserva") int idReserva,@WebParam(name="idRecursoHumano") int idRecursoHumano)
    {
        NegocioCheckIn auxNegocio = new NegocioCheckIn();
        Checkin auxCheckIn = new Checkin();
        
        auxCheckIn.setFecha(fecha);
        auxCheckIn.setPagoRestante(pagoRestante);
        auxCheckIn.setIdReserva(idReserva);
        auxCheckIn.setIdRecursoHumano(idRecursoHumano);
        auxNegocio.insertCheckIn(auxCheckIn);
        
    }
}
