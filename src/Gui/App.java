/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Obj.Empleado;
import Obj.Kardex;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;

/**
 *
 * @author Dildo__Queen
 */
public class App extends javax.swing.JFrame {

    private Kardex krdx = null;
    private Empleado venddr = null;
    public RealizarVenta rVenta = null;
    private Productos prodcts = null;
    private Clientes clints = null;
    public Ventas vents = null;

    /**
     *
     * @param kardex
     * @param vendedor
     */
    public App(Kardex kardex, Empleado vendedor) {
        this.krdx = kardex;
        this.venddr = vendedor;
        this.rVenta = new RealizarVenta(this.krdx, this.venddr, this);
        this.prodcts = new Productos(this.krdx, this.venddr, this);
        this.clints = new Clientes(this.krdx, this.venddr);
        this.vents = new Ventas(this.krdx, this.venddr, this);
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/Media/003.png")).getImage();
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        tbpPrincipal.add(rVenta);
        tbpPrincipal.setTitleAt(0, "Realizar venta");
        tbpPrincipal.add(prodcts);
        tbpPrincipal.setTitleAt(1, "Productos");
        tbpPrincipal.add(clints);
        tbpPrincipal.setTitleAt(2, "Clientes");
        tbpPrincipal.add(vents);
        tbpPrincipal.setTitleAt(3, "Ventas");
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                ObjectOutputStream oos = null;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream("C:/Kardez.dat"));
                    oos.writeObject(krdx);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpPrincipal = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(krdx.getNombre());
        setMinimumSize(new java.awt.Dimension(600, 700));
        setPreferredSize(new java.awt.Dimension(600, 700));
        setSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tbpPrincipal;
    // End of variables declaration//GEN-END:variables
}
