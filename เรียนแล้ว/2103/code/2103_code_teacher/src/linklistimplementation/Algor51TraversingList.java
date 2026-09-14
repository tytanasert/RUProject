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
public class Algor51TraversingList {
        public static void main(String[] args) {
        Node START;// = new Node();
        //START.INFOR = 15;
        Node NodeA = new Node();
        NodeA.INFOR = 20;
        
        Node NodeB = new Node();
        NodeB.INFOR = 30;
        
        Node NodeC = new Node();
        NodeC.INFOR = 40;
        
        START = NodeA;
        NodeA.LINK = NodeB; 
        NodeB.LINK = NodeC;        
        
        Node PTR=null;
        PTR=START;
        while(PTR!=null){
            System.out.println(PTR.INFOR);  //Apply PROCESS to INFOR[PTR]
            PTR=PTR.LINK;
        }
    }

}
