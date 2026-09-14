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
public class Algor55INLOC {
        static Node START;// = new Node(); 
        
        public static void main(String[] args) {
        //START.INFOR = 100;
        Node A = new Node(); A.INFOR = 90; START = A;        
        Node B = new Node(); B.INFOR = 80; A.LINK = B;
        Node C = new Node(); C.INFOR = 70; B.LINK = C;
        Node D = new Node(); D.INFOR = 60; C.LINK = D;
        Node E = new Node(); E.INFOR = 50; D.LINK =E;
        System.out.println("Data Befor INSERT:");
        showDatainList();
        INSTLOC(70,65);  
        System.out.println("Data After INSERT:");
        showDatainList();
        }
        
     public static void INSTLOC(int loc, int item){   
        //Algorrithm 5.5 SEARCH  if AVAIL = NULL step. 1
         
        Node LOC=SEARCH(loc); //ค้นหาข้อมูลที่จะแทรก        
        Node NEW=new Node();   //step. 2
        int ITEM=item;
        NEW.INFOR = item;
        if(LOC==null) {
        NEW.LINK = START;  //insert first Node
        START=NEW;
        }else
        {
          NEW.LINK = LOC.LINK;
          LOC.LINK = NEW;
        }
    }
   public static Node SEARCH(int ITEM){
        Node LOC=null;
        Node PTR=null;
        PTR=START;
        while(PTR!=null){
          if(ITEM==(int)PTR.INFOR) {
              LOC = PTR;
              break;
          }else
            PTR=PTR.LINK;
        }
        //Show Result;
        if(LOC ==null) 
            System.out.println("Not found.");
        else
            System.out.println("Found.");
        
     return LOC;   
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
