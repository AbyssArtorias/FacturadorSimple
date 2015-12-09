package Runnable;

import Gui.Login;
import Obj.Kardex;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            Kardex krdx = new Kardex("Empresa test");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Login(krdx).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
