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
public class Provincia {
    private int idProvincia;
    private String nombreProvincia;

    public Provincia(){
        this.idProvincia = 0;
        this.nombreProvincia = "";
    }

    public int getIdProvincia() {
        return idProvincia;
    }


    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }


    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }
}
