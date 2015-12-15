package Obj;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {

    public String password;

    public Empleado(String id, String nombre, String tel, String dir, String password) {
        super(id, nombre, tel, dir);
        this.password = password;
    }

    public Empleado(String id, String nom, String tel) {
        super(id, nom, tel);
    }

    public Empleado(String id, String nombre, String tel, String dir) {
        super(id, nombre, tel, dir);
    }

    public Empleado() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
