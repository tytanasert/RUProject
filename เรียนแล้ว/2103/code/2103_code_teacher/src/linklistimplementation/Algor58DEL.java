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
public class Algor58DEL {
        static Node START;// = new Node(); 
        
        public static void main(String[] args) {
        //START.INFOR = 50;
        Node A = new Node(); A.INFOR = 60; START = A;        
        Node B = new Node(); B.INFOR = 70; A.LINK = B;
        Node C = new Node(); C.INFOR = 80; B.LINK = C;
        Node D = new Node(); D.INFOR = 90; C.LINK = D;
        Node E = new Node(); E.INFOR = 100; D.LINK =E;
        Node LOCP=B; 
        Node LOC=C;
        System.out.println("Data Befor Delete:");
        showDatainList();
        DEL(LOCP,LOC, START);         //Call DEL()...
        System.out.println("Data After Delete:");
        showDatainList();
        }
        
     public static void DEL(Node LOCP, Node LOC, Node START){   
        //Algorrithm 5.8 Delete 
        if(LOCP==null) {
          START = START.LINK;  //insert first Node
        }else
        {
           LOCP.LINK = LOC.LINK;
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
