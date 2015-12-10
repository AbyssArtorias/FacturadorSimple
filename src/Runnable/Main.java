package Runnable;

import Gui.InitApp.CrearInstancia;
import Gui.Login;
import Obj.Kardex;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        String[] os = System.getProperty("os.name").split(" ");
        String home = System.getProperty("user.home");
        String ubicacion = "";
        File fl = null;
        ObjectInputStream ois = null;
        String nombreInstancia = "";
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            if ("Windows".equals(os[0])) {
                ubicacion = "C:/Kardex.dat";
            } else if ("Linux".equals(os[0])) {
                ubicacion = home + "/Documentos/Kardex.dat";
            }
            fl = new File(ubicacion);
            if (fl.exists()) {
                ois = new ObjectInputStream(new FileInputStream(fl));
                nombreInstancia = (String) ois.readObject();
                new Login(new Kardex(nombreInstancia)).setVisible(true);
            } else {
                new CrearInstancia(ubicacion).setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
