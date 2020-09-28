/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.*;
import Negocio.NegocioUsuario;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
    public void ingresarUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "contrasena") String contrasena, @WebParam(name = "id_Privilegio") int id_Privilegio,@WebParam(name = "id_Estado") int idEstado) {
        
        NegocioUsuario auxNegocioUsuario = new NegocioUsuario();
        Usuario auxUsuario = new Usuario();
        
        auxUsuario.setNombreUsuario(nombreUsuario);
        auxUsuario.setContrasena(contrasena);
        auxUsuario.setIdPrivilegio(id_Privilegio);
        auxUsuario.setIdEstado(idEstado);

      auxNegocioUsuario.insertarUsuario(auxUsuario);
    }
    
   @WebMethod(operationName = "ingresarUsuario2")
    public void ingresarUsuario2(@WebParam(name = "V_RUT") String rut, @WebParam(name = "V_NOMBRES") String nombres,@WebParam(name = "V_APELLIDO_PATERNO") String aPaterno,
            @WebParam(name = "V_APELLIDO_MATERNO") String aMaterno,@WebParam(name = "V_CORREO") String correo,@WebParam(name = "V_FECHA_NACIMIENTO") String fechaNacimiento,
    @WebParam(name = "V_TELEFONO") int telefono,@WebParam(name = "V_NOMBRE_USUARIO") String nombreUsuario,@WebParam(name = "V_CONTRASENA") String contraseña,
    @WebParam(name = "V_ID_PRIVILEGIO") int idPrivilegio,@WebParam(name = "V_ID_ESTADO") int idEstado){
         
         Usuario auxUsuario = new Usuario();
         Cliente auxCliente = new Cliente();
         NegocioUsuario auxNegocioUsuario = new NegocioUsuario();
        

         auxCliente.setRut(rut);
         auxCliente.setNombres(nombres);
         auxCliente.setApellidoMaterno(aMaterno);
         auxCliente.setApellidoPaterno(aPaterno);
         auxCliente.setCorreo(correo);
         auxCliente.setFechaNacimiento(fechaNacimiento);
         auxCliente.setTelefono(telefono);
         auxUsuario.setNombreUsuario(nombreUsuario);
         auxUsuario.setContrasena(contraseña);
         auxUsuario.setIdPrivilegio(idPrivilegio);
         auxUsuario.setIdEstado(idEstado);
         
         auxNegocioUsuario.insertarUsuario2(auxCliente, auxUsuario);
        
    }
    
       @WebMethod(operationName = "ActualizarUsuario")
        public void actualizarUsuario(@WebParam(name = "V_ID_USUARIO") int idUsuario,@WebParam(name = "V_NOMBRE_USUARIO") String nombreUsuario, @WebParam(name = "V_CONTRASENA") String contrasena, @WebParam(name = "V_ID_PRIVILEGIO") int idPrivilegio,
                @WebParam(name = "V_ID_ESTADO") int idEstado) {
        
        NegocioUsuario auxNegocioUsuario = new NegocioUsuario();
        Usuario auxUsuario = new Usuario();
        
        auxUsuario.setIdUsuario(idUsuario);
        auxUsuario.setNombreUsuario(nombreUsuario);
        auxUsuario.setContrasena(contrasena);
        auxUsuario.setIdPrivilegio(idPrivilegio);
        auxUsuario.setIdEstado(idEstado);
      
        auxNegocioUsuario.modificarUsuario(auxUsuario);
    }
         @WebMethod(operationName = "EliminarClienteUsuario")
     public void eliminarClienteUsuario(@WebParam(name = "idUsuario") int idUsuario){
         NegocioUsuario auxNegocioUsuario = new NegocioUsuario();
         
         auxNegocioUsuario.eliminarClienteUsuario(idUsuario);
     }
     
     @WebMethod(operationName = "autenticarUsuario")
        public void autenticarUsuario(@WebParam(name = "V_ID_USUARIO") int idUsuario){
        
        NegocioUsuario auxNegocioUsuario = new NegocioUsuario();

        auxNegocioUsuario.autenticarUsuario(idUsuario);
    }
}

