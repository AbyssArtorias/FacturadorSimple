package Obj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public Venta(Empleado persona, Cliente cliente, Date date) {
        this.vendedor = persona;
        this.cliente = cliente;
        this.fecha = date;
    }

    public Venta(Date date) {
        this.fecha = date;
    }

    public Venta() {
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getId() {
        return id;
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
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return id + " : " + vendedor + " - " + cliente + " : " + sdf.format(fecha) + " = " + subtotal;
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
