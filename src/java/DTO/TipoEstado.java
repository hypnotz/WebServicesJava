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
public class TipoEstado {
    
    private int tipoEstado;
    private String descripcion;

  

    public int getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(int tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
      @Override
    public String toString() {
        return "TipoEstado{" + "tipoEstado=" + tipoEstado + ", descripcion=" + descripcion + '}';
    }
}
