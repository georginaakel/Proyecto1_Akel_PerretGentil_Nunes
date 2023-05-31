/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Stack<T> {
    //Atributos de la clase
    private Node top;
    private Node bottom;
    private int size;

    //Constructor: no recibe valores por parametros
    public Stack() {
        this.top = null;
        this.bottom = null;
        this.size = 0;
    }
    
    //====================Getters and Setters===================
    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Node getBottom() {
        return bottom;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    //===================Procedimientos y metodos=================
    
    //Retorna un valor booleando dependiendo de si la pila esta vacia o no
    public boolean isEmpty(){
        return top == null;
    }
    
    public T peek(){
        if(isEmpty() == true){
            return null;
        }
        else{
            return (T) top.getData();
        }
    }
    
    public void push(T data){
        Node newNode = new Node(data);
        if(isEmpty() == true){
            top = newNode;
            bottom = newNode;
            size++;
        }
        else{
            top.setNext(newNode);
            top = newNode;
            size++;
        }
    }
    
    public Node pop(){
        Node pAux = null;
        if(isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Error: pila vacia");
        }
        else{
            Node pointer = bottom;
            while(pointer.getNext().getNext() != null){
                pointer = pointer.getNext();
            }
            pAux = top;
            pointer.setNext(null);
            top = pointer;
            size--;
        }
        return pAux;
    }
    
    
    
}
