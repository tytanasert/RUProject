/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrativeSingleLists;

/**
 *
 * @author Dell
 */
public class SingleListApp {
    public static void main(String args[]){
        RUSingleList mylist = new RUSingleList();
        mylist.INSTFIRST(100);
        mylist.INSTLOC(50, 10);
        mylist.INSTLOC(10, 20);
        mylist.INSTLOC(20, 30);
        mylist.INSTLOC(10, 40);
        mylist.INSTLOC(10, 20);
        mylist.INSTFIRST(5);
        System.out.println("----- Data in List -----");
        mylist.TraversalList();
        System.out.println("----- Search 40 in List -----");
        Node result = mylist.SEARCH(40);
        if(result != null)
            System.out.println("Found.:"+result.INFOR.toString());
        System.out.println("----- Delete 30 from List -----");
        mylist.DEL(30);
        System.out.println("----- Data in List -----");
        mylist.TraversalList();
        
        
    }
    
}
