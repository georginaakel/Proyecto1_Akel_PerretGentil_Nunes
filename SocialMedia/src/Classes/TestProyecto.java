/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Util;
import Classes.Vperson;
import DataStructures.Graph;
import GraphicInterface.Interface1;

/**
 *
 * @author Juan
 */
public class TestProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph g = new Graph();
        g.addPerson(0, "Juan");
        g.addPerson(1, "Pedro");
        g.addEdge(0, 1, 10);
        
        Interface1 inter = new Interface1();
       
        
        
       
       
       
    }
    
}
