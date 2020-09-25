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
public class Region {
    
    private int idRegion;
    private String nombreRegion;

    public Region(){
        this.idRegion = 0;
        this.nombreRegion = "";
    }
    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    @Override
    public String toString() {
        return "Region{" + "idRegion=" + idRegion + ", nombreRegion=" + nombreRegion + '}';
    }

}
