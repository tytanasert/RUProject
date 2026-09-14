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
public class Algor56TO57FINDA {
        static Node START = new Node(); 
        
        public static void main(String[] args) {
        START.INFOR = 50;
        Node A = new Node(); A.INFOR = 60; START.LINK = A;        
        Node B = new Node(); B.INFOR = 70; A.LINK = B;
        Node C = new Node(); C.INFOR = 80; B.LINK = C;
        Node D = new Node(); D.INFOR = 90; C.LINK = D;
        Node E = new Node(); E.INFOR = 100; D.LINK =E;
        System.out.println("Data Befor INSERT:");
        showDatainList();
        Node LOC=FINDA(70); //ค้นหาข้อมูลที่จะแทรก        //call FINDA(...)
        INSLOC(LOC,75);         //Call INSLOC()...
        System.out.println("Data After INSERT:");
        showDatainList();
        }
        
     public static void INSLOC(Node LOC, int item){   
        //Algorrithm 5.5 SEARCH  if AVAIL = NULL step. 1                 
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
   public static Node FINDA(int ITEM){
        Node LOC=null;
        Node PTR=null;
        Node SAVE=null;
        PTR=START;
        if(START==null) { LOC=null; return LOC;}
        if(ITEM<(int)PTR.INFOR) { LOC=null; return LOC; }
        SAVE=START; PTR=START.LINK;
        while(PTR!=null){
          if(ITEM<(int)PTR.INFOR) { 
           LOC = SAVE; 
           return LOC; 
          }  
          SAVE=PTR;
          PTR=PTR.LINK;                   
        }
        LOC=SAVE;
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
