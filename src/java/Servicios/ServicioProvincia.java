/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.Provincia;
import Negocio.NegocioProvincia;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioProvincia")
public class ServicioProvincia {

    /**
     * This is a sample web service operation
     */
   @WebMethod(operationName = "listarProvincia")
    public ArrayList<Provincia> listarProvinciaService() {
        NegocioProvincia auxNegocio = new NegocioProvincia();
        return auxNegocio.getProvincia();
    }

    @WebMethod(operationName = "getProvinciaById")
    public ArrayList<Provincia> getProvinciaById(@WebParam(name = "idRegion") int idRegion) {
        NegocioProvincia auxNegocio = new NegocioProvincia();
        return auxNegocio.getProvinciaById(idRegion);
    }
    
    
}
