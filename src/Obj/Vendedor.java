package Obj;

import java.io.Serializable;

public class Vendedor extends Persona implements Serializable {

    public String password;

    public Vendedor(String id, String nombre, String contraseña) throws Exception {
        super(id, nombre);
        this.password = contraseña;
    }

    public Vendedor(String id, String nombre) throws Exception {
        super(id, nombre);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
