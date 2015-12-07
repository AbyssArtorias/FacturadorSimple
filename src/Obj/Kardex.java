package Obj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Kardex implements Serializable {

    private String nombre;
    private ArrayList<Vendedor> vendedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Venta> ventas = new ArrayList<>();
    private int idVenta = 1;

    public Kardex(String id) {
        this.nombre = id;
    }

    public Kardex() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setVendedores(ArrayList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public int getIdVenta() {
        return idVenta;
    }

    @Override
    public String toString() {
        return "Kardex: " + nombre;
    }

    public void add(Vendedor vendedor) throws Exception {
        if (this.vendedores.contains(vendedor)) {
            throw new Exception("Elemento ya incluido en el programa");
        }
        this.vendedores.add(vendedor);
    }

    public void add(Cliente cliente) throws Exception {
        if (this.clientes.contains(cliente)) {
            throw new Exception("Elemento ya incluido en el programa");
        }
        this.clientes.add(cliente);
    }

    public void add(Producto producto) throws Exception {
        if (this.productos.contains(producto)) {
            throw new Exception("Elemento ya incluido en el programa");
        }
        this.productos.add(producto);
    }

    public void add(Venta venta) throws Exception {
        if (this.ventas.contains(venta)) {
            throw new Exception("Error en id de ventas");
        }
        this.ventas.add(venta);
    }

    public Producto findProducto(String codigo) throws Exception {
        for (Producto producto : this.productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        throw new Exception("Producto no encontrado");
    }

    public ArrayList<Producto> findProductos(String nombre) throws Exception {
        ArrayList<Producto> ptmp = new ArrayList<>();
        for (Producto producto : this.productos) {
            ptmp.add(producto);
        }
        if (ptmp.isEmpty()) {
            throw new Exception("Ningun elemento coincide con la busqueda");
        }
        return ptmp;
    }

    public Venta findVenta(String id) throws Exception {
        for (Venta venta : this.ventas) {
            if (venta.getIdVenta().equals(id)) {
                return venta;
            }
        }
        throw new Exception("Ningun elemento coincide con la busqueda");
    }

    public ArrayList<Venta> findVentas(String dia, String mes, String año) throws Exception {
        ArrayList<Venta> vtmp = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Venta venta : this.ventas) {
            if (venta.getFecha().equals(sdf.parse(dia + "/" + mes + "/" + año))) {
                vtmp.add(venta);
            }
        }
        if (vtmp.isEmpty()) {
            throw new Exception("Ningun elemento coincide con la busqueda");
        }
        return vtmp;
    }

    public ArrayList<Venta> findVentas(Date fecha) throws Exception {
        ArrayList<Venta> vtmp = new ArrayList<>();
        for (Venta venta : this.ventas) {
            if (venta.getFecha().equals(fecha)) {
                vtmp.add(venta);
            }
        }
        if (vtmp.isEmpty()) {
            throw new Exception("Ningun elemento coincide con la busqueda");
        }
        return vtmp;
    }

    public ArrayList<Venta> findVenta(Date fecha, Cliente cliente) throws Exception {
        ArrayList<Venta> vtmp = new ArrayList<>();
        for (Venta venta : this.ventas) {
            if (venta.getFecha().equals(fecha) && venta.getCliente().equals(cliente)) {
                vtmp.add(venta);
            }
        }
        if (vtmp.isEmpty()) {
            throw new Exception("Ningun elemento coincide con la busqueda");
        }
        return vtmp;
    }

    public ArrayList<Venta> findVenta(Date fecha, Cliente cliente, Vendedor vendedor) throws Exception {
        ArrayList<Venta> vtmp = new ArrayList<>();
        for (Venta venta : this.ventas) {
            if (venta.getFecha().equals(fecha) && venta.getCliente().equals(cliente)
                    && venta.getVendedor().equals(vendedor)) {
                vtmp.add(venta);
            }
        }
        if (vtmp.isEmpty()) {
            throw new Exception("Ningun elemento coincide con la busqueda");
        }
        return vtmp;
    }

    public Vendedor findVendedor(String id) throws Exception {
        for (Vendedor vendedor : this.vendedores) {
            if (vendedor.getIdentificacion().equals(id)) {
                return vendedor;
            }
        }
        throw new Exception("Ningun elemento coincide con la busqueda");
    }

    public Cliente findCliente(String id) throws Exception {
        for (Cliente cliente : this.clientes) {
            if (cliente.getIdentificacion().equals(id)) {
                return cliente;
            }
        }
        throw new Exception("Ningun elemento coincide con la busqueda");
    }

    public void siguienteIdVenta() {
        this.idVenta++;
    }
}
