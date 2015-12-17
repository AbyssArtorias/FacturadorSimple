package Obj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Venta implements Serializable {

    private Empleado vendedor;
    private Cliente cliente = null;
    private Date fecha = new Date();
    private String idVenta;
    private boolean Activa = true;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Abono> abonos = new ArrayList<>();
    private double subtotal = 0;
    private double saldoPorPagar = 0;

    public Venta(String id, Empleado persona, Cliente cliente) {
        this.idVenta = id;
        this.vendedor = persona;
        this.cliente = cliente;
    }

    public Venta(String id, Empleado vendedor) {
        this.idVenta = id;
        this.vendedor = vendedor;
    }

    public Venta(String id) {
        this.idVenta = id;
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

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAbonos(ArrayList<Abono> abonos) {
        this.abonos = abonos;
    }

    public void setActiva(boolean Activa) {
        this.Activa = Activa;
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

    public ArrayList<Abono> getAbonos() {
        return abonos;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getSaldoPorPagar() {
        return saldoPorPagar;
    }

    public boolean isActiva() {
        return Activa;
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
        this.saldoPorPagar = this.subtotal += item.getSubtotal();
    }

    public void add(Abono abono) throws Exception {
        this.abonos.add(abono);
        this.saldoPorPagar -= abono.getTotalAbono();
        if (this.saldoPorPagar <= (double) 0) {
            this.Activa = false;
        }
    }

    public void remove(Item item) throws Exception {
        this.items.remove(item);
        this.saldoPorPagar = this.subtotal -= item.getSubtotal();
    }
}
