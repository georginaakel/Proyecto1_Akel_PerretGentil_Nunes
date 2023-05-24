/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DataStructures.Edge;
import DataStructures.List;
import DataStructures.Vperson;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 *
 * @author Juan
 */
public class Util {
    
    public void write_txt(List allPerson){
        String str = "Usuarios\n";
        if(allPerson.isEmpty() == false){
            for(int x = 0; x < allPerson.len(); x++){
                Vperson person = (Vperson) allPerson.get(x);
                str = str + person.getVnum() + "," + person.getName() + "\n";
            }
            str = str + "Relaciones\n";
            for(int x = 0; x < allPerson.len(); x++){
                Vperson person = (Vperson) allPerson.get(x);
                List auxList = person.getAdyList();
                for(int y = 0; y < auxList.len(); y++){
                    Edge edge = (Edge) auxList.get(y);
                    str = str + edge.getStart().getVnum() + "," + edge.getEnd().getVnum() + "," + edge.getWeight() + "\n"; 
                }
            }
        }             
        try{
            PrintWriter pw = new PrintWriter("C:\\Users\\Juan Diego\\Desktop\\Java\\Clases\\Proyecto1\\src\\TextFiles\\Persons.txt");
            pw.print(str);
            pw.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: no se a escrito sobre el archivo correctamente");
        }       
    }
    
    public List read_users(){
        List persons = new List();
        String line;
        String str = "";
        File newFile = new File("C:\\Users\\Juan Diego\\Desktop\\Java\\Clases\\Proyecto1\\src\\TextFiles\\Persons.txt");
        try{
            if(newFile.exists() == false){
                newFile.createNewFile();
            }
            else{
                FileReader fr = new FileReader(newFile);
                BufferedReader br = new BufferedReader(fr);
                
                while(!"Relaciones".equals(line = br.readLine())){
                    if(line.isEmpty() == false && line.equals("Usuarios") == false){
                        str += line + "\n";
                    }
                }
                if("".equals(str) == false){
                    String[] str_split = str.split("\n");
                    for(int x = 0; x < str_split.length; x++){
                        String[] Str = str_split[x].split(",");
                        Vperson pA, pB;
                    }
                }
                br.close();
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        return persons;
    }
    
    public List read_relations(List allPerson){
        List relations = new List();
        String line;
        String str = "";
        File newFile = new File("C:\\Users\\Juan Diego\\Desktop\\Java\\Clases\\Proyecto1\\src\\TextFiles\\Persons.txt");
        try{
            if(newFile.exists() == false){
                newFile.createNewFile();
            }
            else{
                FileReader fr = new FileReader(newFile);
                BufferedReader br = new BufferedReader(fr);
                
                boolean run = false;
                while(null != (line = br.readLine())){
                    System.out.println(line + " " + line.equals("Relaciones") + " " + run);
                    if(line.isEmpty() == false && line.equals("Usuarios") == false && run == true){
                        str += line + "\n";
                    }
                    if(line.equals("Relaciones") == true){
                        run = true;
                    }

                }
                
                if("".equals(str) == false){
                    String[] str_split = str.split("\n");
                    for(int x = 0; x < str_split.length; x++){
                        String[] Str = str_split[x].split(",");
                        Vperson personA = findPerson(Integer.parseInt(Str[0]), allPerson);
                        Vperson personB = findPerson(Integer.parseInt(Str[1]), allPerson);
                        Edge newEdge = new Edge(personA, personB, Integer.parseInt(Str[2]));
                        relations.append(newEdge);
                    }
                }
                br.close();
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        return relations;

    }
    
    public Vperson findPerson(int Vnum, List allPerson){
        Util f = new Util();
        
        Vperson person;
        person = null;
        int p;
        p = 0;       
        
        for(int x = 0; x < allPerson.getSize(); x++){
            Vperson pAux = (Vperson) allPerson.get(x);
            if(pAux.getVnum() == Vnum){
                person = pAux;
                p = x;
            }
        }
        if(person == null){
            return null;
        }
        else{
            return person;
        }
    }
        
    
    
    
    
    
    
    
    
}
