/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.Comuna;
import Negocio.NegocioComuna;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioComuna")
public class ServicioComuna {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getComuna")
    public ArrayList<Comuna> getComuna() {
        NegocioComuna auxNegocio = new NegocioComuna();
        return auxNegocio.getComuna();
    }

    @WebMethod(operationName = "getComunaById")
    public ArrayList<Comuna> getComunaById(@WebParam(name = "idProvincia") int idProvincia) {
        NegocioComuna auxNegocio = new NegocioComuna();
        return auxNegocio.getComunaById(idProvincia);
    }
 }

