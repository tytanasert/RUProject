
package MMP.AC;
import java.util.Vector;
public class DataNode {
    private int State;
    private char charInNode;
    private DataNode BackLink;
    private Vector NextLink=new Vector();
    private int Terminate;
    public DataNode() {
        this.State = -1;
        this.charInNode = '$';
        this.BackLink = null;
        Terminate = 0;
    }
    public void setTerminate(){
        Terminate = 1;
    }
    public int getTerminate(){
        return Terminate;
    }
    public void setData(char ch){
        this.charInNode = ch;
    }
    public void setState(int s){
        this.State = s;
    }
    public int getState(){
        return State;
    }
    public char getData(){
        return charInNode;
    }
    public DataNode getBackLink(){
        return BackLink;
    }
    public void setBackLink(DataNode dat){
        this.BackLink = dat;      
    }
    public void setNextLink(DataNode dat){
        this.NextLink.add(dat);      
    }
    public Vector getNextLink(){
        return NextLink;      
    }

}
