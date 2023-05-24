/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Juan
 * @param <T>
 */
public class Node<T> {
    //Atributos de la clase
    private Node next;
    private T data;
    
    //Constructor: recibe por parametro la informacion del nodo
    public Node(T data) {
        this.next = null;
        this.data = data;
    }
    
    //Getters and Setters
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    
}
