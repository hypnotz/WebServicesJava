/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.Departamento;
import DTO.ListaTurismo;
import DTO.Region;
import DTO.Turismo;
import Negocio.NegocioDepartamento;
import Negocio.NegocioRegion;
import Negocio.NegocioTurismo;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioTurismo")
public class ServicioTurismo {

  @WebMethod(operationName = "IngresarTurismo")
    public void ingresarTurismo(@WebParam(name = "Descripcion") String descripcion,@WebParam(name = "Precio") int precio,@WebParam(name = "Disponibilidad") int disponibilidad,
            @WebParam(name = "V_FECHA") String fecha){
        
        NegocioTurismo auxTurismo = new NegocioTurismo();
        Turismo auxClaseTurismo = new Turismo();
        
        auxClaseTurismo.setDescripcion(descripcion);
        auxClaseTurismo.setPrecio(precio);
        auxClaseTurismo.setIdDisponibilidad(disponibilidad);
        auxClaseTurismo.setFecha(fecha);

      auxTurismo.IngresarTurismo(auxClaseTurismo);
    }

       @WebMethod(operationName = "ActualizarTurismo")
    public void actualizarTurismo(@WebParam(name = "v_ID_TURISMO") int idTurismo,@WebParam(name = "v_DESCRIPCION") String descripcion, @WebParam(name = "v_PRECIO") int precio, 
                                  @WebParam(name = "v_ID_DISPONIBILIDAD") int idDisponibilidad,@WebParam(name = "V_FECHA") String fecha ) {
        
        NegocioTurismo auxNegocioTurismo = new NegocioTurismo();
        Turismo auxClaseTurismo = new Turismo();
        
        auxClaseTurismo.setIdTurismo(idTurismo);
        auxClaseTurismo.setDescripcion(descripcion);
        auxClaseTurismo.setPrecio(precio);
        auxClaseTurismo.setIdDisponibilidad(idDisponibilidad);
        auxClaseTurismo.setFecha(fecha);
       
        auxNegocioTurismo.modificarTurismo(auxClaseTurismo);
    }
    
      @WebMethod(operationName = "eliminarTurismo")
     public void eliminarTurismo(@WebParam(name = "idTurismo") int idTurismo){
         
        NegocioTurismo auxNegocioTurismo = new NegocioTurismo();
         
         auxNegocioTurismo.eliminarTurismo(idTurismo);
     }

      @WebMethod(operationName = "listarTurismo")
    public ArrayList<ListaTurismo> listarTurismo(){
        
         NegocioTurismo auxNegocioTurismo = new NegocioTurismo();;
         
        return auxNegocioTurismo.listarTurismo();
    }
}
