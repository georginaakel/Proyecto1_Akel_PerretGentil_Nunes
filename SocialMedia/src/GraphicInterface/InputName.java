/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import Classes.Util;
import Classes.Vperson;
import DataStructures.Grafo;
import DataStructures.List;
import javax.swing.JOptionPane;

/**
 * En esta interfaz se gestionan los usuarios utilizados en el programa
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @version 31/05/2023
 */
public class InputName extends javax.swing.JFrame {
    private String Vname;
    private int Vnum;
    private static Grafo graph;
    private static String fileRoute;
    private boolean run;
    private static int option;
    
    /**
     * Creates new form Inter3
     * @param graph
     * @param fileRoute
     * @param option
     */
    public InputName(Grafo graph, String fileRoute, int option) {
        initComponents();
        this.graph = graph;
        this.fileRoute = fileRoute;
        this.option = option;
        setLocationRelativeTo(null);
    }
    
    /**
     * función que crea el número de vertice para una persona y la agrega al grafo
     */
    public void addVperson(){
        Vnum = (int) (Math.random()*999 + 1);
        boolean run = graph.addPerson(Vnum, Vname);        
    }
    
    /**
     * función que elimina una persona
     */
    public void deleteVperson(){
        graph.deletePersonByName(Vname);
    }
    
    /**
     * función que asigna el nombre de una persona
     * @return booleano 
     */
    public boolean setNamePerson(){
        String name = nameInput.getText();
        if(Util.isNumeric(name) == true){
            JOptionPane.showMessageDialog(null, "Error: tipo de dato incorrecto");
            return false;
        }
        else{
            if(name.contains("@")){
                name = name.replace("@", "");
            }
            name = "@" + name;
            Vname = name;
            return true;
        }
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
        jLabel1 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        finish = new javax.swing.JButton();
        back = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Nombre de usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        nameInput.setBackground(new java.awt.Color(255, 204, 0));
        nameInput.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        nameInput.setForeground(new java.awt.Color(0, 0, 204));
        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });
        getContentPane().add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 238, -1));

        finish.setBackground(new java.awt.Color(255, 204, 0));
        finish.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        finish.setForeground(new java.awt.Color(0, 0, 204));
        finish.setText("Continuar");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });
        getContentPane().add(finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 110, 40));

        back.setBackground(new java.awt.Color(255, 204, 0));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Regresar.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 590, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Conduce a la interfaz de InterfaceMain despues de agregar o eliminar a un usuario
     * @param evt 
     */
    private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
        run = setNamePerson();
        if(run == true){
            if(option == 0){
                addVperson();
                this.dispose();
                InterfaceMain inter2 = new InterfaceMain(graph, fileRoute);
                inter2.setVisible(true);
            }
            else{
                deleteVperson();
                this.dispose();
                InterfaceMain inter2 = new InterfaceMain(graph, fileRoute);
                inter2.setVisible(true);               
            }
        }
        else{
            this.dispose();
            InterfaceMain inter2 = new InterfaceMain(graph, fileRoute);
            inter2.setVisible(true);
        }
    }//GEN-LAST:event_finishActionPerformed

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed

    }//GEN-LAST:event_nameInputActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        InterfaceMain inter2 = new InterfaceMain(graph, fileRoute);
        inter2.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(InputName.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputName.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputName.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputName.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputName(graph, fileRoute, option).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton back;
    private javax.swing.JButton finish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameInput;
    // End of variables declaration//GEN-END:variables
}
