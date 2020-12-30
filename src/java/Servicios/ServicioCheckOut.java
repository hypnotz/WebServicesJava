/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.*;
import Negocio.NegocioCheckOut;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Negocio.*;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioCheckOut")
public class ServicioCheckOut {


@WebMethod(operationName = "insertarCheckOut")
public void insertarCheckOut(@WebParam(name="idCheckIn") int idCheckIn,@WebParam(name="Fecha") String fecha,
            @WebParam(name="idRecursoHumano") int idRecursoHumano)
    {
        NegocioCheckOut auxNegocio = new NegocioCheckOut();
        CheckOut auxCheckOut = new CheckOut();
        
        auxCheckOut.setIdCheckIn(idCheckIn);
        auxCheckOut.setFecha(fecha);
        auxCheckOut.setIdRecursoHumano(idRecursoHumano);
        auxNegocio.insertCheckOut(auxCheckOut);
    }


@WebMethod(operationName = "insertarCheckOutMulta")
public void insertarCheckOutMulta(@WebParam(name="V_TOTAL_MULTA") int totalMulta,@WebParam(name="V_ID_CHECK_OUT") int idCheckOut,
        @WebParam(name="V_ID_CHECK_IN") int idCheckIn,
       @WebParam(name="V_FECHA") String fecha, @WebParam(name="V_ID_RECURSOS") int idRecursos)
    {
        NegocioMultayDetalle auxNegocio = new NegocioMultayDetalle();
        CheckOut auxCheckOut = new CheckOut();
        Multa auxMulta = new Multa();
        
        auxCheckOut.setFecha(fecha);
        auxCheckOut.setIdCheckIn(idCheckIn);
        auxCheckOut.setIdRecursoHumano(idRecursos);
        auxMulta.setIdCheckIn(idCheckIn);
        auxMulta.setTotal(totalMulta);
        auxNegocio.insertarCheckOutMultaDetalle(auxCheckOut,auxMulta );
    }

@WebMethod(operationName = "insertarDetalleMulta")
public void insertarDetalleMulta(@WebParam(name="V_TOTAL_MULTA") int totalMultas,@WebParam(name="V_DESCRIPCION") String descripcion,@WebParam(name="V_ID_MAXMULTA") int  idMaxmulta )
    {
        NegocioMultayDetalle auxNegocio = new NegocioMultayDetalle();
        CheckOut auxCheckOut = new CheckOut();
        MultaDetalle auxMulta = new MultaDetalle();
       
        auxMulta.setDescripcion(descripcion);
        auxMulta.setValorMulta(totalMultas);
        auxMulta.setIdMulta(idMaxmulta);
        
        auxNegocio.insertarDetalle(auxMulta);
    }

@WebMethod(operationName = "insertarCheckOutMulta2")
public int insertarCheckOutMulta2(@WebParam(name="V_TOTAL_MULTA") int totalMulta,@WebParam(name="V_ID_CHECK_OUT") int idCheckOut,
        @WebParam(name="V_ID_CHECK_IN") int idCheckIn,
       @WebParam(name="V_FECHA") String fecha, @WebParam(name="V_ID_RECURSOS") int idRecursos)
    {
        NegocioMultayDetalle auxNegocio = new NegocioMultayDetalle();
        CheckOut auxCheckOut = new CheckOut();
        Multa auxMulta = new Multa();
        
        auxCheckOut.setFecha(fecha);
        auxCheckOut.setIdCheckIn(idCheckIn);
        auxCheckOut.setIdRecursoHumano(idRecursos);
        auxMulta.setIdCheckIn(idCheckIn);
        auxMulta.setTotal(totalMulta);
        
        return auxNegocio.retornaIdMultaLast(auxCheckOut,auxMulta);
    }

@WebMethod(operationName = "getLastID")
    public int getLastID()
    {
        NegocioMultayDetalle auxNegocio = new NegocioMultayDetalle();
        MultaID auxMulta = new MultaID();
        
        return auxNegocio.retornaIDInsert();
    }

}
