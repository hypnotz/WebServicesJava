/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.sql.Blob;

/**
 *
 * @author hypnotz
 */
public class ListaDepto {
    
    private int idDepartamento;
    private String direccion;
    private int cantidadPiezas;
    private int idEstado;
    private int cantidadBanos;
    private String condiciones;
    private String tipoEstado;
    private String Comuna;
    private int tarifa;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    private byte[] image;
    

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getCantidadBanos() {
        return cantidadBanos;
    }

    public void setCantidadBanos(int cantidadBanos) {
        this.cantidadBanos = cantidadBanos;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String Comuna) {
        this.Comuna = Comuna;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }
    
    @Override
    public String toString() {
        return "ListaDepto{" + "idDepartamento=" + idDepartamento + ", direccion=" + direccion + ", cantidadPiezas=" + cantidadPiezas + ", idEstado=" + idEstado + ", cantidadBanos=" + cantidadBanos + ", condiciones=" + condiciones + ", tipoEstado=" + tipoEstado + ", Comuna=" + Comuna + ", tarifa=" + tarifa + '}';
    }
}
