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
public class Vperson {
    private String name;
    private int Vnum;
    private List<Edge> adyList;

    public Vperson(String name, int Vnum) {
        this.name = name;
        this.Vnum = Vnum;
        this.adyList = new List();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVnum() {
        return Vnum;
    }

    public void setVnum(int Vnum) {
        this.Vnum = Vnum;
    }

    public List getAdyList() {
        return adyList;
    }

    public void setAdyList(List adyList) {
        this.adyList = adyList;
    }
    
    
    
    
    
    
}