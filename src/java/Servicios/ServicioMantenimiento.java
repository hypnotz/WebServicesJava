/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.MantenimientoDto;
import Negocio.NegocioMantenimiento;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioMantenimiento")
public class ServicioMantenimiento {

    /**
     * This is a sample web service operation
     */
   @WebMethod(operationName = "updateMantenimiento")
    public void updateMantenimiento(@WebParam(name="idMantenimiento") int idMantenimiento, @WebParam(name="descripcion") String descripcion,
            @WebParam(name="total") int total, @WebParam(name="idDepartamento") int idDepartamento,@WebParam(name="fecha") String fecha)
    {
        NegocioMantenimiento auxNegocio = new NegocioMantenimiento();
        MantenimientoDto auxMantenimiento = new MantenimientoDto();
        auxMantenimiento.setDescripcion(descripcion);
        auxMantenimiento.setIdMantenimiento(idMantenimiento);
        auxMantenimiento.setTotal(total);
        auxMantenimiento.setIdDepartamento(idDepartamento);
        auxMantenimiento.setFecha(fecha);

        auxNegocio.updateMantenimiento(auxMantenimiento);
    }
    
    @WebMethod(operationName = "getMantenimientoById")
    public MantenimientoDto getMantenimientoById(@WebParam(name="idMantenimiento") int id)
    {
        NegocioMantenimiento auxNegocio = new NegocioMantenimiento();
        return auxNegocio.getMantenimientoById(id);
    }
    
 @WebMethod(operationName = "getMantenimiento")
    public ArrayList<MantenimientoDto> getMantenimiento()
    {
        NegocioMantenimiento auxNegocio = new NegocioMantenimiento();
        return auxNegocio.getMantenimiento();
    }
    
    @WebMethod(operationName = "insertMantenimiento")
    public void insertMantenimiento(@WebParam(name="descripcion") String descripcion,
            @WebParam(name="total") int total, @WebParam(name="idDepartamento") int idDepartamento,@WebParam(name="fecha") String fecha)
    {
        NegocioMantenimiento auxNegocio = new NegocioMantenimiento();
        MantenimientoDto auxMantenimiento = new MantenimientoDto();
        auxMantenimiento.setDescripcion(descripcion);
        auxMantenimiento.setTotal(total);
        auxMantenimiento.setIdDepartamento(idDepartamento);
        auxMantenimiento.setFecha(fecha);
        auxNegocio.insertMantenimiento(auxMantenimiento);
    }
    
    @WebMethod(operationName = "deleteMantenimiento")
    public void deleteMantenimiento(@WebParam(name="idMantenimiento") int id)
    {
        NegocioMantenimiento auxNegocio = new NegocioMantenimiento();
        auxNegocio.deleteMantenimiento(id);
    }
}
