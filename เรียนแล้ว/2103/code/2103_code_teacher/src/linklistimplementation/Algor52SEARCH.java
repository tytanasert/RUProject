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
public class Algor52SEARCH {
        public static void main(String[] args) {
        Node START;// = new Node(); START.INFOR = 10;
        Node NodeA = new Node(); NodeA.INFOR = 20;
        Node NodeB = new Node(); NodeB.INFOR = 30;
        Node NodeC = new Node(); NodeC.INFOR = 40;
        Node NodeD = new Node(); NodeD.INFOR = 50;
        Node NodeE = new Node(); NodeE.INFOR = 60;
        Node NodeF = new Node(); NodeF.INFOR = 70;
        Node NodeG = new Node(); NodeG.INFOR = 80;
        Node NodeH = new Node(); NodeH.INFOR = 90;
        Node NodeI = new Node(); NodeI.INFOR = 100;
        START = NodeA; NodeA.LINK = NodeB; NodeB.LINK = NodeC;
        NodeC.LINK = NodeD; NodeD.LINK = NodeE; NodeE.LINK = NodeF;
        NodeF.LINK = NodeG; NodeG.LINK = NodeH; NodeH.LINK = NodeI;
        //Algorrithm 5.2 SEARCH
        int ITEM = 70;
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
            System.out.println("Found."+LOC.INFOR);
    }

}
