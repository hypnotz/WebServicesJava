/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.Usuario;
import Negocio.NegocioUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioUsuario")
public class ServicioUsuario {

    /**
     * This is a sample web service operation
     */
       @WebMethod(operationName = "ingresarUsuario")
    public void ingresarUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "contrasena") String contrasena, @WebParam(name = "id_Privilegio") int id_Privilegio) {
        
        NegocioUsuario auxNegocioUsuario = new NegocioUsuario();
        Usuario auxUsuario = new Usuario();
        
        auxUsuario.setNombreUsuario(nombreUsuario);
        auxUsuario.setContrasena(contrasena);
        auxUsuario.setIdPrivilegio(id_Privilegio);
        

      auxNegocioUsuario.insertarUsuario(auxUsuario);
    }
    
       @WebMethod(operationName = "ActualizarUsuario")
        public void actualizarUsuario(@WebParam(name = "V_ID_USUARIO") int idUsuario,@WebParam(name = "V_NOMBRE_USUARIO") String nombreUsuario, @WebParam(name = "V_CONTRASENA") String contrasena, @WebParam(name = "V_ID_PRIVILEGIO") int idPrivilegio ) {
        
        NegocioUsuario auxNegocioUsuario = new NegocioUsuario();
        Usuario auxUsuario = new Usuario();
        
        auxUsuario.setIdUsuario(idUsuario);
        auxUsuario.setNombreUsuario(nombreUsuario);
        auxUsuario.setContrasena(contrasena);
        auxUsuario.setIdPrivilegio(idPrivilegio);
      
        auxNegocioUsuario.modificarUsuario(auxUsuario);

    }
        
         @WebMethod(operationName = "EliminarUsuario")
     public void eliminarUsuario(@WebParam(name = "idUsuario") int idUsuario){
         NegocioUsuario auxNegocioUsuario = new NegocioUsuario();
         
         auxNegocioUsuario.eliminarUsuario(idUsuario);
     }
}
