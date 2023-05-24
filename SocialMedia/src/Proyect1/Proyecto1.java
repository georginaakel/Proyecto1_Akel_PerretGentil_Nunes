/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyect1;


import Classes.Util;
import DataStructures.Edge;
import DataStructures.Graph;
import DataStructures.List;
import DataStructures.Vperson;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Juan
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Graph newGraph = new Graph();
        newGraph.addPerson(1, "Juan");
        newGraph.addPerson(2, "Pedro");
        newGraph.addPerson(3, "Gabriel");
        newGraph.addPerson(4, "Santi");
        
        newGraph.addEdge(1, 2, 10);
        newGraph.addEdge(1, 3, 8);
        newGraph.addEdge(2, 3, 12);
        newGraph.addEdge(3, 4, 7);
        
        File file = new File("C:\\Users\\Juan Diego\\Desktop\\Java\\Clases\\Proyecto1\\src\\TextFiles\\Persons.txt");
        FileReader rd = new FileReader(file);
        BufferedReader br = new BufferedReader(rd);
        
        
        Util u = new Util();
        List listA = u.read_users();
        List listB = u.read_relations(newGraph.getAllPerson());
        Edge edge = (Edge) listB.get(0);
        System.out.println(edge.getStart().getName());
        
        
        
    }
    
}
