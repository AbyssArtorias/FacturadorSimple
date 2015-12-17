/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obj;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dildo__Queen
 */
@Entity
public class Abono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToOne
    private Empleado empld;
    @Column
    private double totalAbono;

    public Abono(Date fecha, Empleado empleado, double totalAbono) {
        this.fecha = fecha;
        this.empld = empleado;
        this.totalAbono = totalAbono;
    }

    public Abono() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEmpld(Empleado empld) {
        this.empld = empld;
    }

    public void setTotalAbono(double totalAbono) {
        this.totalAbono = totalAbono;
    }

    public Long getId() {
        return id;
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
