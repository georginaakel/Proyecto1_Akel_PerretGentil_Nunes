/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Classes.Util;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Graph {
    private List<Vperson> allPerson;
    private int size;

    public Graph() {
        this.allPerson = new List();
        this.size = 0;
    }

    public List getAllPerson() {
        return allPerson;
    }

    public void setAllPerson(List allPerson) {
        this.allPerson = allPerson;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void addPerson(int Vnum, String name){
        Util f = new Util();
        
        Vperson person = new Vperson(name, Vnum);
        allPerson.append(person);
        size++;
        f.write_txt(allPerson);
    }
    
    public void addEdge(int Vfirst, int Vlast, int weight){
        Util f = new Util();
        
        Vperson personA, personB;
        personA = personB = null;
        int pA, pB;
        pA = pB = 0;       
        
        for(int x = 0; x < size; x++){
            Vperson pAux = (Vperson) allPerson.get(x);
            if(pAux.getVnum() == Vfirst){
                personA = pAux;
                pA = x;
            }
            if(pAux.getVnum() == Vlast){
                personB = pAux;
                pB = x;
            }
        }
        
        if(personA == null || personB == null){
            JOptionPane.showMessageDialog(null, "Error: numero de vertice no encontrado");
        }
        else{
            Edge edgeA = new Edge(personA, personB, weight);
            
            List adyListA = personA.getAdyList();
            adyListA.append(edgeA);
            personA.setAdyList(adyListA);
            
            allPerson.replace(pA, personA);

            f.write_txt(allPerson);
        }
    }
    

    
    
    
    
    
    
        
}
    
    

