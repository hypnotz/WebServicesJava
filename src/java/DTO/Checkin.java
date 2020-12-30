/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author hypnotz
 */
public class Checkin {
    
    
    private int idCheckin;
    private String fecha;
    private int pagoRestante;
    private int idReserva;
    private int idRecursoHumano;

    public int getIdCheckin() {
        return idCheckin;
    }

    public void setIdCheckin(int idCheckin) {
        this.idCheckin = idCheckin;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPagoRestante() {
        return pagoRestante;
    }

    public void setPagoRestante(int pagoRestante) {
        this.pagoRestante = pagoRestante;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdRecursoHumano() {
        return idRecursoHumano;
    }

    public void setIdRecursoHumano(int idRecursoHumano) {
        this.idRecursoHumano = idRecursoHumano;
    }
    
    
    
}
