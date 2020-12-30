/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DTO.ReporteGanancia;
import DTO.ReporteMensualReservas;
import DTO.ReporteZona;
import Negocio.NegocioReporteM;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hypnotz
 */
@WebService(serviceName = "ServicioReporte")
public class ServicioReporte {

    //Listo
    @WebMethod(operationName = "getReporteM")
    public ArrayList<ReporteMensualReservas> getReporteM() {
       NegocioReporteM auxNegocio = new NegocioReporteM();
        return auxNegocio.reporteMensualReservas();
    }
    //listo
    @WebMethod(operationName = "getReporteGanancia")
    public ArrayList<ReporteGanancia> getReporteGanancia(@WebParam(name = "intAno") int ano) {
        
       NegocioReporteM auxNegocio = new NegocioReporteM();
       
        return auxNegocio.reporteGanancia(ano);
    }
    
    //Listo
     @WebMethod(operationName = "getReporteGananciaMensual")
    public ArrayList<ReporteGanancia> getReporteGananciaMensual(@WebParam(name = "intMes") int mes,@WebParam(name = "intAno") int ano ) {
        
       NegocioReporteM auxNegocio = new NegocioReporteM();
       
        return auxNegocio.reporteGananciaMensual(mes, ano);
    }
    
    
    //Listo
    @WebMethod(operationName = "reporteGananciaDiaria")
    public ArrayList<ReporteGanancia> reporteGananciaDiaria(@WebParam(name = "intDia") int dia,@WebParam(name = "intMes") int mes,@WebParam(name = "intAno") int ano ) {
        
       NegocioReporteM auxNegocio = new NegocioReporteM();
       
        return auxNegocio.reporteGananciaDiaria(dia,mes, ano);
    }
    
    //Listo
    @WebMethod(operationName = "reporteGananciaZona")
    public ArrayList<ReporteZona> reporteGananciaZona(@WebParam(name = "intAno") int ano ) {
        
       NegocioReporteM auxNegocio = new NegocioReporteM();
       
        return auxNegocio.reporteGananciaAnualZona(ano);
    }
    //
    @WebMethod(operationName = "reporteGananciaMensualZona")
    public ArrayList<ReporteZona> reporteGananciaMensualZona(@WebParam(name = "intMes") int mes,@WebParam(name = "intAno") int ano) {
        
       NegocioReporteM auxNegocio = new NegocioReporteM();
       
        return auxNegocio.reporteGananciaMensualZona(mes,ano);
    }
    
    @WebMethod(operationName = "reporteGananciaDiariaZona")
    public ArrayList<ReporteZona> reporteGananciaDiariaZona(@WebParam(name = "intDia") int dia,@WebParam(name = "intMes") int mes,@WebParam(name = "intAno") int ano ) {
        
       NegocioReporteM auxNegocio = new NegocioReporteM();
       
        return auxNegocio.reporteGananciaDiariaZona(dia,mes,ano);
    }
}
