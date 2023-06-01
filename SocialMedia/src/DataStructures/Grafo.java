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
public class Grafo {
    //Atributos de la clase
    private List<Vperson> allPerson;
    private int count;
   
    
    //Constructor: no se pasa nada por parametro
    public Grafo() {
        this.allPerson = new List();
        this.count = 0;
    }  
    
    //================Getters and Setters==================
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
    

    //====================Procedimientos y Metodos===================
    
    //Agregar un vertice al grafo
    public boolean addPerson(int Vnum, String name){
        Vperson person = new Vperson(Vnum, name);       
        boolean run = true;
        if(allPerson.isEmpty()){
            allPerson.append(person);
        }
        else{
            for(int x = 0; x < allPerson.len(); x++){
                Vperson pAux = (Vperson) allPerson.get(x);
                if(pAux.getVnum() == Vnum){
                    run = false;
                }
                if(pAux.getName().equals(name)){
                    run = false;
                }
            }
            if(run == true){
                allPerson.append(person);
            }     
        }
        return run;
    }
    
    //Retorna un valor booleano dependiendo de si la Arista pasada por parametro existe en la adyList del vertice pasado por parametro
    public boolean edgeExist(int start, int end, Vperson person){
        List adyList = person.getAdyList();
        if(adyList.isEmpty() == true){
            return false;
        }
        else{
            for(int x = 0; x < adyList.len(); x++){
                Edge edge = (Edge) adyList.get(x);
                if(edge.getStart() == start && edge.getEnd() == end){
                    return true;
                }
                else if(edge.getStart() == end && edge.getEnd() == start){
                    return true;
                }
            }
            return false;
        }
    }
    
