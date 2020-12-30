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
public class CheckOut {
    
    private int idCheckIn;
    private String fecha;
    private int idRecursoHumano;

    public int getIdCheckIn() {
        return idCheckIn;
    }

    public void setIdCheckIn(int idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdRecursoHumano() {
        return idRecursoHumano;
    }

    public void setIdRecursoHumano(int idRecursoHumano) {
        this.idRecursoHumano = idRecursoHumano;
    }
}
