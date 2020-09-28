/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.Departamento;
import DTO.ListaDepto;
import Negocio.NegocioDepartamento;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioDepartamento")
public class ServicioDepartamento {

    /**
     * This is a sample web service operation
     */
      @WebMethod(operationName = "IngresarDepto")
    public void ingresarDepto(@WebParam(name = "direccion") String direccion, @WebParam(name = "cantidadPiezas") int cantidadPiezas, @WebParam(name = "cantidadBanos") int cantidadBanos, @WebParam(name = "condiciones") String condiciones, @WebParam(name = "idTipoEstado") int idTipoEstado, @WebParam(name = "idComuna") int idComuna, @WebParam(name = "idTarifa") int idTarifa) {
        
        NegocioDepartamento auxNegocioDepto = new NegocioDepartamento();
        Departamento auxDepartamento = new Departamento();
        auxDepartamento.setDireccion(direccion);
        auxDepartamento.setCantidadPiezas(cantidadPiezas);
        auxDepartamento.setCantidadBanos(cantidadBanos);
        auxDepartamento.setCondiciones(condiciones);
        auxDepartamento.setIdTipoEstado(idTipoEstado);
        auxDepartamento.setIdComuna(idComuna);
        auxDepartamento.setIdTarifa(idTarifa);
      
      auxNegocioDepto.insertarDepto(auxDepartamento);
    }
    
    @WebMethod(operationName = "EliminarDepto")
     public void eliminarDepto(@WebParam(name = "idDepto") int idDepto){
         NegocioDepartamento auxNegocioDepto = new NegocioDepartamento();
         
         auxNegocioDepto.eliminarDepto(idDepto);
     }
     
     
      @WebMethod(operationName = "ActualizarDepto")
    public void actualizarDepto(@WebParam(name = "idDepto") int idDepto,@WebParam(name = "direccion") String direccion, @WebParam(name = "cantidadPiezas") int cantidadPiezas, @WebParam(name = "cantidadBanos") int cantidadBanos, @WebParam(name = "condiciones") String condiciones, @WebParam(name = "idTipoEstado") int idTipoEstado, @WebParam(name = "idComuna") int idComuna, @WebParam(name = "idTarifa") int idTarifa) {
        
        NegocioDepartamento auxNegocioDepto = new NegocioDepartamento();
        Departamento auxDepartamento = new Departamento();
        
        auxDepartamento.setIdDepto(idDepto);
        auxDepartamento.setDireccion(direccion);
        auxDepartamento.setCantidadPiezas(cantidadPiezas);

        auxDepartamento.setCantidadBanos(cantidadBanos);
        auxDepartamento.setCondiciones(condiciones);
        auxDepartamento.setIdTipoEstado(idTipoEstado);
        auxDepartamento.setIdComuna(idComuna);
        auxDepartamento.setIdTarifa(idTarifa);
      
      auxNegocioDepto.actualizarDepto(auxDepartamento);
    }
    
     @WebMethod(operationName = "ListarDepto")
    public ArrayList<ListaDepto> listarDepto(){
        NegocioDepartamento auxNegocio = new NegocioDepartamento();
        return auxNegocio.listarDepto();
    }
}
