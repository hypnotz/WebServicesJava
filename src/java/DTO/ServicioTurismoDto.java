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
public class ServicioTurismoDto {
    private int idReserva;
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public int getIdTurismo() {
        return idTurismo;
    }

    
    
    public void setIdTurismo(int idTurismo) {
        this.idTurismo = idTurismo;
    }

    public int getIdServTurismo() {
        return idServTurismo;
    }

    public void setIdServTurismo(int idServTurismo) {
        this.idServTurismo = idServTurismo;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    private int idTurismo;
    private int idServTurismo;
    private String guia;
    private String patente;
    private String fecha;
}
