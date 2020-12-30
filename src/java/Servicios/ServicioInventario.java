/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.Inventario;
import Negocio.NegocioInventario;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioInventario")
public class ServicioInventario {


  @WebMethod(operationName = "ingresarInventario")
    public void ingresarInventario(@WebParam(name = "V_ID_DEPTO") int idDepto,@WebParam(name = "V_CABLE") String cable,@WebParam(name = "V_INTERNET") String internet,
                                    @WebParam(name = "V_CALEFACCION") String calefaccion,@WebParam(name = "V_AMOBLADO") String amoblado){
        
        NegocioInventario auxNegocioInventario = new NegocioInventario();
        Inventario auxClaseInventario = new Inventario();
        
        auxClaseInventario.setId_departamento(idDepto);
        auxClaseInventario.setCable(cable);
        auxClaseInventario.setInternet(internet);
        auxClaseInventario.setCalefaccion(calefaccion);
        auxClaseInventario.setAmoblado(amoblado);

      auxNegocioInventario.IngresarInventario(auxClaseInventario);
    }

       @WebMethod(operationName = "actualizarInventario")
    public void actualizarInventario(@WebParam(name = "V_ID_DEPTO") int idDepto,@WebParam(name = "V_CABLE") String cable,@WebParam(name = "V_INTERNET") String internet,
                                    @WebParam(name = "V_CALEFACCION") String calefaccion,@WebParam(name = "V_AMOBLADO") String amoblado){
        
        NegocioInventario auxNegocioInventario = new NegocioInventario();
        Inventario auxClaseInventario = new Inventario();
        
        auxClaseInventario.setId_departamento(idDepto);
        auxClaseInventario.setCable(cable);
        auxClaseInventario.setInternet(internet);
        auxClaseInventario.setCalefaccion(calefaccion);
        auxClaseInventario.setAmoblado(amoblado);
       
         auxNegocioInventario.actualizarInventario(auxClaseInventario);
    }

   @WebMethod(operationName = "listarInventario")
    public ArrayList<Inventario> listarInventario(){
        NegocioInventario auxNegocio = new NegocioInventario();
        return auxNegocio.listarInventario();
    }
}
    
