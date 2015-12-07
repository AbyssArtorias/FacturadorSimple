package Runnable;

import javax.swing.UIManager;

import Gui.App;
import Gui.CrearInstancia;
import Gui.Login;
import Obj.Cliente;
import Obj.Kardex;
import Obj.Producto;
import Obj.Vendedor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        ObjectInputStream ois = null;
        File fl = null;
        BufferedWriter bf = null;
        Kardex krdx = null;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fl = new File("C:/Kardez.dat");
            if (fl.exists()) {
                System.out.println("Archivo existe");
                ois = new ObjectInputStream(new FileInputStream("C:/Kardez.dat"));
                krdx = (Kardex) ois.readObject();
            } else {
                bf = new BufferedWriter(new FileWriter(fl));
                new CrearInstancia().setVisible(true);
                System.out.println("Archivo creado con exito");
            }
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
//        Vendedor v = new Vendedor("123", "Vendedor test");
//        Producto[] productos = {
//            new Producto("C100", "Cobija de retazos", "Cobija 2metro color blanco", (float) 10000.0),
//            new Producto("T100", "Televisor 19inch", "Televisor LG 19inches", (float) 25000.0)
//        };
//        if (krdx == null) {
//            krdx = new Kardex();
//            try {
//                krdx.add(new Cliente("123", "Cliente test"));
//                krdx.add(v);
//                for (Producto ptmp : productos) {
//                    krdx.add(ptmp);
//                }
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//        }
        if (krdx != null) {
            new Login(krdx).setVisible(true);
        }
    }

}
