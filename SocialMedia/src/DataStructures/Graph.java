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
                if(pAux.getName().equals(name)){
                    JOptionPane.showMessageDialog(null, "Error: nombre de vertice ya registrado");
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
    
    public void deletePersonByName(String name){     
        boolean deleted = false;
        Vperson auxPerson = null;
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = (Vperson) allPerson.get(x);
            if(person.getName().equals(name)){
                auxPerson = person;
                allPerson.pop(x);
            }
        }
        
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = (Vperson) allPerson.get(x);
            List adyList = person.getAdyList();
            for(int y = 0; y < adyList.len(); y++){
                Edge edge = (Edge) adyList.get(y);
                if(edge.getEnd() == auxPerson.getVnum()){
                    adyList.pop(y);
                    person.setAdyList(adyList);
                    allPerson.replace(x, person);
                }
            }
        }
             
        if(deleted == false){
            JOptionPane.showMessageDialog(null, "Error: vertice no encontrado");
        }
    }
    
    public void deletePersonByInt(int Vnum){
        boolean deleted = false;
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = (Vperson) allPerson.get(x);
            if(person.getVnum() == Vnum){
                allPerson.pop(x);
                deleted = true;
            }
        }
        
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = (Vperson) allPerson.get(x);
            List adyList = person.getAdyList();
            for(int y = 0; y < adyList.len(); y++){
                Edge edge = (Edge) adyList.get(y);
                if(edge.getEnd() == Vnum){
                    adyList.pop(y);
                    person.setAdyList(adyList);
                    allPerson.replace(0, person);
                }
            }
        }
        
        if(deleted == false){
            JOptionPane.showMessageDialog(null, "Error: vertice no encontrado");
        }
    }
    
    public void printGraph(){
        for(int x = 0; x < allPerson.len(); x++){
            Vperson vertice = (Vperson) allPerson.get(x);
            System.out.print("El vertice " + vertice.getName()+" esta conectado con ");
            if(vertice.getAdyList().len() == 0){
                System.out.println(" nada");
            }
            else if(vertice.getAdyList().len() > 1){
                for(int y = 0; y < vertice.getAdyList().len(); y++){
                    Edge arista = (Edge) vertice.getAdyList().get(y);
                    if(y == vertice.getAdyList().len()-1){
                        System.out.println(" y " + arista.getEnd());    
                    }
                    else if(y == vertice.getAdyList().len()-2){
                        System.out.print(arista.getEnd());
                    }
                    else{
                        System.out.print(arista.getEnd() + ", ");
                    }
                }    
            }
            else{
                for(int y = 0; y < vertice.getAdyList().len(); y++){
                    Edge arista = (Edge) vertice.getAdyList().get(y);
                    System.out.println(arista.getEnd());
                }
            }
        }
    }
    
    
    
    
}
