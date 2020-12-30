package Servicios;

import Negocio.NegocioServicioTransporte;
import DTO.ServicioTransporte;
import DTO.ServicioTransporteJ;
import Negocio.NegocioServicioTransporteJ;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioServicioTransporte")
public class ServicioServicioTransporte {

    @WebMethod(operationName = "planificarTransporte")
    public void planificarTransporte(@WebParam(name = "idTransporte") int idTransporte, 
                                     @WebParam(name = "patente") String patente, 
                                     @WebParam(name = "chofer") String chofer, 
                                     @WebParam(name = "direccion") String direccion, 
                                     @WebParam(name = "horario") String horario, 
                                     @WebParam(name = "idReserva") int idReserva) {

        NegocioServicioTransporteJ auxNegocio = new NegocioServicioTransporteJ();
        ServicioTransporteJ auxServicioTransporte = new ServicioTransporteJ();
        auxServicioTransporte.setIdTransporte(idTransporte);
        auxServicioTransporte.setPatente(patente);
        auxServicioTransporte.setChofer(chofer);
        auxServicioTransporte.setDireccion(direccion);
        auxServicioTransporte.setHorario(horario);
        auxServicioTransporte.setIdReserva(idReserva);

      auxNegocio.planificarTransporte(auxServicioTransporte);
    }
}