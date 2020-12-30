
package Servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import DTO.*;
import Negocio.NegocioTransporte;
import java.util.ArrayList;
import Negocio.*;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioTransporte")
public class ServicioTransporte {

 @WebMethod(operationName = "IngresoTransporte")
    public void ingresoTransporte(@WebParam(name = "Precio") int precio,@WebParam(name = "Disponbilidad") int disponibilidad,@WebParam(name = "V_CAPACIDAD") int capacidad,@WebParam(name = "V_DESCRIPCION") String descripcion){
        
      
       
        Transporte auxClaseTransporte = new Transporte();
        NegocioTransporte auxTransporte = new NegocioTransporte();
        
        auxClaseTransporte.setPrecio(precio);
        auxClaseTransporte.setIdDisponibilidad(disponibilidad);
        auxClaseTransporte.setCapacidad(capacidad);
        auxClaseTransporte.setDescripcion(descripcion);
        
  
      auxTransporte.IngresarTransporte(auxClaseTransporte);
    }
    
     @WebMethod(operationName = "actualizarTransporte")
    public void actualizarTransporte(@WebParam(name = "v_ID_TRANSPORTE") int idTransporte,@WebParam(name = "v_PRECIO") int precio, @WebParam(name = "v_ID_DISPONIBILIDAD") int idDisponibilidad, 
                                     @WebParam(name = "v_CAPACIDAD") int idCapacidad,@WebParam(name = "V_DESCRIPCION") String descripcion) {
        
     Transporte auxClaseTransporte = new Transporte();
     NegocioTransporte auxTransporte = new NegocioTransporte();
     
     auxClaseTransporte.setIdTransporte(idTransporte);
     auxClaseTransporte.setPrecio(precio);
     auxClaseTransporte.setIdDisponibilidad(idDisponibilidad);
     auxClaseTransporte.setCapacidad(idCapacidad);
     auxClaseTransporte.setDescripcion(descripcion);
    auxTransporte.modificarTransporte(auxClaseTransporte);
    }
    
    
    @WebMethod(operationName = "eliminarTransporte")
     public void eliminarTransporte(@WebParam(name = "idTransporte") int idTransporte){
         
       NegocioTransporte auxTransporte = new NegocioTransporte();
         
       auxTransporte.eliminarTransporte(idTransporte);
     }
     
    @WebMethod(operationName = "listarTransporte")
    public ArrayList<ListaTransporte> listarTransporte(){
        
        NegocioTransporte auxTransporte = new NegocioTransporte();
         
        return auxTransporte.listarTransporte();
    }
    @WebMethod(operationName = "insertReservaService")
    public void insertReservaService(@WebParam(name = "idTransporte") int idTransporte,
            @WebParam(name = "direccion") String direccion,
            @WebParam(name = "horario") String horario,
            @WebParam(name = "idReserva") int idReserva) 
    {
        NegocioServicioTransporte auxServicio = new NegocioServicioTransporte();
        ServicioTransporteDto auxTransporte = new ServicioTransporteDto();
        auxTransporte.setIdTransporte(idTransporte);
        auxTransporte.setDireccion(direccion);
        auxTransporte.setHorario(horario);
        auxTransporte.setIdReserva(idReserva);
        auxServicio.insertServicioTransporte(auxTransporte);
    }
    
    @WebMethod(operationName = "ActualizarPlaniTransporte")
    public void ActualizarPlaniTransporte(@WebParam(name = "idTransporte") int idTransporte,
                                          @WebParam(name = "patente") String patente, 
                                          @WebParam(name = "chofer") String chofer) {

        NegocioServicioTransporteJ auxNegocio = new NegocioServicioTransporteJ();
        ServicioTransporteJ auxPlani = new ServicioTransporteJ();

        auxPlani.setIdTransporte(idTransporte);
        auxPlani.setPatente(patente);
        auxPlani.setChofer(chofer);

        auxNegocio.actualizarPlaniTransporte(auxPlani);
    }
    
    @WebMethod(operationName = "listarServiTransportex")
    public ArrayList<ServicioTransporteJ> listarServiTransportex(){

        NegocioServicioTransporteJ auxServiTransporte = new NegocioServicioTransporteJ();

        return auxServiTransporte.listarServiTransporte();
    }
    
}
