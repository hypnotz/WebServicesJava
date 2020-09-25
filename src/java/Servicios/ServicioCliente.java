/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.*;
import Negocio.NegocioCliente;
import Negocio.NegocioRegion;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioCliente")
public class ServicioCliente {

    /**
     * This is a sample web service operation
     */
     @WebMethod(operationName = "ListarCliente")
    public ArrayList<Cliente> listarCliente(){
        
        NegocioCliente auxCliente = new NegocioCliente();
        
        return auxCliente.listarCliente();

    }
}
