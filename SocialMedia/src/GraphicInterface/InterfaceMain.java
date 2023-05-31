/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GraphicInterface;


import Classes.Util;
import Classes.Vperson;
import DataStructures.Grafo;
import DataStructures.Node;
import Classes.Edge;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author Georgina
 */
public class InterfaceMain extends javax.swing.JFrame {
    private Util util; 
    private static Grafo graph;
    private static String fileRoute;

    /**
     * Creates new form InterfaceMain
     */
    public InterfaceMain(Grafo graph, String fileRoute) {
        initComponents();
        this.util = new Util();
        this.graph = graph;
        this.fileRoute = fileRoute;
        setLocationRelativeTo(null);
    }
    
    public Grafo getGraph() {
        return graph;
    }

    public void setGraph(Grafo graph) {
        this.graph = graph;
    }
    
    public void CrearGraphView(){
        System.setProperty("org.graphstream.ui", "swing");
        Graph grafoview = new SingleGraph("Tutorial 1");
        Node < Vperson> aux = graph.getAllPerson().getHead();
        for (int i = 0; i < graph.getAllPerson().getSize(); i++) {
            grafoview.addNode(aux.getData().getName());
            grafoview.getNode(aux.getData().getName()).setAttribute("ui.label", "Usuario " + aux.getData().getName());
            aux = aux.getNext();
        }
        
        aux = graph.getAllPerson().getHead();
        for (int i = 0; i < graph.getAllPerson().getSize(); i++) {
            Node < Edge > aux2 = aux.getData().getAdyList().getHead();
            for (int j = 0; j < aux.getData().getAdyList().getSize(); j++) {
                grafoview.addEdge(Integer.toString(aux2.getData().getStart() + aux2.getData().getEnd()), Integer.toString(aux2.getData().getStart()) , Integer.toString(aux2.getData().getEnd()));
                grafoview.getEdge(aux2.getData().getStart() + aux2.getData().getEnd()).setAttribute("ui.label", aux2.getData().getWeight());
                aux2 = aux2.getNext();
            }
            aux = aux.getNext();
            }
    
        Viewer viewer = grafoview.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        
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
        ActualizarPerson = new javax.swing.JButton();
        ShowGraph = new javax.swing.JButton();
        BFSyDFS = new javax.swing.JButton();
        AddPerson = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();
        addRelation = new javax.swing.JButton();
        test = new javax.swing.JButton();
        print = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 66, -1, -1));

        ActualizarPerson.setBackground(new java.awt.Color(255, 204, 0));
        ActualizarPerson.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 24)); // NOI18N
        ActualizarPerson.setForeground(new java.awt.Color(0, 0, 204));
        ActualizarPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/actualizar.png"))); // NOI18N
        ActualizarPerson.setText("Actualizar repositorio");
        ActualizarPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarPersonActionPerformed(evt);
            }
        });
        getContentPane().add(ActualizarPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        ShowGraph.setBackground(new java.awt.Color(255, 204, 0));
        ShowGraph.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 24)); // NOI18N
        ShowGraph.setForeground(new java.awt.Color(0, 0, 204));
        ShowGraph.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grafo.png"))); // NOI18N
        ShowGraph.setText("Mostrar Grafo");
        ShowGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowGraphActionPerformed(evt);
            }
        });
        getContentPane().add(ShowGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 280, -1));

        BFSyDFS.setBackground(new java.awt.Color(255, 204, 0));
        BFSyDFS.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 24)); // NOI18N
        BFSyDFS.setForeground(new java.awt.Color(0, 0, 204));
        BFSyDFS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/recorridos.png"))); // NOI18N
        BFSyDFS.setText("Recorridos");
        BFSyDFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSyDFSActionPerformed(evt);
            }
        });
        getContentPane().add(BFSyDFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 280, -1));

        AddPerson.setBackground(new java.awt.Color(255, 204, 0));
        AddPerson.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 24)); // NOI18N
        AddPerson.setForeground(new java.awt.Color(0, 0, 204));
        AddPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/8.png"))); // NOI18N
        AddPerson.setText("Agregar persona");
        AddPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPersonActionPerformed(evt);
            }
        });
        getContentPane().add(AddPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 280, -1));

        deleteUser.setBackground(new java.awt.Color(255, 204, 0));
        deleteUser.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 24)); // NOI18N
        deleteUser.setForeground(new java.awt.Color(0, 0, 204));
        deleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/9.png"))); // NOI18N
        deleteUser.setText("Borrar persona");
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });
        getContentPane().add(deleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 280, -1));

        addRelation.setBackground(new java.awt.Color(255, 204, 0));
        addRelation.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 24)); // NOI18N
        addRelation.setForeground(new java.awt.Color(0, 0, 204));
        addRelation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/islas.png"))); // NOI18N
        addRelation.setText("Agregar relacion");
        addRelation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRelationActionPerformed(evt);
            }
        });
        getContentPane().add(addRelation, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 540, 280, -1));

        test.setText("prueba");
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });
        getContentPane().add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 640, -1, -1));

        print.setText("print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 640, -1, -1));

        Back.setBackground(new java.awt.Color(255, 204, 0));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Regresar.png"))); // NOI18N
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 610, -1, -1));

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CloseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/2.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActualizarPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarPersonActionPerformed
        util.WriteTxt(graph.getAllPerson(),fileRoute);
    }//GEN-LAST:event_ActualizarPersonActionPerformed

    private void AddPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPersonActionPerformed
        InputName inter3 = new InputName(graph, fileRoute, 0);
        inter3.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddPersonActionPerformed

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed
        InputName inter3 = new InputName(graph, fileRoute, 1);
        inter3.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deleteUserActionPerformed

    private void addRelationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRelationActionPerformed
        InputEdge inter4 = new InputEdge(graph, fileRoute);
        this.dispose();
        inter4.setVisible(true);
    }//GEN-LAST:event_addRelationActionPerformed

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        System.out.println(graph.allConections((Vperson) graph.getAllPerson().get(1)));
    }//GEN-LAST:event_testActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        graph.printGraph();
        System.out.println(" ");
    }//GEN-LAST:event_printActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        LoadFile in1 = new LoadFile();
        in1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void BFSyDFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSyDFSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BFSyDFSActionPerformed

    private void ShowGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowGraphActionPerformed
        // TODO add your handling code here:
        try {
            CrearGraphView();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL IMPRIMIR EL GRAFO. \nTipo de error: " + e);
        }
        
        
    }//GEN-LAST:event_ShowGraphActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceMain(graph, fileRoute).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarPerson;
    private javax.swing.JButton AddPerson;
    private javax.swing.JButton BFSyDFS;
    private javax.swing.JButton Back;
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton ShowGraph;
    private javax.swing.JButton addRelation;
    private javax.swing.JButton deleteUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton print;
    private javax.swing.JButton test;
    // End of variables declaration//GEN-END:variables

}
