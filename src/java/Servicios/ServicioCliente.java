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

     @WebMethod(operationName = "ListarCliente")
    public ArrayList<Cliente> listarCliente(){
        
        NegocioCliente auxCliente = new NegocioCliente();
        
        return auxCliente.listarCliente();

    }
    @WebMethod(operationName = "ListarClienteUsuario")
    public ArrayList<Cliente_Usuario> listarClienteUsuario(){
        
        NegocioCliente auxCliente = new NegocioCliente();
        
        return auxCliente.traerSoloCliente();
    }
    @WebMethod(operationName = "getClienteById")
    public ClienteDto getClienteById(@WebParam(name="idUsuario") int idUsuario)
    {
        NegocioCliente auxNegocio = new NegocioCliente();
        return auxNegocio.getUserById(idUsuario);
    }
    
    @WebMethod(operationName = "ListarClienteUsuarioDeshabilitado")
    public ArrayList<Cliente_Usuario> listarClienteUsuarioDes(){
        
        NegocioCliente auxCliente = new NegocioCliente();
        return auxCliente.traerClienteDeshabilitado();
    }
     @WebMethod(operationName = "getClienteByRut")
    public Cliente_Usuario getClienteByRut(@WebParam(name="Rut") String rut)
    {
        NegocioCliente auxNegocio = new NegocioCliente();
        return auxNegocio.getUserByRut(rut);
    }
    
 
    
    @WebMethod(operationName = "updateUsuarioCliente")
    public void updateUsuarioCliente(@WebParam(name="Rut") String rut, @WebParam(name="Nombres") String nombres
    ,@WebParam(name="ApellidoPaterno") String apellidoPaterno, @WebParam(name="ApellidoMaterno") String apellidoMaterno,
    @WebParam(name="Correo") String correo, @WebParam(name="FechaNacimiento") String fechaNac, @WebParam(name="fono") int fono,
    @WebParam(name="NombreUsuario") String nomUsuario, @WebParam(name="Password") String password,
    @WebParam(name="idUsuario") int idUsuario)
    {
        NegocioCliente auxNegocio = new NegocioCliente();
        ClienteDto auxCliente = new ClienteDto();
        auxCliente.setRut(rut);
        auxCliente.setNombres(nombres);
        auxCliente.setApellidoPaterno(apellidoPaterno);
        auxCliente.setApellidoMaterno(apellidoMaterno);
        auxCliente.setCorreo(correo);
        auxCliente.setFechaNacimiento(fechaNac);
        auxCliente.setTelefono(fono);
        auxCliente.setNombreUsuario(nomUsuario);
        auxCliente.setContrasena(password);
        auxCliente.setIdUsuario(idUsuario);
        
        auxNegocio.updateUsuarioCliente(auxCliente);
    }
}
