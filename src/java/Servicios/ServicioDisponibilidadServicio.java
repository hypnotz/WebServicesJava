/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.DisponibilidadServicio;
import Negocio.NegocioDisponibilidadServicio;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioDisponibilidadServicio")
public class ServicioDisponibilidadServicio {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "listaDisponibilidadServicio")
    public ArrayList<DisponibilidadServicio> listaDisponibilidadServicio(){
        NegocioDisponibilidadServicio auxNegocioDisponibilidad = new NegocioDisponibilidadServicio();
        return auxNegocioDisponibilidad.listaDisponibilidadServicio();
    }
}
