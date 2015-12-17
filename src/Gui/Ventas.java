/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Obj.Empleado;
import Obj.Kardex;
import Obj.Venta;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dildo__Queen
 */
public class Ventas extends javax.swing.JPanel {

    private Kardex krdx;
    private App appRun;
    private Empleado empld;

    /**
     *
     * @param kardex
     * @param empleado
     */
    public Ventas(Kardex kardex, Empleado empleado, App app) {
        this.krdx = kardex;
        this.empld = empleado;
        this.appRun = app;
        initComponents();
        init();
    }

    public void init() {
        tblTodasLasVentas.setModel(new AbstractTableModel() {
            String[] nmColumnas = {"Fecha", "idVenta", "Cliente", "Total", "Saldo a pagar"};

            @Override
            public String getColumnName(int column) {
                return nmColumnas[column];
            }

            @Override
            public int getRowCount() {
                if (krdx.getVentas().isEmpty()) {
                    return 0;
                }
                return krdx.getVentas().size();
            }

            @Override
            public int getColumnCount() {
                return nmColumnas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                Venta vtmp = krdx.getVentas().get(rowIndex);
                if (columnIndex == 0) {
                    return f.format(vtmp.getFecha());
                } else if (columnIndex == 1) {
                    return vtmp.getIdVenta();
                } else if (columnIndex == 2) {
                    if (vtmp.getCliente() == null) {
                        return "Anonimo";
                    }
                    return vtmp.getCliente().toString();
                } else if (columnIndex == 3) {
                    return vtmp.getSubtotal();
                } else if (columnIndex == 4) {
                    return vtmp.getSaldoPorPagar();
                }
                return "";
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

        pnlTodasLasVentas = new javax.swing.JPanel();
        btnAbono = new javax.swing.JButton();
        scpTodasLasVentas = new javax.swing.JScrollPane();
        tblTodasLasVentas = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(472, 600));

        pnlTodasLasVentas.setBorder(javax.swing.BorderFactory.createTitledBorder("Todas las ventas"));

        btnAbono.setText("Nuevo abono");
        btnAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtNuevoAbono(evt);
            }
        });

        tblTodasLasVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scpTodasLasVentas.setViewportView(tblTodasLasVentas);

        javax.swing.GroupLayout pnlTodasLasVentasLayout = new javax.swing.GroupLayout(pnlTodasLasVentas);
        pnlTodasLasVentas.setLayout(pnlTodasLasVentasLayout);
        pnlTodasLasVentasLayout.setHorizontalGroup(
            pnlTodasLasVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTodasLasVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTodasLasVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpTodasLasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTodasLasVentasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAbono)))
                .addContainerGap())
        );
        pnlTodasLasVentasLayout.setVerticalGroup(
            pnlTodasLasVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTodasLasVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpTodasLasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTodasLasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTodasLasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EvtNuevoAbono(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtNuevoAbono
        try {
            Venta vtmp = krdx.getVentas().get(tblTodasLasVentas.getSelectedRow());
            if (vtmp.isActiva()) {
                new RealizarAbono(appRun, vtmp, empld).setVisible(true);
            }
        } catch (Exception e) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage(), this.krdx.getNombre() + "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EvtNuevoAbono


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbono;
    private javax.swing.JPanel pnlTodasLasVentas;
    private javax.swing.JScrollPane scpTodasLasVentas;
    public javax.swing.JTable tblTodasLasVentas;
    // End of variables declaration//GEN-END:variables
}