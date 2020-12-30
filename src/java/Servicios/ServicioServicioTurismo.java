/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.ServicioTurismoDto;
import Negocio.NegocioServicioTurismo;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioServicioTurismo")
public class ServicioServicioTurismo {

 
  @WebMethod(operationName = "insertServiceTurismo")
    public void insertServiceTurismo(@WebParam(name = "idTurismo") int idTurismo, @WebParam(name = "idReserva") int idReserva) 
    {
        NegocioServicioTurismo auxServicio = new NegocioServicioTurismo();
        ServicioTurismoDto auxTurismo = new ServicioTurismoDto();
        auxTurismo.setIdTurismo(idTurismo);
        auxTurismo.setIdReserva(idReserva);
        auxServicio.insertServicioTurismo(auxTurismo);
    }
    
    
}
