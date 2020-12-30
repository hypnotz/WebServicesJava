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
public class MultaDetalle {
    
    private int idMultaDetalle;
    private String descripcion;
    private int valorMulta;
    private int idMulta;
   

    public int getIdMultaDetalle() {
        return idMultaDetalle;
    }

    public void setIdMultaDetalle(int idMultaDetalle) {
        this.idMultaDetalle = idMultaDetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(int valorMulta) {
        this.valorMulta = valorMulta;
    }

    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

}
