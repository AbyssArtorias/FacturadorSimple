package Obj;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Cliente extends Persona implements Serializable {

    public Cliente(String id, String nombre) throws Exception {
        super(id, nombre);
    }

    public Cliente() {
        super();
    }

}
