/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Classes.Edge;
import Classes.Vperson;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Graph {
    private List allPerson;
    private int count;

    public Graph() {
        this.allPerson = new List();
        this.count = 0;
    }

    public List getAllPerson() {
        return allPerson;
    }

    public void setAllPerson(List allPerson) {
        this.allPerson = allPerson;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public void addPerson(int Vnum, String name){
        Vperson person = new Vperson(Vnum, name);       
        if(allPerson.isEmpty() == true){
            allPerson.append(person);
        }
        else{
            boolean run = true;
            for(int x = 0; x < allPerson.len(); x++){
                Vperson pAux = (Vperson) allPerson.get(x);
                if(pAux.getVnum() == Vnum){
                    JOptionPane.showMessageDialog(null, "Error: numero de vertice ya registrado");
                    run = false;
                }
            }
            if(run == true){
                allPerson.append(person);
            }     
        }
    }
    
    public void addEdge(int start, int end, int weight){
        if(start == end){
            JOptionPane.showMessageDialog(null, "Error: no se admite relacion con un mismo vertice");
        }
        
        if(allPerson.isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Error: no hay vertices");
        }
        
        for(int x = 0; x < allPerson.len(); x++){
            int position = 0;
            Vperson pAux = (Vperson) allPerson.get(x);
            
            if(pAux.getVnum() == start){
                Edge edge = new Edge(start, end, weight);
                List adyList = pAux.getAdyList();
                adyList.append(edge);
                pAux.setAdyList(adyList);
                allPerson.replace(position, pAux);                             
            }
        }
        
    }
    
    
}
