/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Juan
 */
public class Queue<T> {
    private Node start;
    private Node end;
    private int size;

    public Queue(Node start, Node end, int size) {
        this.start = start;
        this.end = end;
        this.size = size;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return start == null;
    }
    
    public void enqueue(T data){
        Node newNode = new Node(data);
        if(isEmpty()){
            start = newNode;
            end = newNode;
        }
        else{
            end.setNext(newNode);
            end = newNode;
        }
        size++;
    }
    
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        else{
            T data = (T) start.getData();
            Node newStart = start.getNext();
            start.setNext(null);
            start = newStart;
            return data;
        }
    }
}
