package Obj;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    private String identificacion;
    private String nombre;

    public Persona(String id, String nombre) throws Exception {
        if (id.equals("".trim()) || nombre.equals("".trim())) {
            throw new Exception("No se permiten parametros vacios");
        }
        this.identificacion = id;
        this.nombre = nombre;
    }

    public Persona() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
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
