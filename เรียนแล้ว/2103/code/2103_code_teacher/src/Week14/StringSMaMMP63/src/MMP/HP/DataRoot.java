
package MMP.HP;

import java.util.Vector;

public class DataRoot {
    private Vector Link=new Vector();
    private int totalState;

    public DataRoot() {
        //Link = null;
        totalState =0;
    }
    public void addLink(Object l){
        this.Link.add(l);      
    }
    public Vector getLink(){
        return Link;      
    }
    public void addState(){
        totalState++;
        
    }
    public int getTotalState(){
        return totalState;
    }
}
