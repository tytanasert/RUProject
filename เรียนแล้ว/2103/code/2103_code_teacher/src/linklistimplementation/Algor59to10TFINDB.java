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
public class Algor59to10TFINDB {
        static Node START = new Node(); 
        static Node LOCP=null; 
        static Node LOC=null;
        public static void main(String[] args) {
        START.INFOR = 50;
        Node A = new Node(); A.INFOR = 60; START.LINK = A;        
        Node B = new Node(); B.INFOR = 70; A.LINK = B;
        Node C = new Node(); C.INFOR = 80; B.LINK = C;
        Node D = new Node(); D.INFOR = 90; C.LINK = D;
        Node E = new Node(); E.INFOR = 100; D.LINK =E;
        System.out.println("Data Befor Delete:");
        showDatainList();        
        DEL(70);         //Call INSLOC()...
        System.out.println("Data After Delete:");
        showDatainList();
        }
        
  public static void DEL(int ITEM){   
        //Algorrithm 5.8 Delete 
       FINDB(ITEM);
       if(LOC==null) {
           System.out.println("ไม่มีข้อมูลที่จะลบจ้า....");
       }
       else
        if(LOCP==null) {
          START = START.LINK;  //insert first Node
        }else
        {
           LOCP.LINK = LOC.LINK;               
       }
    }
  
   public static boolean FINDB(int ITEM){
        
        Node PTR=null;
        Node SAVE=null;
        PTR=START;
        if(START==null) { LOC=null; LOCP=null; return true;}
        if((int)START.INFOR==ITEM) { LOC=START; LOCP=null; return true;}
        
        
        SAVE=START; PTR=START.LINK;
        while(PTR!=null){
          if((int)PTR.INFOR==ITEM) { 
           LOC = PTR; LOCP=SAVE; 
           return true; 
          }  
          SAVE=PTR;
          PTR=PTR.LINK;                   
        }
        LOC=null;
        //Show Result;
                if(LOC ==null){ 
                   System.out.println("Not found.");
                   return false;
                }
                else
                {
                    System.out.println("Found.");
                    return true;
                }             
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
