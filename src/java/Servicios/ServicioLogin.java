/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.NegocioCliente;
import Negocio.NegocioLogin;
import Negocio.NegocioRecursoHumano;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioLogin")
public class ServicioLogin {

   @WebMethod(operationName = "login")
    public String loguearseByUsuario(@WebParam(name="usuarito") String usuario, @WebParam(name="contrasena") String contrasena)
    {
        NegocioLogin auxNegocio = new NegocioLogin();
        
        return auxNegocio.iniciarSesion(usuario, contrasena);
    }
    
    @WebMethod(operationName = "getIdByName")
    public int getIdByName(@WebParam(name="usuarito") String usuario)
    {
        NegocioLogin auxNegocio = new NegocioLogin();
        
        return auxNegocio.traerIdByNombre(usuario);
    }
    
    @WebMethod(operationName = "getIdByUserName")
    public int getIdByUserName(@WebParam(name="usuarito") String usuario)
    {
        NegocioRecursoHumano auxNegocio = new NegocioRecursoHumano();
        
        return auxNegocio.traerIdByIdUser(usuario);
    }
    
    
    @WebMethod(operationName = "getCorreo")
    public String getCorreo(@WebParam(name="usuarito") int idUsuario)
    {
        NegocioLogin auxNegocio = new NegocioLogin();
        
        return auxNegocio.obtenerCorreoByID(idUsuario);
    }
    
    @WebMethod(operationName = "getidByUserID")
    public int getidByUserID(@WebParam(name="idUsuario") int idUsuario)
    {
        NegocioLogin auxNegocio = new NegocioLogin();
        
        return auxNegocio.traeridEstadoByIDuSer(idUsuario);
    }
    
    @WebMethod(operationName = "validarUsernameExists")
     public Boolean validarUsernameExists(@WebParam(name="user") String user){
         
           NegocioLogin auxNegocio = new NegocioLogin();
        
           return auxNegocio.validarUsernameExists(user);
     }
}
