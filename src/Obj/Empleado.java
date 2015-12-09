package Obj;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "emp.id", query = "SELECT e FROM Persona e WHERE e.identificacion = :identificacion")
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
