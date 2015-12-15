package Obj;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    private String identificacion;
    private String nombre;
    private String telefono;
    private String direccion;

    public Persona(String id, String nombre, String tel, String dir) {
        this.identificacion = id;
        this.nombre = nombre;
        this.telefono = tel;
        this.direccion = dir;
    }

    public Persona(String id, String nom, String tel) {
        this.identificacion = id;
        this.nombre = nom;
        this.telefono = tel;
    }

    public Persona(String nom, String tel) {
        this.nombre = nom;
        this.telefono = tel;
    }

    public Persona() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
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
        Persona other = (Persona) obj;
        if (identificacion == null) {
            if (other.identificacion != null) {
                return false;
            }
        } else if (!identificacion.equals(other.identificacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return identificacion + " - " + nombre;
    }

}
