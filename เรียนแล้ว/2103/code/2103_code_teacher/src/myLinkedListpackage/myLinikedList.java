/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myLinkedListpackage;

/**
 *
 * @author PC
 */
public class myLinikedList {
    Node START=null;
    
    public void INSTFIRST(int item){   
        //Algorrithm 5.4 SEARCH  if AVAIL = NULL step. 1
        
        Node NEW=new Node();   //step. 2
        int ITEM=item;
        NEW.INFOR = item;
        NEW.LINK = START;
        START=NEW;
    }
    
    public void TraversalList(){
        Node PTR=null;
        PTR=START;
        while(PTR!=null){
            System.out.println(PTR.INFOR);
            PTR=PTR.LINK;
        }
    }

}

