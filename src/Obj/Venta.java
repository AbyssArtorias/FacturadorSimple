package Obj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Venta implements Serializable {

    private Vendedor vendedor;
    private Cliente cliente = null;
    private Date fecha;
    private String idVenta;
    private ArrayList<Item> items = new ArrayList<>();
    private double subtotal = 0;

    public Venta(String id, Vendedor persona, Cliente cliente) {
        this.idVenta = id;
        this.vendedor = persona;
        this.cliente = cliente;
        this.fecha = new Date();
    }

    public Venta(String id) {
        this.idVenta = id;
        this.fecha = new Date();
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setValor(double valor) {
        this.subtotal = valor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idVenta == null) ? 0 : idVenta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Venta other = (Venta) obj;
        if (idVenta == null) {
            if (other.idVenta != null) {
                return false;
            }
        } else if (!idVenta.equals(other.idVenta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return idVenta + " : " + vendedor + " - " + cliente + " : " + sdf.format(fecha) + " = " + subtotal;
    }

    public void add(Item item) throws Exception {
        this.items.add(item);
        this.subtotal += item.getSubtotal();
    }

    public void remove(Item item) throws Exception {
        this.items.remove(item);
        this.subtotal -= item.getSubtotal();
    }
}
