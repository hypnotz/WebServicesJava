/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.NegocioLogin;
import java.sql.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioCalculoPago")
public class ServicioCalculoPago {

    @WebMethod(operationName = "calculoPago")
    public int calculoPago(@WebParam(name = "idDepto") int idDepto,@WebParam(name = "fecha_ini") String fecha_ini,@WebParam(name = "fecha_fin") String fecha_fin) {
        
       NegocioLogin auxNegocioLogin = new NegocioLogin();
        
       return auxNegocioLogin.calcularPago(idDepto, fecha_ini, fecha_fin);
    }
}
