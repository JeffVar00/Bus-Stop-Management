
package vistas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import modelos.comissionList;
import modelos.comissionTable;

public class comissionTableView extends javax.swing.JFrame {
    private comissionTable table;
    private TableRowSorter trs;
    
    public comissionTableView(comissionList comissions) {
        table = new comissionTable(comissions);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        scrollComission = new javax.swing.JScrollPane();
        tableComission = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        textoFiltroCodigo = new javax.swing.JTextField();
        textoFiltroCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton2.setText("Buscar por cliente");

        jButton1.setText("Buscar por codigo");

        setTitle("Encomiendas");

        tableComission.setModel(table);
        scrollComission.setViewportView(tableComission);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textoFiltroCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoFiltroCodigoActionPerformed(evt);
            }
        });
        textoFiltroCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltroCodigoKeyTyped(evt);
            }
        });

        textoFiltroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoFiltroClienteActionPerformed(evt);
            }
        });
        textoFiltroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltroClienteKeyTyped(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

        jLabel2.setText("Codigo de Viaje");

        jLabel3.setText("Persona que dejo el paquete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(textoFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel2)))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(textoFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(927, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollComission)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollComission, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoFiltroCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoFiltroCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoFiltroCodigoActionPerformed
 
     
     
    private void textoFiltroCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltroCodigoKeyTyped
        
        textoFiltroCodigo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
               trs.setRowFilter(RowFilter.regexFilter(textoFiltroCodigo.getText(), 0));
            }
        });
        
        trs = new TableRowSorter(table);
        tableComission.setRowSorter(trs);
       
    }//GEN-LAST:event_textoFiltroCodigoKeyTyped

    private void textoFiltroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoFiltroClienteActionPerformed
      
    }//GEN-LAST:event_textoFiltroClienteActionPerformed

    private void textoFiltroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltroClienteKeyTyped
        textoFiltroCliente.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
               trs.setRowFilter(RowFilter.regexFilter("(?i)"+textoFiltroCliente.getText(), 10));
            }
        });
        
        trs = new TableRowSorter(table);
        tableComission.setRowSorter(trs);
        //https://www.youtube.com/watch?v=7CDV9IJMifw
    }//GEN-LAST:event_textoFiltroClienteKeyTyped



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollComission;
    private javax.swing.JTable tableComission;
    private javax.swing.JTextField textoFiltroCliente;
    private javax.swing.JTextField textoFiltroCodigo;
    // End of variables declaration//GEN-END:variables
}
