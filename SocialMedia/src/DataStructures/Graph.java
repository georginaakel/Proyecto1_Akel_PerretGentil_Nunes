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
    //Atributos de la clase
    private List<Vperson> allPerson;
    private int count;

    
    //Constructor: no se pasa nada por parametro
    public Graph() {
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
            Vperson personStart = allPerson.get(findPositionInt(start));
            Vperson personEnd = allPerson.get(findPositionInt(end));
            if(start == end){
                JOptionPane.showMessageDialog(null, "Error: no se admite relacion con un mismo vertice");
            }

            else if(allPerson.isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Error: no hay vertices");
            }
            else if(edgeExist(start, end, personStart) == true || edgeExist(start, end, personEnd) == true){
                JOptionPane.showMessageDialog(null, "Error: relacion ya establecida con anterioridad");
            }           
            else{
                for(int x = 0; x < allPerson.len(); x++){
                    int position = x;
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
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: dato ingresado incorrecto");
        }
        
    }
    
    //Encuentra la posicion del vertice en la lista apartir de su nombre
    public int findPositionStr(String name){
        for(int x = 0; x < allPerson.len(); x++){
            if(allPerson.get(x).getName().equals(name)){
                return x;
            }
        }
        return -1;
    }
    
    //Encuentra la posicion del vertice en la lista apartir de su numero
    public int findPositionInt(int Vnum){
        for(int x = 0; x < allPerson.len(); x++){
            if(allPerson.get(x).getVnum() == Vnum){
                return x;
            }
        }
        return -1;
    }
    
    //Retorna el numero del vertice apartir de su nombre
    public int findVnum(String name){
        int position = findPositionStr(name);
        
        Vperson person = allPerson.get(position);
        
        return person.getVnum();
    }
    
    //Retorna el nombre del vertice apartir de su numero
    public String findName(int Vnum){
        for(int x = 0; x < allPerson.len(); x++){
            if(allPerson.get(x).getVnum() == Vnum){
                return allPerson.get(x).getName();
            }
        }
        return null;
    }
    
    //Borra un vertice apartir de su nombre
    public void deletePersonByName(String name){     
        boolean deleted = false;
        Vperson auxPerson = null;
        
        int position = findPositionStr(name);
        if(position != -1){
            auxPerson = allPerson.get(position);
            allPerson.pop(position);
            deleted = true;

            for(int x = 0; x < allPerson.len(); x++){
                Vperson person = allPerson.get(x);
                List adyList = person.getAdyList();
                if(adyList.len() > 0){
                    for(int y = 0; y < adyList.len(); y++){
                        Edge edge = (Edge) adyList.get(y);
                        if(edge.getEnd() == auxPerson.getVnum()){
                            adyList.pop(y);
                            person.setAdyList(adyList);
                            allPerson.replace(x, person);
                        }
                    }
                }
            }

        }           
        else if(deleted == false || position == -1){
            JOptionPane.showMessageDialog(null, "Error: vertice no encontrado");
        }
    }
    
    //Borra un vertice apartir de su numero
    public void deletePersonByInt(int Vnum){
        boolean deleted = false;
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = allPerson.get(x);
            if(person.getVnum() == Vnum){
                allPerson.pop(x);
                deleted = true;
            }
        }
        
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = allPerson.get(x);
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
                    String name = findName(arista.getEnd());
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
                    System.out.println(findName(arista.getEnd()));
                }
            }
        }
    }
    //Función que hace el recorrido del grafo por anchura, con la estructura de dato 
   public String bfs() {
        Vperson first = allPerson.get(0);
        Queue<Vperson> queue = new Queue<>();
        queue.encolar(first);
        String cont = first.getName()+ " ";
        first.setIsVisited(true);
        while (!queue.isEmpty()) {
            Vperson v = queue.pop();
            Vperson aux;
            while ((aux = getNoVisited(v)) != null) {
                aux.setIsVisited(true);
                cont += aux.getName()+ " ";
                queue.encolar(aux);
            }
        }
        cleanVisited();
        return cont;
    }
    
     public Vperson getNoVisited(Vperson v) {
        for (int x = 0; x < allPerson.len(); x++) {
            Vperson person = allPerson.get(x);
            if (v.getAdyList().existStr(person.getName()) && (person.getIsVisited()== false)) {
                return person;
            }
        }
        return null;
    }
    
     public void cleanVisited(){ 
         for (int x = 0; x < allPerson.len(); x++){
             Vperson person = allPerson.get(x);
             person.setIsVisited(false);
             allPerson.replace(x, person);
         }
     }
}
