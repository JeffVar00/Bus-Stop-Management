/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.controlBus;
import controladores.journeyControl;
import gestores.gestorBuses;
import gestores.gestorViajes;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.bus;
import javax.swing.JOptionPane;

public class newJourney extends javax.swing.JFrame {
    
    private gestorBuses busesBD;
    private gestorViajes viajesBD;
    private journeyControl journeys;
    private controlBus buses;
    private bus B = null;
    private vistaPrincipal vistaPrincipal;
    
    public newJourney(journeyControl journeys, controlBus buses, vistaPrincipal vistaPrincipal, gestorBuses busesBD, gestorViajes viajesBD) {
        this.journeys = journeys;
        this.buses = buses;
        this.vistaPrincipal = vistaPrincipal;
        this.busesBD = busesBD; 
        this.viajesBD = viajesBD;
        initComponents();
        updateComboBox(this.buses);
    }
    
    private void updateComboBox(controlBus buses){
        for(int i = 0; i < buses.size(); i++){
            if(buses.get(i).available() == false){
                comboBoxBuses.addItem(buses.get(i).unit());
            }
        }
    }
    
    private bus getBus(){
        return this.B;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblDeparture = new javax.swing.JLabel();
        lblDistance = new javax.swing.JLabel();
        lblArrival = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblDTime = new javax.swing.JLabel();
        lblATime = new javax.swing.JLabel();
        txtDeparture = new javax.swing.JTextField();
        txtArrival = new javax.swing.JTextField();
        txtDistance = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtDTime = new javax.swing.JTextField();
        txtATime = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        comboBoxBuses = new javax.swing.JComboBox<>();
        tituloBus = new javax.swing.JLabel();
        lblUnit = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        botonSeleccionar = new javax.swing.JButton();
        lblDriver = new javax.swing.JLabel();
        txtState = new javax.swing.JLabel();
        txtUnit = new javax.swing.JLabel();
        txtDriver = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();

        setTitle("Agregar viaje");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 255));
        lblTitle.setText("Nuevo Viaje");

        lblDeparture.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDeparture.setText("Lugar de Salida:");

        lblDistance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDistance.setText("Distancia (KM):");

        lblArrival.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblArrival.setText("Lugar de Llegada:");

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDate.setText("Fecha:");

        lblDTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDTime.setText("Hora de Salida:");

        lblATime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblATime.setText("Hora de Llegada:");

        txtArrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArrivalActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 153, 153));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd.setText("Agregar Viaje");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPrice.setText("Precio por Asiento:");

        comboBoxBuses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxBusesActionPerformed(evt);
            }
        });

        tituloBus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tituloBus.setText("Buses:");

        lblUnit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUnit.setText("Numero de unidad:");

        lblState.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblState.setText("Estado:");

        botonSeleccionar.setBackground(new java.awt.Color(0, 153, 255));
        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarActionPerformed(evt);
            }
        });

        lblDriver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDriver.setText("Chofer:");

        lblCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCode.setText("Codigo de Viaje:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblDistance)
                        .addGap(18, 18, 18)
                        .addComponent(txtDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblArrival)
                            .addComponent(lblDTime)
                            .addComponent(lblATime))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(287, 287, 287)
                                .addComponent(lblUnit)
                                .addGap(12, 12, 12)
                                .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDTime, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(94, 94, 94)
                                        .addComponent(lblDriver)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtATime, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tituloBus)
                                        .addGap(10, 10, 10)
                                        .addComponent(comboBoxBuses, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(botonSeleccionar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDate)
                            .addComponent(lblCode))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloBus)
                            .addComponent(comboBoxBuses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonSeleccionar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCode)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblArrival, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDTime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblATime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtATime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtArrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArrivalActionPerformed

    }//GEN-LAST:event_txtArrivalActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
                if(this.B == null  ||  "".equals(txtCode.getText()) || "".equals(txtATime.getText()) || "".equals(txtArrival.getText()) || "".equals(txtDTime.getText()) || "".equals(txtDate.getText()) || "".equals(txtDeparture.getText()) ||"".equals(txtDistance.getText()) || "".equals(txtPrice.getText())){
                        JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
                }else{
                         try {
                                busesBD.actualizar(getBus(), txtCode.getText());
                                double d = Double.parseDouble(txtDistance.getText());
                                int p = Integer.parseInt(txtPrice.getText());
                                viajesBD.guardar(txtDeparture.getText(), txtArrival.getText(), d, txtDate.getText(), txtDTime.getText(), txtATime.getText(), p, Integer.parseInt(txtCode.getText()));
                                journeys.add(txtDeparture.getText(), txtArrival.getText(), d, txtDate.getText(), txtDTime.getText(), txtATime.getText(), p, Integer.parseInt(txtCode.getText()), getBus());
                                this.vistaPrincipal.initComboBox(this.journeys);
                                JOptionPane.showMessageDialog(null, "Se ha agregado un nuevo viaje");
                                setVisible(false);       
                        } catch (NumberFormatException excepcion) {
                               JOptionPane.showMessageDialog(null, "El precio, la distancia y el codigo deben ser un valor numerico, verifique estos campos");
                        } catch (Exception ex) {
                        Logger.getLogger(newJourney.class.getName()).log(Level.SEVERE, null, ex);
                    }
                         
                 }
    }//GEN-LAST:event_btnAddActionPerformed

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
               if("".equals(txtCode.getText())){
                    JOptionPane.showMessageDialog(null, "Ingrese un codigo de viaje, antes de seleccionar");
               }else if(comboBoxBuses.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "Segun parece no hay buses disponibles, vuelve o elige una opcion correcta");
               }else{
                     try {
                                String u = String.valueOf(comboBoxBuses.getSelectedItem());
                                B = buses.choose(u, Integer.parseInt(txtCode.getText()));
                                txtState.setText(B.state());
                                txtUnit.setText(B.unit());
                                txtDriver.setText(B.driver().getName());
                        } catch (NumberFormatException excepcion) {
                               JOptionPane.showMessageDialog(null, "El codigo debe ser un valor numerico");
                        }
               }
                
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void comboBoxBusesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxBusesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxBusesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> comboBoxBuses;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblATime;
    private javax.swing.JLabel lblArrival;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblDTime;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeparture;
    private javax.swing.JLabel lblDistance;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUnit;
    private javax.swing.JLabel tituloBus;
    private javax.swing.JTextField txtATime;
    private javax.swing.JTextField txtArrival;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDTime;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtDistance;
    private javax.swing.JLabel txtDriver;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JLabel txtState;
    private javax.swing.JLabel txtUnit;
    // End of variables declaration//GEN-END:variables
}
