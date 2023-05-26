/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.Graph;
import GraphicInterface.Interface1;
import GraphicInterface.Interface2;

/**
 *
 * @author Orveo Di Luca
 */
public class App {
    Interface1 in1 = new Interface1();
    Interface2 in2 = new Interface2(in1.getGraph());
    
}
