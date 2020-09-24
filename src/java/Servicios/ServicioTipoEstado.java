/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.*;

import Negocio.NegocioTipoEstado;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;


/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioTipoEstado")
public class ServicioTipoEstado {

@WebMethod(operationName = "ListarTipo")
    public ArrayList<TipoEstado> listarTipo(){
        NegocioTipoEstado auxNegocioTipo = new NegocioTipoEstado();
        
        return auxNegocioTipo.listarTipo();
    }
  
}
