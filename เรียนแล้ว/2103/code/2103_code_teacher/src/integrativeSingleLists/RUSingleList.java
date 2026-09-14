
package integrativeSingleLists;

public class RUSingleList {

    Node START = null;

    public void INSTFIRST(Object ITEM){   
        //Algorrithm 5.4 SEARCH  if AVAIL = NULL step. 1
        
        Node NEW=new Node();   //step. 2        
        NEW.INFOR = ITEM;
        NEW.LINK = START;
        START=NEW;
    }
    
    public void TraversalList() {
        Node PTR = null;
        PTR = START;
        while (PTR != null) {
            System.out.println(PTR.INFOR);
            PTR = PTR.LINK;
        }
    }

    public void INSTLOC(Object loc, Object ITEM) {
        Node LOC = SEARCH(loc); //ค้นหาข้อมูลที่จะแทรก        
        Node NEW = new Node();   //step. 2
        NEW.INFOR = ITEM;
        if (LOC == null) {
            NEW.LINK = START;  //insert first Node
            START = NEW;
        } else {
            NEW.LINK = LOC.LINK;
            LOC.LINK = NEW;
        }
    }

    public Node SEARCH(Object ITEM) {
        Node LOC = null;
        Node PTR = null;
        PTR = START;
        while (PTR != null) {
            if (ITEM == PTR.INFOR) {
                LOC = PTR;
                return LOC;
            } else {
                PTR = PTR.LINK;
            }
        }
        return LOC;
    }

    public void DEL(Node LOCP, Node LOC, Node START) {
        //Algorrithm 5.8 Delete 
        if (LOCP == null) {
            START = START.LINK;  //insert first Node
        } else {
            LOCP.LINK = LOC.LINK;
        }
    }

    public boolean DEL(int ITEM) {
        //Algorrithm 5.8 Delete 
        Node result[]=FINDB(ITEM);
        Node LOC = result[0];
        Node LOCP = result[1];
        if (LOC == null) {
            System.out.println("ไม่มีข้อมูลที่จะลบจ้า....");
            return false;
        } else if (LOCP == null) {
            START = START.LINK;  //insert first Node
        } else {
            LOCP.LINK = LOC.LINK;
        }
        return true;
    }

    public Node[] FINDB(Object ITEM) {
        Node Location[] = new Node[2];
        Node PTR = null;
        Node SAVE = null;
        Node LOC = null;
        Node LOCP = null;
        PTR = START;
        if (START == null) {
            LOC = null;
            LOCP = null;
            Location[0] = LOC;
            Location[1] = LOCP;
            return Location;
        }
        if (START.INFOR == ITEM) {
            LOC = START;
            LOCP = null;
            Location[0] = LOC;
            Location[1] = LOCP;
            return Location;
        }
        SAVE = START;
        PTR = START.LINK;
        while (PTR != null) {
            if (PTR.INFOR == ITEM) {
                LOC = PTR;
                LOCP = SAVE;
                Location[0] = LOC;
                Location[1] = LOCP;
                return Location;
            }
            SAVE = PTR;
            PTR = PTR.LINK;
        }
        LOC = null;
        //Show Result;
        if (LOC == null) {
            System.out.println("Not found.");
            Location[0] = LOC;
            Location[1] = LOCP;
            return Location;

        } else {
            System.out.println("Found.");
            Location[0] = LOC;
            Location[1] = LOCP;
            return Location;

        }
    }

}
