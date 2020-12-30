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
public class ServicioTransporte {
    private int idTransporte;
    private int idServicioTransporte;
    private String patente;
    private String chofer;
    private String direccion;
    private String horario;
    private int idDisponibilidad;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    private int idReserva;
    /**
     * @return the idTransporte
     */
    public int getIdTransporte() {
        return idTransporte;
    }

    /**
     * @param idTransporte the idTransporte to set
     */
    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    /**
     * @return the idServicioTransporte
     */
    public int getIdServicioTransporte() {
        return idServicioTransporte;
    }

    public void setIdServicioTransporte(int idServicioTransporte) {
        this.idServicioTransporte = idServicioTransporte;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }
}
