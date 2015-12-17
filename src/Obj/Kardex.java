package Obj;

import Jpa.ClienteJpaController;
import Jpa.EmpleadoJpaController;
import Jpa.ProductoJpaController;
import Jpa.VentaJpaController;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Kardex implements Serializable {

    private String nombre;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FSPU");

    private EmpleadoJpaController empleadoJPA = null;
    private ClienteJpaController clienteJPA = null;
    private ProductoJpaController productoJPA = null;
    private VentaJpaController ventaJPA = null;

    public Kardex(String id) throws Exception {
        if (id.equals("".trim())) {
            throw new Exception("No se permiten parametros vacios");
        }
        this.nombre = id;
        init();
    }

    public Kardex() {
        init();
    }

    public void init() {
        empleadoJPA = new EmpleadoJpaController(emf);
        clienteJPA = new ClienteJpaController(emf);
        productoJPA = new ProductoJpaController(emf);
        ventaJPA = new VentaJpaController(emf);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Kardex: " + nombre;
    }

    public void add(Empleado vendedor) throws Exception {
        empleadoJPA.create(vendedor);
    }

    public void add(Cliente cliente) throws Exception {
        clienteJPA.create(cliente);
    }

    public void add(Producto producto) throws Exception {
        productoJPA.create(producto);
    }

    public void add(Venta venta) throws Exception {
        ventaJPA.create(venta);
    }

    public Empleado accesoEmpleado(String id, String pass) throws Exception {
        Empleado etmp = empleadoJPA.findEmpleado(id);
        if (etmp.getPassword().equals(pass)) {
            return etmp;
        }
        throw new Exception("Error: accesoEmpleado");
    }

    public Empleado findEmpleado(String id) throws Exception {
        return empleadoJPA.findEmpleado(id);
    }

    public Cliente findCliente(String id) throws Exception {
        return clienteJPA.findCliente(id);
    }

    public Producto findProducto(String codigo) throws Exception {
        return productoJPA.findProducto(codigo);
    }

    public Venta findVenta(Long id) throws Exception {
        return ventaJPA.findVenta(id);
    }

    public List<Cliente> getClientes() {
        return clienteJPA.findClienteEntities();
    }

    public List<Producto> getProductos() throws Exception {
        return productoJPA.findProductoEntities();
    }

    public List<Venta> getVentas() throws Exception {
        return ventaJPA.findVentaEntities();
    }

    public void edit(Venta venta) throws Exception {
        ventaJPA.edit(venta);
    }
}
