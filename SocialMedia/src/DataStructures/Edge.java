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
public class Edge {
    private Vperson start;
    private Vperson end;
    private int weight;

    public Edge(Vperson start, Vperson end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Vperson getStart() {
        return start;
    }

    public void setStart(Vperson start) {
        this.start = start;
    }

    public Vperson getEnd() {
        return end;
    }

    public void setEnd(Vperson end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
}
