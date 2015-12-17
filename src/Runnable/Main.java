package Runnable;

import Gui.CrearInstancia;
import Gui.Login;
import Obj.Kardex;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

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
            String os[] = System.getProperty("os.name").split(" ");
            String us = System.getProperty("user.home");
            if ("Linux".equals(os[0])) {
                fl = new File(us + "/Documentos/Kardez.dat");
                if (fl.exists()) {
                    System.out.println("Archivo existe");
                    ois = new ObjectInputStream(new FileInputStream(us + "/Documentos/Kardez.dat"));
                    krdx = (Kardex) ois.readObject();
                    JOptionPane.showMessageDialog(null, "Archivos binarios curruptos, por favor eliminar el archivo C:\\Kardex.dat", "Crear Instancia", JOptionPane.ERROR_MESSAGE);
                } else {
                    bf = new BufferedWriter(new FileWriter(fl));
                    new CrearInstancia().setVisible(true);
                    //System.out.println("Archivo creado con exito");
                }
            } else if ("Windows".equals(os[0])) {
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
            }
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Datos binarios curruptos, por favor eliminar el archivo C:\\Kardez.dat\n" + e.getLocalizedMessage() + "\n" + e.getMessage(), "Crear instancia", JOptionPane.ERROR_MESSAGE);
        }
        if (krdx != null) {
            new Login(krdx).setVisible(true);
        }
    }

}
