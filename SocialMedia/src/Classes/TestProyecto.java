/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Util;
import DataStructures.Grafo;
import DataStructures.List;
import GraphicInterface.LoadFile;


/**
 *
 * @author Juan
 */
public class TestProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Se crea un obejeto de la interfaz para cargar archivo y se hace visible   
        LoadFile inter = new LoadFile();
        inter.setVisible(true);
        
        String str = "hola";
        boolean a = str.contains("hol");
        System.out.println(a);
               
        
        
     
    }
    
}