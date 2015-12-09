package Obj;

import java.io.Serializable;

public class Item implements Serializable {

    private int cantidad;
    private Producto producto;
    private double subtotal;

    public Item(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = (cantidad * producto.getCosto());
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return cantidad + " - " + producto + " = " + subtotal;
    }

}
