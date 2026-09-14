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
public class Algor511TraversingList {
        public static void main(String[] args) {
        Node START=new Node();
        Node NodeA = new Node(); NodeA.INFOR = 20;
        Node NodeB = new Node(); NodeB.INFOR = 30;
        Node NodeC = new Node(); NodeC.INFOR = 40;
        START.LINK = NodeA;  NodeA.LINK = NodeB;  NodeB.LINK = NodeC; NodeC.LINK = START;      
        Node PTR=null;
        PTR=START.LINK;
        while(PTR!=START){
            System.out.println(PTR.INFOR);  //Apply PROCESS to INFOR[PTR]
            PTR=PTR.LINK;
        }
    }

}
