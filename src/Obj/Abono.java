/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obj;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Dildo__Queen
 */
public class Abono implements Serializable {

    private Date fecha;
    private Empleado empld;
    private double totalAbono;

    public Abono(Date fecha, Empleado empleado, double totalAbono) {
        this.fecha = fecha;
        this.empld = empleado;
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

    public void setEmpld(Empleado empld) {
        this.empld = empld;
    }

    public Date getFecha() {
        return fecha;
    }

    public Empleado getEmpld() {
        return empld;
    }

    public double getTotalAbono() {
        return totalAbono;
    }

}
