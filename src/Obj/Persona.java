package Obj;

import java.io.Serializable;
import java.util.Objects;

public abstract class Persona implements Serializable {

    private String identificacion = "";
    private String nombre;
    private String telefono;
    private String direccion;

    public Persona(String id, String nombre, String tel, String dir) throws Exception {
        if (nombre.equals("".trim())) {
            throw new Exception("Valores no permitidos.");
        }
        this.identificacion = id;
        this.nombre = nombre;
        this.telefono = tel;
        this.direccion = dir;
    }

    public Persona(String id, String nom, String tel) throws Exception {
        if (nombre.equals("".trim())) {
            throw new Exception("Valores no permitidos.");
        }
        this.identificacion = id;
        this.nombre = nom;
        this.telefono = tel;
    }

    public Persona(String id, String nom) throws Exception {
        if (nombre.equals("".trim())) {
            throw new Exception("Valores no permitidos.");
        }
        this.identificacion = id;
        this.nombre = nom;
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
        int hash = 3;
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.identificacion, other.identificacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return identificacion + " - " + nombre;
    }

}
