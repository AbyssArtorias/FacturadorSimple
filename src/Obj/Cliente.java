package Obj;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {

    public Cliente(String id, String nombre, String tel, String dir) throws Exception {
        super(id, nombre, tel, dir);
    }

    public Cliente(String id, String nom, String tel) throws Exception {
        super(id, nom, tel);
    }

    public Cliente(String id, String nom) throws Exception {
        super(id, nom);
    }

    public Cliente() {
    }

}
