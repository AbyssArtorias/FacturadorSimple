package Obj;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Empleado extends Persona implements Serializable {

    @Column(length = 255, nullable = true)
    private String password;

    public Empleado(String id, String nombre, String contraseña) throws Exception {
        super(id, nombre);
        this.password = contraseña;
    }

    public Empleado(String id, String nombre) throws Exception {
        super(id, nombre);
    }

    public Empleado() {
    }

    public void setPassword(String pass) throws Exception {
        if (pass.length() < 3) {
            throw new Exception("Contraseña debil");
        }
        this.password = pass;
    }

    public String getPassword() {
        return password;
    }

}
