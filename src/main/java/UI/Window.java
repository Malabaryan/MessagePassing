/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.UiController;
import javax.swing.JTextArea;

/**
 *
 * @author Kenneth
 */
public class Window extends javax.swing.JFrame {

    /**
     * Creates new form Window
     */
    
    private UiController controller;
    
    public Window(UiController pController) {
        controller = pController;
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_allprocesses = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_selectedprocesses = new javax.swing.JTextArea();
        btn_update = new javax.swing.JButton();
        combo_processesSelected = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_command = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 800));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel3.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Processes");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 11, 92, 24);

        jLabel6.setText("Process");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(360, 50, 50, 16);

        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        jPanel11.setLayout(null);

        jLabel9.setText("All Processes");
        jPanel11.add(jLabel9);
        jLabel9.setBounds(10, 10, 79, 16);

        txt_allprocesses.setColumns(20);
        txt_allprocesses.setRows(5);
        jScrollPane3.setViewportView(txt_allprocesses);

        jPanel11.add(jScrollPane3);
        jScrollPane3.setBounds(10, 25, 318, 180);

        jPanel10.add(jPanel11);

        jLabel10.setText("Selected Process");

        txt_selectedprocesses.setColumns(20);
        txt_selectedprocesses.setRows(5);
        jScrollPane4.setViewportView(txt_selectedprocesses);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.add(jPanel12);

        jPanel9.add(jPanel10);

        jPanel3.add(jPanel9);
        jPanel9.setBounds(10, 70, 660, 408);

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel3.add(btn_update);
        btn_update.setBounds(610, 40, 70, 32);
        jPanel3.add(combo_processesSelected);
        combo_processesSelected.setBounds(420, 40, 190, 26);

        jLabel5.setText("Execute");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 40, 46, 16);
        jPanel3.add(txt_command);
        txt_command.setBounds(80, 40, 200, 24);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(280, 40, 70, 32);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.controller.sendCommand(this.txt_command.getText());
        this.controller.updateAll(txt_allprocesses);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        this.combo_processesSelected.removeAllItems();
        for(String str : this.controller.getController().getProcessesStringArrayList()){
            this.combo_processesSelected.addItem(str);
        }
        String processSelected = this.combo_processesSelected.getItemAt(combo_processesSelected.getSelectedIndex());
        
        this.controller.updateTextField(this.txt_selectedprocesses, this.controller.getLogOf(processSelected).toString());
        this.controller.updateAll(this.txt_allprocesses);
    }//GEN-LAST:event_btn_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_processesSelected;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea txt_allprocesses;
    private javax.swing.JTextField txt_command;
    private javax.swing.JTextArea txt_selectedprocesses;
    // End of variables declaration//GEN-END:variables
}
