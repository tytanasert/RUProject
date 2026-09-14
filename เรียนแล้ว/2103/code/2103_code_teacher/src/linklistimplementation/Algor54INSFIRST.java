/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linklistimplementation;

/**
 *
 * @author ComSCIv3400
 */
public class Algor54INSFIRST {
        static Node START;
        static Node FirstNode = new Node(); 
        public static void main(String[] args) {
        FirstNode.INFOR = 10; 
        START=FirstNode;
        System.out.println("Data Befor INSERT:");
        showDatainList();
        INSTFIRST(20);  
        INSTFIRST(30);  
        INSTFIRST(40);  
        System.out.println("Data After INSERT:");
        showDatainList();
        }
        
     public static void INSTFIRST(int item){   
        //Algorrithm 5.4 SEARCH  if AVAIL = NULL step. 1
        
        Node NEW=new Node();   //step. 2
        int ITEM=item;
        NEW.INFOR = item;
        NEW.LINK = START;
        START=NEW;
    }
     
   public static void showDatainList(){
        Node PTR=null;
        PTR=START;
        while(PTR!=null){
            System.out.println(PTR.INFOR);
            PTR=PTR.LINK;
        }
       
   }
}
