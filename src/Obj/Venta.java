package Obj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {

    @Id
    private String idVenta;
    @OneToOne
    private Empleado vendedor;
    @OneToOne(optional = true)
    private Cliente cliente = null;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany
    private List<Item> items = new ArrayList<>();
    @Column
    private double subtotal = 0;

    public Venta(String id, Empleado persona, Cliente cliente) {
        this.idVenta = id;
        this.vendedor = persona;
        this.cliente = cliente;
        this.fecha = new Date();
    }

    public Venta(String id) {
        this.idVenta = id;
        this.fecha = new Date();
    }

    public Venta() {
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
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
