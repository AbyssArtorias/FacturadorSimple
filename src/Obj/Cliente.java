package Obj;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {

	public Cliente(String id, String nombre) {
		super(id, nombre);
	}
        
        public Cliente(){
            super();
        }

}
