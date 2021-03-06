/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.ParameterState;
import Controller.ParametersController;
import Controller.UiController;

public class Setup extends javax.swing.JFrame {
    
    private UiController controller;
    
    public Setup(UiController pController) {
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

        radiogroup_syncSend = new javax.swing.ButtonGroup();
        radiogroup_syncreceive = new javax.swing.ButtonGroup();
        radiogroup_addressing = new javax.swing.ButtonGroup();
        radiogroup_lenght = new javax.swing.ButtonGroup();
        radiogroup_queue = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        r_syncReceiProofOFArrival = new javax.swing.JRadioButton();
        r_syncReceNonBlock = new javax.swing.JRadioButton();
        r_syncReceiveBlocking = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        r_addreDirectImplicit = new javax.swing.JRadioButton();
        r_addresDirectExplicit = new javax.swing.JRadioButton();
        r_addressIndirectStatic = new javax.swing.JRadioButton();
        r_addreIndirectdynamic = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        r_lenghtVariable = new javax.swing.JRadioButton();
        r_lenghtFixed = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        r_queueFifo = new javax.swing.JRadioButton();
        r_queuePriority = new javax.swing.JRadioButton();
        btn_simulationStart = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        spin_noProcesses = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        spin_fixed = new javax.swing.JSpinner();
        spin_maxQueueLenght = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 720));
        setPreferredSize(new java.awt.Dimension(720, 720));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Parameters");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Syncronization Receive");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 160, 180, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Non Blocking");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 120, 120, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Blocking");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 100, 110, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Proof of Arrival");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 230, 150, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Blocking");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(120, 190, 140, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Non Blocking");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(120, 210, 140, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Addressing ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(80, 290, 180, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Implicit");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(200, 380, 70, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Direct");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(120, 320, 180, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Receive");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(160, 340, 180, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Explicit");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(200, 360, 70, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Indirect");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(110, 400, 180, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Static");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(150, 420, 120, 20);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Dynamic");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(150, 440, 110, 20);

        radiogroup_syncSend.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(280, 100, 21, 21);

        radiogroup_syncreceive.add(r_syncReceiProofOFArrival);
        r_syncReceiProofOFArrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_syncReceiProofOFArrivalActionPerformed(evt);
            }
        });
        getContentPane().add(r_syncReceiProofOFArrival);
        r_syncReceiProofOFArrival.setBounds(280, 230, 21, 21);

        radiogroup_syncreceive.add(r_syncReceNonBlock);
        r_syncReceNonBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_syncReceNonBlockActionPerformed(evt);
            }
        });
        getContentPane().add(r_syncReceNonBlock);
        r_syncReceNonBlock.setBounds(280, 210, 21, 21);

        radiogroup_syncreceive.add(r_syncReceiveBlocking);
        r_syncReceiveBlocking.setSelected(true);
        r_syncReceiveBlocking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_syncReceiveBlockingActionPerformed(evt);
            }
        });
        getContentPane().add(r_syncReceiveBlocking);
        r_syncReceiveBlocking.setBounds(280, 190, 21, 21);

        radiogroup_syncSend.add(jRadioButton5);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(280, 120, 21, 21);

        radiogroup_addressing.add(r_addreDirectImplicit);
        r_addreDirectImplicit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_addreDirectImplicitActionPerformed(evt);
            }
        });
        getContentPane().add(r_addreDirectImplicit);
        r_addreDirectImplicit.setBounds(270, 380, 21, 21);

        radiogroup_addressing.add(r_addresDirectExplicit);
        r_addresDirectExplicit.setSelected(true);
        r_addresDirectExplicit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_addresDirectExplicitActionPerformed(evt);
            }
        });
        getContentPane().add(r_addresDirectExplicit);
        r_addresDirectExplicit.setBounds(270, 360, 21, 21);

        radiogroup_addressing.add(r_addressIndirectStatic);
        r_addressIndirectStatic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_addressIndirectStaticActionPerformed(evt);
            }
        });
        getContentPane().add(r_addressIndirectStatic);
        r_addressIndirectStatic.setBounds(270, 420, 21, 21);

        radiogroup_addressing.add(r_addreIndirectdynamic);
        r_addreIndirectdynamic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_addreIndirectdynamicActionPerformed(evt);
            }
        });
        getContentPane().add(r_addreIndirectdynamic);
        r_addreIndirectdynamic.setBounds(270, 440, 21, 21);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("No. Processes");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(430, 160, 180, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Format");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(80, 510, 180, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Variable");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(150, 590, 70, 20);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Lenght");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(120, 540, 180, 20);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Fixed");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(150, 570, 70, 20);

        radiogroup_lenght.add(r_lenghtVariable);
        r_lenghtVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_lenghtVariableActionPerformed(evt);
            }
        });
        getContentPane().add(r_lenghtVariable);
        r_lenghtVariable.setBounds(220, 590, 21, 21);

        radiogroup_lenght.add(r_lenghtFixed);
        r_lenghtFixed.setSelected(true);
        r_lenghtFixed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_lenghtFixedActionPerformed(evt);
            }
        });
        getContentPane().add(r_lenghtFixed);
        r_lenghtFixed.setBounds(220, 570, 21, 21);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Queue");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(430, 70, 180, 20);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("FIFO");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(470, 90, 120, 20);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Priority");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(470, 110, 110, 20);

        radiogroup_queue.add(r_queueFifo);
        r_queueFifo.setSelected(true);
        r_queueFifo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_queueFifoActionPerformed(evt);
            }
        });
        getContentPane().add(r_queueFifo);
        r_queueFifo.setBounds(590, 90, 21, 21);

        radiogroup_queue.add(r_queuePriority);
        r_queuePriority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_queuePriorityActionPerformed(evt);
            }
        });
        getContentPane().add(r_queuePriority);
        r_queuePriority.setBounds(590, 110, 21, 21);

        btn_simulationStart.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_simulationStart.setText("Start Simulation");
        btn_simulationStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simulationStartActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simulationStart);
        btn_simulationStart.setBounds(520, 580, 160, 31);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(390, 80, 20, 530);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Syncronization Send");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(80, 70, 180, 20);
        getContentPane().add(spin_noProcesses);
        spin_noProcesses.setBounds(580, 160, 80, 20);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Max Queue Lenght");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(430, 200, 180, 20);
        getContentPane().add(spin_fixed);
        spin_fixed.setBounds(250, 570, 80, 20);
        getContentPane().add(spin_maxQueueLenght);
        spin_maxQueueLenght.setBounds(580, 200, 80, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        ParametersController.setSyncronization_Send(ParameterState.Sync_Send_Blocking);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    
    private void r_syncReceiveBlockingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_syncReceiveBlockingActionPerformed
        // TODO add your handling code here:
        ParametersController.setSyncronization_Receive(ParameterState.Sync_Receive_Blocking);
    }//GEN-LAST:event_r_syncReceiveBlockingActionPerformed

    private void r_addresDirectExplicitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_addresDirectExplicitActionPerformed
        // TODO add your handling code here:
        ParametersController.setAddressing_Receive(ParameterState.Addr_Direct_Receive_Explicit);
        ParametersController.setAddressing_Send(ParameterState.Addr_Direct_Send);
    }//GEN-LAST:event_r_addresDirectExplicitActionPerformed

    private void r_addressIndirectStaticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_addressIndirectStaticActionPerformed
        // TODO add your handling code here:
        ParametersController.setAddressing_Receive(ParameterState.Addr_Indirect_Static);
        ParametersController.setAddressing_Send(ParameterState.Addr_Indirect_Static);
    }//GEN-LAST:event_r_addressIndirectStaticActionPerformed

    private void r_lenghtFixedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_lenghtFixedActionPerformed
        // TODO add your handling code here:
        ParametersController.setFormat(ParameterState.Form_Lenght_Fixed);
    }//GEN-LAST:event_r_lenghtFixedActionPerformed

    private void r_queueFifoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_queueFifoActionPerformed
        // TODO add your handling code here:
        ParametersController.setQueueStrategy(ParameterState.Queue_FIFO);
    }//GEN-LAST:event_r_queueFifoActionPerformed

    private void btn_simulationStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simulationStartActionPerformed
        // TODO add your handling code here:
        this.controller.startSimulation((int)this.spin_fixed.getValue(),(int)this.spin_noProcesses.getValue(),(int)this.spin_maxQueueLenght.getValue());
        System.out.println(this.controller.getController().getProcessesString());
        this.controller.showMainWindow();
    }//GEN-LAST:event_btn_simulationStartActionPerformed

    private void r_queuePriorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_queuePriorityActionPerformed
        // TODO add your handling code here:
        ParametersController.setQueueStrategy(ParameterState.Queue_Priority);
    }//GEN-LAST:event_r_queuePriorityActionPerformed

    private void r_lenghtVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_lenghtVariableActionPerformed
        // TODO add your handling code here:
        ParametersController.setFormat(ParameterState.Form_Lenght_Variable);
    }//GEN-LAST:event_r_lenghtVariableActionPerformed

    private void r_addreIndirectdynamicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_addreIndirectdynamicActionPerformed
        // TODO add your handling code here:
        ParametersController.setAddressing_Receive(ParameterState.Addr_Indirect_Dynamic);
        ParametersController.setAddressing_Send(ParameterState.Addr_Indirect_Dynamic);
    }//GEN-LAST:event_r_addreIndirectdynamicActionPerformed

    private void r_addreDirectImplicitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_addreDirectImplicitActionPerformed
        // TODO add your handling code here:
        ParametersController.setAddressing_Receive(ParameterState.Addr_Direct_Receive_Implicit);
        ParametersController.setAddressing_Send(ParameterState.Addr_Direct_Send);
    }//GEN-LAST:event_r_addreDirectImplicitActionPerformed

    private void r_syncReceiProofOFArrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_syncReceiProofOFArrivalActionPerformed
        // TODO add your handling code here:
        ParametersController.setSyncronization_Receive(ParameterState.Sync_Receive_ProofOfArrival);
    }//GEN-LAST:event_r_syncReceiProofOFArrivalActionPerformed

    private void r_syncReceNonBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_syncReceNonBlockActionPerformed
        // TODO add your handling code here:
        ParametersController.setSyncronization_Receive(ParameterState.Sync_Receive_NonBlocking);
    }//GEN-LAST:event_r_syncReceNonBlockActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        ParametersController.setSyncronization_Send(ParameterState.Sync_Send_NonBlocking);
    }//GEN-LAST:event_jRadioButton5ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_simulationStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton r_addreDirectImplicit;
    private javax.swing.JRadioButton r_addreIndirectdynamic;
    private javax.swing.JRadioButton r_addresDirectExplicit;
    private javax.swing.JRadioButton r_addressIndirectStatic;
    private javax.swing.JRadioButton r_lenghtFixed;
    private javax.swing.JRadioButton r_lenghtVariable;
    private javax.swing.JRadioButton r_queueFifo;
    private javax.swing.JRadioButton r_queuePriority;
    private javax.swing.JRadioButton r_syncReceNonBlock;
    private javax.swing.JRadioButton r_syncReceiProofOFArrival;
    private javax.swing.JRadioButton r_syncReceiveBlocking;
    private javax.swing.ButtonGroup radiogroup_addressing;
    private javax.swing.ButtonGroup radiogroup_lenght;
    private javax.swing.ButtonGroup radiogroup_queue;
    private javax.swing.ButtonGroup radiogroup_syncSend;
    private javax.swing.ButtonGroup radiogroup_syncreceive;
    private javax.swing.JSpinner spin_fixed;
    private javax.swing.JSpinner spin_maxQueueLenght;
    private javax.swing.JSpinner spin_noProcesses;
    // End of variables declaration//GEN-END:variables
}
