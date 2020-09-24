/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.*;
import Negocio.*;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;


/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioComuna")
public class ServicioComuna {

    /**
     * This is a sample web service operation
     */
   @WebMethod(operationName = "ListarComuna")
    public ArrayList<Comuna> listarComuna(){
        NegocioComuna auxNegocioC = new NegocioComuna();
        return auxNegocioC.listarComuna();
    }
}
