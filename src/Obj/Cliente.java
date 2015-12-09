package Obj;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {

    public Cliente(String id, String nombre) throws Exception {
        super(id, nombre);
    }

    public Cliente() {
        super();
    }

}
