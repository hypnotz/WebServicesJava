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
public class MantenimientoDto {
    
    private int idMantenimiento;
    private String descripcion;
    private int total;
    private int idDepartamento;
    private String fecha;

    public MantenimientoDto(){
        this.idMantenimiento = 0;
        this.descripcion = "";
        this.total = 0;
        this.idDepartamento = 0;
        this.fecha = "";
    }


    public int getIdMantenimiento() {
        return idMantenimiento;
    }


    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTotal() {
        return total;
    }


    public void setTotal(int total) {
        this.total = total;
    }


    public int getIdDepartamento() {
        return idDepartamento;
    }


    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }


    public String getFecha() {
        return fecha;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
