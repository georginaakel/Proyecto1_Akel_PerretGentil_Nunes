/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *Clase de la estructura de dato, cola.
 * @author Orveo Di Luca
 */
public class Queue<T> {
    private Node head; 
    private Node tail;
    private int size; 
    
    //Vacía la cola. 
    public Queue() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    //Agrega el elementto a la cola. 
    public void encolar(T data){
        Node nodo = new Node(data);
        if (this.isEmpty()){
            head = tail = nodo;
        } else {
            Node aux = tail;
            aux.setNext(nodo);
        }
        tail = nodo;
        size++;
    }
    
    //Borra el elemento de la cola. 
   public T pop() {
        if (isEmpty()) {
            return null;
        }
        T elemento = (T) head.getData();
        Node<T> aux = head.getNext();
        head = null;
        head = aux;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return elemento;
    }
    
    public T get(int index) {
        Node<T> buscado = new Node(index);
        return buscado.getData();
    }
    
    
    
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
