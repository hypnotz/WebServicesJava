/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.Region;
import Negocio.NegocioRegion;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioRegion")
public class ServicioRegion {

   @WebMethod(operationName = "ListarRegion")
    public ArrayList<Region> listarRegion(){
        NegocioRegion auxNegocio = new NegocioRegion();
        return auxNegocio.listarRegion();
    }
}
