
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
    private boolean isvisited; 
    
     

    public Vperson(int Vnum, String name) {
        this.AdyList = new List();
        this.Vnum = Vnum;

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

    public boolean getIsvisited() {
        return isvisited;
    }

    public void setIsvisited(boolean isvisited) {
        this.isvisited = isvisited;
    }

    
    

    
}