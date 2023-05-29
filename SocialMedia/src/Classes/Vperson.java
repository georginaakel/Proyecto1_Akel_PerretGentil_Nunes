
package Classes;

import Classes.Edge;
import DataStructures.List;

/**
 *
 * @author Juan
 */
public class Vperson {
    private List<Edge> AdyList;
    private int Vnum;
    private String name;
    private boolean isVisited; 
    
     

    public Vperson(int Vnum, String name) {
        this.AdyList = new List();
        this.Vnum = Vnum;
        this.isVisited = false;

    }

    public List getAdyList() {
        return AdyList;
    }
    
    public void addToAdyList(Edge edge){
        this.AdyList.append(edge);
    }

    public void setAdyList(List AdyList) {
        this.AdyList = AdyList;
    }

    public int getVnum() {
        return Vnum;
    }

    public void setVnum(int Vnum) {
        this.Vnum = Vnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    

    
    

    
}