/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.journeyControl;
import modelos.clientTable;
import modelos.journey;

public class clientTableJFrame extends javax.swing.JFrame {

    private journey journeySelected;
    private journeyControl  control;
    private clientTable table;
    
    public clientTableJFrame(journey journey) {
        journeySelected = journey;
        control = new journeyControl();
        table = new clientTable(control.clients(journeySelected));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollClient = new javax.swing.JScrollPane();
        tableClient = new javax.swing.JTable();

        setTitle("Pasajeros");

        scrollClient.setBackground(new java.awt.Color(255, 255, 255));

        tableClient.setModel(table);
        scrollClient.setViewportView(tableClient);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollClient, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollClient;
    private javax.swing.JTable tableClient;
    // End of variables declaration//GEN-END:variables
}
