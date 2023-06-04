/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import DataStructures.Grafo;
import javax.swing.JOptionPane;

/**
 * Esta interfaz tiene la función de eliminar arcos dentro del grafo
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @version 03/06/2023
 */
public class InputDeleteEdge extends javax.swing.JFrame {
    private static Grafo graph;
    private static String fileRoute;

    /**
     * Crea la interfaz
     * @param graph
     * @param fileRoute
     */
    public InputDeleteEdge(Grafo graph, String fileRoute) {
        this.graph = graph;
        this.fileRoute = fileRoute;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    /**
     * Elimina un arco
     */
    public void EdgeD(){
        String userA = firstUser.getText();
        if(userA.contains("@")){
            userA = userA.replace("@", "");
        }
        
        String userB = SecondUser.getText();
        if(userB.contains("@")){
            userB = userB.replace("@", "");
        }
        
        userA = "@" + userA;
        userB = "@" + userB;
        int A = graph.nameToVnum(userA);
        int B = graph.nameToVnum(userB);
        graph.deleteEdge(A, B, 0);              

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        firstUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SecondUser = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 61, -1, -1));

        firstUser.setBackground(new java.awt.Color(255, 204, 0));
        firstUser.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        firstUser.setForeground(new java.awt.Color(0, 0, 255));
        getContentPane().add(firstUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 230, -1));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Ingrese el primer usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Ingrese el segundo usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        SecondUser.setBackground(new java.awt.Color(255, 204, 0));
        SecondUser.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        SecondUser.setForeground(new java.awt.Color(0, 0, 255));
        getContentPane().add(SecondUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 230, -1));

        back.setBackground(new java.awt.Color(255, 204, 0));
        back.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(0, 0, 204));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Regresar.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 620, 60, -1));

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 110, 40));

        Fondo.setBackground(new java.awt.Color(255, 204, 0));
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Conduce a la interfaz de InterfaceMain 
     * @param evt 
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        InterfaceMain in1 = new InterfaceMain(graph, fileRoute);
        in1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EdgeD();
        InterfaceMain in1 = new InterfaceMain(graph, fileRoute);
        in1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InputDeleteEdge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputDeleteEdge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputDeleteEdge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputDeleteEdge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputDeleteEdge(graph, fileRoute).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField SecondUser;
    private javax.swing.JButton back;
    private javax.swing.JTextField firstUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
