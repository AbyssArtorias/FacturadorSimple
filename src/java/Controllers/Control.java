/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Ebj.VentasDAO;
import Obj.Venta;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Dildo__Queen
 */
@ManagedBean
@SessionScoped
public class Control {

    @EJB
    VentasDAO ventasDao;

    String stringFind;
    Long longId;
    List<Venta> listaVentas;
    Venta ventaActual;

    @PostConstruct
    public void init() {
        listaVentas = ventasDao.findAll();
        ventaActual = listaVentas.get(0);
    }

    public String doFindVenta() {
        ventaActual = ventasDao.findById(longId);
        return "index";
    }

    public String doNewVenta() {
        ventaActual = new Venta();
        return "nuevoCliente";
    }

    public String doSaveVenta() {
        ventasDao.create(ventaActual);
        return "index";
    }

    /**
     * Creates a new instance of Control
     */
    public Control() {
    }

    public void setStringFind(String stringFind) {
        this.stringFind = stringFind;
    }

    public VentasDAO getVentasDao() {
        return ventasDao;
    }

    public String getStringFind() {
        return stringFind;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public Venta getVentaActual() {
        return ventaActual;
    }

}
