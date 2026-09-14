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
public class Algor53SRCHSL {
    
    public static void main(String[] args) {
            SEARCH(10);
    }//end main
    //Method of Algorithm 5.2
    public static void SEARCH(int item) { 
        Node START;// = new Node(); START.INFOR = 100;
        Node NodeA = new Node(); NodeA.INFOR = 90;
        Node NodeB = new Node(); NodeB.INFOR = 80;
        Node NodeC = new Node(); NodeC.INFOR = 70;
        Node NodeD = new Node(); NodeD.INFOR = 60;
        Node NodeE = new Node(); NodeE.INFOR = 50;
        Node NodeF = new Node(); NodeF.INFOR = 40;
        Node NodeG = new Node(); NodeG.INFOR = 30;
        Node NodeH = new Node(); NodeH.INFOR = 20;
        Node NodeI = new Node(); NodeI.INFOR = 10;
        START = NodeA; NodeA.LINK = NodeB; NodeB.LINK = NodeC;
        NodeC.LINK = NodeD; NodeD.LINK = NodeE; NodeE.LINK = NodeF;
        NodeF.LINK = NodeG; NodeG.LINK = NodeH; NodeH.LINK = NodeI;
        //Algorrithm 5.2 SEARCH
        int ITEM = item;
        Node LOC=null;
        Node PTR=null;
        PTR=START;
        while(PTR!=null){        
          if(ITEM<(int)PTR.INFOR) {
              PTR=PTR.LINK; 
          }else
            if(ITEM==(int)PTR.INFOR){
                LOC = PTR;
                break;
            }else{
                LOC=null;
                break;
            }             
        }//end while
        //Show Result;
        if(LOC ==null) 
            System.out.println("Not found.");
        else
            System.out.println("Found." + LOC.INFOR);
    }

}
