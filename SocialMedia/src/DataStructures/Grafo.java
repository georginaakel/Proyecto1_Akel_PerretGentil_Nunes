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
 * En esta clase se contienen la implementacion de los grafos y sus métodos correspondientes utilizados a lo largo del proyecto
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @version 31/05/2023
 */
public class Grafo {

    private List<Vperson> allPerson;
    private int count;
   
    
    /**
     *Constructor de la clase Grafo
     */
    public Grafo() {
        this.allPerson = new List();
        this.count = 0;
    }  
    
    /**
     * Método que retorna la lista de personas del grafo
     * @return la lista de personas
     */
    public List getAllPerson() {
        return allPerson;
    }

    /**
     * Método que establece la lista principal del grafo
     * @param allPerson la lista principal a ser establecida en el grafo
     */
    public void setAllPerson(List allPerson) {
        this.allPerson = allPerson;
    }

    /**
     * Método que obtiene el número de vértices del grafo
     * @return el número de vértices
     */
    public int getCount() {
        return count;
    }

    /**
     * Método para establecer el número de vértices
     * @param count el número de vértices que se quiere establecer
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    
    /**
     * Método para agregar una persona 
     * @param Vnum número del vertice
     * @param name nombre de la persona
     * @return booleano al ser agregado o no 
     */
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
    
    /**
     * Método que revisa si la arista pasada por parametro existe en la adyList del vertice pasado por parametro
     * @param start número de vértice de inicio
     * @param end número de vértice del final
     * @param person
     * @return valor booleano dependiendo de si la Arista pasada por parametro existe o no
     */
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
    
    /**
     * Método que agrega una arista al grafo
     * @param start número de vértice inicial
     * @param end número de vértice  final
     * @param weight peso de la relacion
     */
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
    
    /**
     * Método que encuentra la posicion del vertice en la lista a partir de su nombre
     * @param name nombre del vertice
     * @return posicion del vertice
     */
    public int findPositionName(String name){
        for(int x = 0; x < allPerson.len(); x++){
            if(allPerson.get(x).getName().equals(name)){
                return x;
            }
        }
        return -1;
    }
    
    
    /**
     * Método que encuentra la posicion del vertice en la lista a partir de su número
     * @param Vnum número del vertice
     * @return posicion del vertice
     */
    public int findPositionVnum(int Vnum){
        for(int x = 0; x < allPerson.len(); x++){
            if(allPerson.get(x).getVnum() == Vnum){
                return x;
            }
        }
        return -1;
    }
    
    /**
     * Método que encuentra a la persona a partir de su número
     * @param Vnum número del vertice
     * @return persona o null si esta no se encuentra
     */
    public Vperson findPersonVnum(int Vnum){
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = allPerson.get(x);
            if(person.getVnum() == Vnum){
                return person;
            }
        }
        return null;
    }
    
    /**
     * Método que encuentra a la persona a partir de su nombre
     * @param name nombre de la persona
     * @return persona o null si esta no se encuentra
     */
    public Vperson findPersonName(String name){
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = allPerson.get(x);
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }
    
    /**
     * Método que encuentra el número del vertice a partir de su nombre
     * @param name nombre del vertice
     * @return número del vertice o null si este no se encuentra
     */
    public int nameToVnum(String name){
        int position = findPositionName(name);
        
        Vperson person = allPerson.get(position);
        
        return person.getVnum();
    }
    
    /**
     * Método que encuentra nombre del vertice a partir de su número
     * @param Vnum número del vertice
     * @return nombre del vertice o null si este no se encuentra
     */
    public String VnumToName(int Vnum){
        for(int x = 0; x < allPerson.len(); x++){
            if(allPerson.get(x).getVnum() == Vnum){
                return allPerson.get(x).getName();
            }
        }
        return null;
    }
    
    /**
     * Método que borra un vertice a partir de su nombre
     * @param name nombre del vertice
     */
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
    
    /**
     * Método que borra un vertice a partir de su número
     * @param num número del vertice
     */
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
    
    /**
     * Método que imprime el grafo en la consola
     */
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
    
    /**
     * Método que evalúa si dos vertices están o no conectados mediante los nombres
     * @param nameA persona A
     * @param nameB persona B
     * @return valor booleano dependiendo de si los vertices están conectados o no
     */
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
    
    /**
     * Método que evalúa si dos vertices están o no conectados mediante los números del vertice
     * @param VnumA número del vertice A
     * @param VnumB número del vertice B
     * @return valor booleano dependiendo de si los vertices están conectados o no
     */
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
    
    /**
     * Método que cuenta el número de relaciones que tiene un vertice
     * @param personA vertice A
     * @return número de relaciones que tiene el vertice dado
     */
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
    
    /**
     * Método que retorna las personas con las que tiene relaciones un vertice
     * @param person vertice A
     * @return una lista con las personas con las que esta relacionada
     */
    public List relations(Vperson person){
        List allRelations = new List();
        int VnumA = person.getVnum();
        for(int x = 0; x < allPerson.len(); x++){
            Vperson p = allPerson.get(x);
            int VnumB = p.getVnum();
            if(isConectedVnum(VnumA, VnumB) && VnumA != VnumB){
                allRelations.append(p);
            }
        }
        return allRelations;      
    }
    
    /**
     * Método que vuelve a settear el valor isVisited a true       
     */
    public void clearVisited(){
        for (int x = 0; x < allPerson.len(); x++) {
            Vperson p = allPerson.get(x);
            p.setVisited(false);
        }
    }
    
    
    /**
     * Método que realiza el recorrido por anchura
     * @param person vertice de inicio 
     */
    public void bfs(Vperson person){
        Queue<Vperson> queue = new Queue();

        queue.enqueue(person);
        person.setVisited(true);
        
        while(!queue.isEmpty()){
            Vperson p1 = queue.dequeue();
            List adyList = relations(p1);
            for(int y = 0; y < adyList.len(); y++){
                    Vperson p2 = (Vperson) adyList.get(y);
                    if(y != adyList.len()-1){
                        System.out.print(p2.getVnum() + ", ");
                    }
                    else{
                        System.out.println(p2.getVnum());
                    }
                }
            for(int x = 0; x < adyList.len(); x++){
                Vperson p2 = (Vperson) adyList.get(x);
                if(!p2.isVisited()){
                    p2.setVisited(true);
                    queue.enqueue(p2);
                }
            }
        }
    }
    
    /**
     * Método que realiza el recorrido por anchura y cuenta la cantidad de islas
     * @return count contador de islas
     */
    public int countIslandsBFS(){
        int count = 0;
        
        for(int x = 0; x < allPerson.len(); x++){
            Vperson p = allPerson.get(x);
            if(!p.isVisited()){
                bfs(p);
                count++;
            }
        }
        return count;
    }
    
    /**
     * Método que realiza el recorrido por profundidad
     * @param person vertice de inicio 
     */
    public void dfs(Vperson person){
        Stack stack = new Stack();
        List adyList = relations(person);
        
        stack.push(person);
        person.setVisited(true);
        
        for(int x = 0; x < adyList.len(); x++){
            Vperson p = (Vperson) adyList.get(x);
            if(!p.isVisited()){
                dfs(p);
            }
        }
    }
    
    /**
     * Método que realiza el recorrido por profundida y cuenta la cantidad de islas
     * @return count contador de islas
     */
    public int countIslandsDFS(){
        int count = 0;
        
        for(int x = 0; x < allPerson.len(); x++){
            Vperson p = allPerson.get(x);
            if(!p.isVisited()){
                dfs(p);
                count++;
            }
        }
        return count;
    }

    
    
    

    
    
    
    
}
