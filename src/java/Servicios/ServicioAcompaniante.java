/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.NegocioAcompaniante;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import DTO.*;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioAcompaniante")
public class ServicioAcompaniante {


    @WebMethod(operationName = "insertarAcompaniante")
    public void insertarAcompaniante(@WebParam(name = "rut") String rut,@WebParam(name = "idReserva") int idReserva,@WebParam(name = "nombre") String nombre,
                                        @WebParam(name = "apellidos") String apellidos) {
        
        NegocioAcompaniante aux = new NegocioAcompaniante();
        Acompaniantes auxAcompaniante = new Acompaniantes();
        
        auxAcompaniante.setRut(rut);
        auxAcompaniante.setIdReserva(idReserva);
        auxAcompaniante.setApellidos(apellidos);
        auxAcompaniante.setNombre(nombre);
        
        aux.insertMantenimiento(auxAcompaniante);
    }
}
