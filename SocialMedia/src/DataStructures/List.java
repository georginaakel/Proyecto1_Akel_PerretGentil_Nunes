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
 * @param <T>
 */
public class List<T> {
    //Atributos de la clase
    private Node head;
    private Node tail;
    private int size;
    
    //Constructor 1: no recibe nada por parametros 
    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    //Constructor 2: recibe uno o mas datos para ser guardados en la lista cuando se inicialize
    public List(T... data) {
        for (T elemento : data) {
            append(elemento);
        }
    }
    
    //Getters and Setters
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
    
    //Procedimientos y Metodos
    
    //Dice si la lista esta vacia o no
    public boolean isEmpty(){
        return head == null;
    }
    
    //Retorna el tamaño de la lista
    public int len(){
        return getSize();
    }
    
    //Borra la lista
    public void delete(){
        head = null;
        tail = null;
        size = 0;
    }
    
    //Agrega un elemento al final de la lista
    public final void append(T data){
        Node newNode = new Node(data);
        if(isEmpty() == true){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }
    
    //Agrega un elemento al incio de la lista
    public void preappend(T data){
        Node newNode = new Node(data);
        if(isEmpty() == true){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            newNode.setNext(head);
            head = newNode;
            size++;
        }
    }
    
    //Obtiene un valor de la posicion indicada de la lista
    public T get(int position){
        Node pointer = head;
        if(position < 0 || position >= len()){
            return null;
        }
        else if(position == 0){
            return (T) head.getData();
        }
        else if(position == len()-1){
            return (T) tail.getData();
        }
        else{
            for(int x = 1; x <= position; x++){
                pointer = pointer.getNext();
            }
            return (T) pointer.getData();
        }
    }
    
    //Imprime en pantalla la lista
    public void print(){
        Node pointer = head;
        if(isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
        else{
            String list = "[";
            for(int x = 0; x < getSize(); x++){
                if(x != getSize()-1){
                    list = list + pointer.getData() + ", ";
                    pointer = pointer.getNext();
                }
                else{
                    list = list + pointer.getData() + "]";
                }
            }
            JOptionPane.showMessageDialog(null, list);
        }
    }
    
    //Inserta un elemento en la posicion indicada
    public void insert(int position, T data){
        boolean run = true;
        Node newNode = new Node(data);
        while(run == true){
            if(position < 0 || position >= len()){
                run = false;
            }
            else{
                if(position == 0){
                    preappend(data);
                    run = false;
                }
                else{
                    Node pointer = head;
                    for(int x = 1; x < position; x++){
                        pointer = pointer.getNext();
                    }
                    newNode.setNext(pointer.getNext());
                    pointer.setNext(newNode);
                    size++;  
                    run = false;
                }
            }
        }
    }
    
    //Reemplaza un elemento de la posicion indicada de la lista por otro
    public void replace(int position, T data){
        boolean run = true;
 
        while(run == true){
            if(position < 0 || position >= len()){
                run = false;
            }
            else{
                if(position == 0){
                    head.setData(data);
                    run = false;
                }
                else if(position == len()-1){
                    tail.setData(data);
                    run = false;
                }
                else{
                    Node pointer = head;
                    for(int x = 0; x < position; x++){
                        pointer = pointer.getNext();
                    }
                    pointer.setData(data);
                    run = false;
                }
            }
        }
    }
    
    //Elimina un elemento de la posicion indicada de la lista
    public void pop(int position){
        Node pointer = head;
        if(position == 0){
            head = head.getNext();
            size--;
        }
        else if(position == len()-1){
            for(int x = 2; x < len(); x++){
                pointer = pointer.getNext();
            }
            pointer.setNext(null);
            tail = pointer;
            size--;
        }
        else{
            for(int x = 1; x < position-1; x++){
                pointer = pointer.getNext();
            }
            pointer.setNext(pointer.getNext().getNext());
            size--;
        }
    }
    
    //parcial
    public List tresListas(List listA, List listB, List listC){
        listA.getTail().setNext(listB.getHead());
        listB.getTail().setNext(listC.getHead());
        listC.getTail().setNext(listA.getHead());
        
        listA.setSize(listA.len() + listB.len() + listC.len());
        return listA;
    }
    
    
    
    
    
    
    
}
