/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import Classes.Edge;
import Classes.Util;
import Classes.Vperson;
import DataStructures.Graph;
import DataStructures.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class LoadFile extends javax.swing.JFrame {
    private String fileRoute; 
    private Graph graph;
    private boolean loaded;
    
    /**
     * Creates new form Inter1
     */
    public LoadFile() {
        initComponents();
        this.graph = new Graph();
        this.loaded = false;
        setLocationRelativeTo(null);
    }
    
    public String getFileRoute() {
        return fileRoute;
    }
    
    public void setFileRoute(String fileRoute) {
        this.fileRoute = fileRoute;
    }
    
    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
 
    
    public void getRoute(){       
        Util u = new Util();
        loaded = false;
        fileRoute = u.ObtenerRutaTXT();
        if(fileRoute.endsWith("txt")){
            System.out.println(fileRoute);
            loaded = true;
        }
        
    }
    
    public void loadTXT(){       
        Util u = new Util();
        List newAllPerson = u.read_users(fileRoute);       
        List allEdge = u.read_relations(newAllPerson, fileRoute);
              
        for(int x = 0; x < allEdge.len(); x++){
            Edge edge = (Edge) allEdge.get(x);
            for(int y = 0; y < newAllPerson.len(); y++){
                Vperson person = (Vperson) newAllPerson.get(y);
                if(edge.getStart() == person.getVnum()){
                    List adyList = person.getAdyList();
                    adyList.append(edge);
                    person.setAdyList(adyList);
                    newAllPerson.replace(y, person);
                }
            }
        }              
        graph.setAllPerson(newAllPerson);       
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
        loadFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadFile.setText("Cargar archivo");
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(loadFile)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(loadFile)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileActionPerformed
        getRoute();
        loadTXT();
//        System.out.println(graph.findName(608));
        if(loaded == true){
            JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente!");
            InterfaceMain inter2 = new InterfaceMain(graph, fileRoute);
            inter2.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_loadFileActionPerformed

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
            java.util.logging.Logger.getLogger(LoadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadFile;
    // End of variables declaration//GEN-END:variables
}
