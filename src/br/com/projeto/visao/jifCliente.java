/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.visao;

/**
 *
 * @author julian
 */
public class jifCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form jifCliente
     */
    public jifCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        getContentPane().setLayout(null);

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(18, 14, 31, 14);

        jLabel2.setText("CPF:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 23, 14);

        jLabel3.setText("Endereço:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 110, 49, 14);

        jLabel4.setText("Complemento:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 160, 69, 14);

        jLabel5.setText("Cidade:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 210, 37, 14);

        jLabel6.setText("Email:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 260, 28, 14);

        jLabel7.setText("RG:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(270, 60, 18, 14);

        jLabel8.setText("Numero:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(270, 110, 41, 14);

        jLabel9.setText("CEP:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(270, 160, 23, 14);

        jLabel10.setText("Estado:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(270, 210, 37, 20);

        jLabel11.setText("Telefone:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(270, 260, 46, 14);

        jLabel12.setText("Celular:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(410, 260, 37, 14);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(20, 30, 230, 20);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(20, 80, 230, 19);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(20, 130, 230, 20);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(20, 180, 230, 20);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(270, 80, 230, 20);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(20, 230, 230, 20);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(20, 280, 230, 20);
        getContentPane().add(jTextField8);
        jTextField8.setBounds(270, 130, 90, 20);

        jLabel13.setText("Bairro:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(380, 110, 32, 14);
        getContentPane().add(jTextField9);
        jTextField9.setBounds(380, 130, 120, 20);
        getContentPane().add(jTextField10);
        jTextField10.setBounds(270, 180, 150, 20);
        getContentPane().add(jTextField12);
        jTextField12.setBounds(270, 280, 120, 20);
        getContentPane().add(jTextField13);
        jTextField13.setBounds(410, 280, 110, 20);

        jButton1.setText("Cadastrar");
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 320, 80, 23);

        jButton2.setText("Cancelar");
        getContentPane().add(jButton2);
        jButton2.setBounds(420, 320, 80, 23);
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(370, 30, 87, 20);

        jLabel14.setText("Data Nascimento: ");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(370, 10, 90, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(270, 230, 56, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
