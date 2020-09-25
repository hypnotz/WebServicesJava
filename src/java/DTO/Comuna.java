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
public class Comuna {
    
  private int idComuna;
    private String nombreComuna;

    public Comuna(){
        this.idComuna = 0;
        this.nombreComuna = "";
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }


    public String getNombreComuna() {
        return nombreComuna;
    }


    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }
    
}
