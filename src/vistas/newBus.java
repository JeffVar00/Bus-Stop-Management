
package vistas;

import controladores.controlBus;
import controladores.controlDriver;
import gestores.gestorBuses;
import gestores.gestorChoferes;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.driver;
import javax.swing.JOptionPane;


public class newBus extends javax.swing.JFrame {

    private controlBus b;
    private controlDriver d;
    private gestorChoferes BD;
    private gestorBuses busesBD;
    private driver driver = null;
    
    public newBus(controlBus busList, controlDriver driverList, gestorChoferes choferesBD, gestorBuses busesBD) {
        b = busList;
        d = driverList;
        BD = choferesBD;
        this.busesBD = busesBD;
        initComponents();
    }

    private void loadDriver(){
        driver = d.choose(txtUnit.getText());
         if(driver == null){
             JOptionPane.showMessageDialog(null, "No hay choferes disponibles");
             setVisible(false);
        }else{
               textoNombre.setText(driver.getName());
        }
    }
    
    private driver getDriver(){
        return this.driver;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelAgregar = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblPlate = new javax.swing.JLabel();
        lblUnite = new javax.swing.JLabel();
        lblCapacity = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        txtPlate = new javax.swing.JTextField();
        txtUnit = new javax.swing.JTextField();
        txtCapacity = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        botonChofer = new javax.swing.JButton();
        tituloNombre = new javax.swing.JLabel();
        textoNombre = new javax.swing.JLabel();
        comboBoxEstado = new javax.swing.JComboBox<>();

        setTitle("Agregar Buses");

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        panelAgregar.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 255));
        lblTitle.setText("Nuevo Bus");

        lblPlate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPlate.setText("Placa:");

        lblUnite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUnite.setText("Codigo de la Unidad:");

        lblCapacity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCapacity.setText("Capacidad:");

        lblState.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblState.setText("Estado de la Unidad:");

        btnAdd.setBackground(new java.awt.Color(255, 153, 153));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Incluir en la flotilla");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        botonChofer.setBackground(new java.awt.Color(0, 153, 255));
        botonChofer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonChofer.setText("Asignar chofer");
        botonChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonChoferActionPerformed(evt);
            }
        });

        tituloNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tituloNombre.setText("Nombre:");

        comboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente", "Bueno", "Requiere Mantenimiento" }));
        comboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAgregarLayout = new javax.swing.GroupLayout(panelAgregar);
        panelAgregar.setLayout(panelAgregarLayout);
        panelAgregarLayout.setHorizontalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAgregarLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblState)))
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblCapacity))
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUnite))
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblPlate)))
                .addGap(35, 35, 35)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPlate, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(txtUnit)
                    .addComponent(txtCapacity)
                    .addComponent(comboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addComponent(tituloNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(botonChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAgregarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        panelAgregarLayout.setVerticalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitle)
                .addGap(32, 32, 32)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlate)
                    .addComponent(botonChofer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tituloNombre)
                        .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblUnite))
                .addGap(27, 27, 27)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCapacity))
                .addGap(27, 27, 27)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblState)
                    .addComponent(comboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        panelPrincipal.add(panelAgregar, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(driver == null || "".equals(txtPlate.getText()) || "".equals(txtUnit.getText()) || "".equals(txtCapacity.getText()) || comboBoxEstado.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Rellene todos los campos para contuniar");
        }else{
             try {
                    if(Integer.parseInt(txtCapacity.getText()) < 0 || Integer.parseInt(txtCapacity.getText()) > 40){
                         JOptionPane.showMessageDialog(null, "La capacidad introducida excede lo aceptado o no es valida");
                    }else{
                        busesBD.guardar(String.valueOf(comboBoxEstado.getSelectedItem()), txtPlate.getText(), txtUnit.getText(), Integer.parseInt(txtCapacity.getText()), -1);
                        BD.actualizar(getDriver(), txtUnit.getText());
                        b.add(String.valueOf(comboBoxEstado.getSelectedItem()), txtPlate.getText(), txtUnit.getText(), Integer.parseInt(txtCapacity.getText()), getDriver());
                        JOptionPane.showMessageDialog(null, "Se ha agregado un bus a la flotilla");
                        setVisible(false);
                    }
                } catch (NumberFormatException excepcion) {
                       JOptionPane.showMessageDialog(null, "Digite un valor numerico en capacidad");
                } catch (Exception ex) {
                Logger.getLogger(newBus.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void botonChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonChoferActionPerformed
        if("".equals(textoNombre.getText())){
              loadDriver();
        }
      
    }//GEN-LAST:event_botonChoferActionPerformed

    private void comboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonChofer;
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> comboBoxEstado;
    private javax.swing.JLabel lblCapacity;
    private javax.swing.JLabel lblPlate;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUnite;
    private javax.swing.JPanel panelAgregar;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtPlate;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
