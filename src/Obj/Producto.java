package Obj;

import java.io.Serializable;

public class Producto implements Serializable {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double costo;

    public Producto(String codigo, String nombre, String descripcion, float costo) throws Exception {
        if (codigo.equals("".trim()) || nombre.equals("".trim()) || descripcion.equals("".trim()) || "".trim().equals(costo)) {
            throw new Exception("No se permiten parametros vacios");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        Producto other = (Producto) obj;
        if (codigo == null) {
            if (other.codigo != null) {
                return false;
            }
        } else if (!codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + ": " + costo;
    }

    public void modify(String nombre, String descripcion, float costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }

}
