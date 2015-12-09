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

    private EmpleadoJpaController empleadoJPA = new EmpleadoJpaController(emf);
    private ClienteJpaController clienteJPA = new ClienteJpaController(emf);
    private ProductoJpaController productoJPA = new ProductoJpaController(emf);
    private VentaJpaController ventaJPA = new VentaJpaController(emf);

    public Kardex(String id) throws Exception {
        if (id.equals("".trim())) {
            throw new Exception("No se permiten parametros vacios");
        }
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

    public Empleado findEmpleado(String id) throws Exception {
        return empleadoJPA.findEmpleado(id);
    }

    public Cliente findCliente(String id) throws Exception {
        return clienteJPA.findCliente(id);
    }

    public List<Cliente> getClientes() {
        return clienteJPA.findClienteEntities();
    }

    public Producto findProducto(String codigo) throws Exception {
        return productoJPA.findProducto(codigo);
    }

    public List<Producto> getProductos() throws Exception {
        return productoJPA.findProductoEntities();
    }

    public Venta findVenta(Long id) throws Exception {
        return ventaJPA.findVenta(id);
    }

    public List<Venta> getVentas() throws Exception {
        return ventaJPA.findVentaEntities();
    }

}