    //Agregar una arista al grafo
    public void addEdge(int start, int end, int weight){
        try{
            
            Vperson personStart = allPerson.get(findPositionVnum(start));
            Vperson personEnd = allPerson.get(findPositionVnum(end));
            
            if(start == end){
                JOptionPane.showMessageDialog(null, "Error: no se admite relacion con un mismo vertice");
            }
            
            else if(weight < 0){
                JOptionPane.showMessageDialog(null, "Error: valor ingresado en relacion no valido");
            }

            else if(allPerson.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error: no hay vertices");
            }
            
            else if(edgeExist(start, end, personStart) || edgeExist(start, end, personEnd)){
                JOptionPane.showMessageDialog(null, "Error: relacion ya establecida con anterioridad");
            }   
            
            else{
                for(int x = 0; x < allPerson.len(); x++){
                    int position = x;
                    Vperson pAux = (Vperson) allPerson.get(x);

                    if(pAux.getVnum() == start){
                        Edge edge = new Edge(start, end, weight);
                        edge.setRead(true);
                        List adyList = pAux.getAdyList();
                        adyList.append(edge);
                        pAux.setAdyList(adyList);
                        allPerson.replace(position, pAux);                             
                    }
                    if(pAux.getVnum() == end){
                        Edge edge = new Edge(start, end, weight);
                        edge.setRead(false);
                        List adyList = pAux.getAdyList();
                        adyList.append(edge);
                        pAux.setAdyList(adyList);
                        allPerson.replace(position, pAux);                             
                    }
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: dato ingresado incorrecto");
        }       
    }
    
    //Encuentra la posicion del vertice en la lista apartir de su nombre
    public int findPositionName(String name){
        for(int x = 0; x < allPerson.len(); x++){
            if(allPerson.get(x).getName().equals(name)){
                return x;
            }
        }
        return -1;
    }
    
    
    //Encuentra la posicion del vertice en la lista apartir de su numero
    public int findPositionVnum(int Vnum){
        for(int x = 0; x < allPerson.len(); x++){
            if(allPerson.get(x).getVnum() == Vnum){
                return x;
            }
        }
        return -1;
    }
    
    //Obtiene la persona a partir de su numero
    public Vperson findPersonVnum(int Vnum){
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = allPerson.get(x);
            if(person.getVnum() == Vnum){
                return person;
            }
        }
        return null;
    }
    
    //Obtiene la persona a partir de su nombre
    public Vperson findPersonName(String name){
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = allPerson.get(x);
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }
    
    //Retorna el numero del vertice apartir de su nombre
    public int nameToVnum(String name){
        int position = findPositionName(name);
        
        Vperson person = allPerson.get(position);
        
        return person.getVnum();
    }
    
    //Retorna el nombre del vertice apartir de su numero
    public String VnumToName(int Vnum){
        for(int x = 0; x < allPerson.len(); x++){
            if(allPerson.get(x).getVnum() == Vnum){
                return allPerson.get(x).getName();
            }
        }
        return null;
    }
    
    //Borra un vertice apartir de su nombre
    public void deletePersonByName(String name){ 
        Vperson person = null;
        for(int x = 0; x < allPerson.len(); x++){          
            if(allPerson.get(x).getName().equals(name)){
                person = allPerson.get(x);
                allPerson.pop(x);
            }            
        }
        
        if(person == null){
            JOptionPane.showMessageDialog(null, "Error: persona no encontrada en el grafo");
        }
        else{
            for (int x = 0; x < allPerson.len(); x++) {
                Vperson pAux = allPerson.get(x);
                List adyList = pAux.getAdyList();
                for(int y = 0; y < adyList.len(); y++){
                    Edge edge = (Edge) adyList.get(y);
                    if(edge.getStart() == person.getVnum() || edge.getEnd() == person.getVnum()){
                        adyList.pop(y);
                        pAux.setAdyList(adyList);
                        allPerson.replace(x, pAux);
                    }
                }
            }       
        }       
    }
    
    //Borra un vertice apartir de su nombre
    public void deletePersonByVnum(int num){ 
        Vperson person = null;
        for(int x = 0; x < allPerson.len(); x++){
            Vperson p = allPerson.get(x);
            if(p.getVnum() == num){
                person = allPerson.get(x);
                allPerson.pop(x);
            }            
        }
        
        if(person == null){
            JOptionPane.showMessageDialog(null, "Error: persona no encontrada en el grafo");
        }
        else{
            for (int x = 0; x < allPerson.len(); x++) {
                Vperson pAux = allPerson.get(x);
                List adyList = pAux.getAdyList();
                for(int y = 0; y < adyList.len(); y++){
                    Edge edge = (Edge) adyList.get(y);
                    if(edge.getStart() == person.getVnum() || edge.getEnd() == person.getVnum()){
                        adyList.pop(y);
                        pAux.setAdyList(adyList);
                        allPerson.replace(x, pAux);
                    }
                }
            }       
        }       
    }
    
    //Imprime el grafo en la consola
    public void printGraph(){
        for(int x = 0; x < allPerson.len(); x++){
            Vperson vertice = allPerson.get(x);
            System.out.print("El usuario " + vertice.getName()+" esta conectado con ");
            if(vertice.getAdyList().len() == 0){
                System.out.println(" nadie");
            }
            else if(vertice.getAdyList().len() > 1){
                for(int y = 0; y < vertice.getAdyList().len(); y++){
                    Edge arista = (Edge) vertice.getAdyList().get(y);
                    String name = VnumToName(arista.getEnd());
                    if(y == vertice.getAdyList().len()-1){
                        System.out.println(" y " + name);    
                    }
                    else if(y == vertice.getAdyList().len()-2){
                        System.out.print(name);
                    }
                    else{
                        System.out.print(name + ", ");
                    }
                }    
            }
            else{
                for(int y = 0; y < vertice.getAdyList().len(); y++){
                    Edge arista = (Edge) vertice.getAdyList().get(y);
                    System.out.println(VnumToName(arista.getEnd()));
                }
            }
        }
    }
    
    //Retorna un valor booleano dependiendo de si los vertices estan conectados o no
    public boolean isConectedName(String nameA, String nameB){
        Vperson personA = findPersonName(nameA);
        Vperson personB = findPersonName(nameB);
        
        List listAdyA = personA.getAdyList();
        List listAdyB = personB.getAdyList();
        
        int VnumA = personA.getVnum();
        int VnumB = personB.getVnum();
        
        for(int x = 0; x < listAdyA.len(); x++){           
           Edge edgeA = (Edge) listAdyA.get(x);
           if(edgeA.getStart() == VnumB || edgeA.getEnd() == VnumB){
               return true;
           }
        }
        
        for(int x = 0; x < listAdyB.len(); x++){           
           Edge edgeB = (Edge) listAdyB.get(x);
           if(edgeB.getStart() == VnumA || edgeB.getEnd() == VnumA){
               return true;
           }
        }
        return false;
    }
    
    //Retorna un valor booleano dependiendo de si los vertices estan conectados o no
    public boolean isConectedVnum(int VnumA, int VnumB){
        Vperson personA = findPersonVnum(VnumA);
        Vperson personB = findPersonVnum(VnumB);
        
        List listAdyA = personA.getAdyList();
        List listAdyB = personB.getAdyList();
        
        for(int x = 0; x < listAdyA.len(); x++){           
           Edge edgeA = (Edge) listAdyA.get(x);
           if(edgeA.getStart() == VnumB || edgeA.getEnd() == VnumB){
               return true;
           }
        }
        
        for(int x = 0; x < listAdyB.len(); x++){           
           Edge edgeB = (Edge) listAdyB.get(x);
           if(edgeB.getStart() == VnumA || edgeB.getEnd() == VnumA){
               return true;
           }
        }
        return false;
    }
    
    //Retorna el numero de relaciones que tiene un vertice
    public int allConections(Vperson personA){
        int count = 0;
        for(int x = 0; x < allPerson.len(); x++){
            Vperson personB = allPerson.get(x);
            if(isConectedName(personA.getName(), personB.getName())){
                count++;
            }
        }
        return count-1;    
    }
    

    
    
    
    
}
