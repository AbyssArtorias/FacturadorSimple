/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obj;

import java.util.Date;

/**
 *
 * @author Dildo__Queen
 */
public class Abono {

    private Date fecha;
    private double totalAbono;

    public Abono(Date fecha, double totalAbono) {
        this.fecha = fecha;
        this.totalAbono = totalAbono;
    }

    public Abono() {
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTotalAbono(double totalAbono) {
        this.totalAbono = totalAbono;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getTotalAbono() {
        return totalAbono;
    }

}
