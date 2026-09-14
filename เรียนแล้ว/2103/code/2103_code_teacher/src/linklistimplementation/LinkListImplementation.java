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
public class LinkListImplementation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //        java.util.List Node = new java.util.List();
        Node START = new Node();
        START.INFOR = 15;
        Node NodeA = new Node();
        NodeA.INFOR = 20;
        Node NodeB = new Node();
        NodeB.INFOR = 30;
        START.LINK = NodeA;
        NodeA.LINK = NodeB;        
        Node PTR=null;
        PTR=START;
        while(PTR!=null){
            System.out.println(PTR.INFOR);
            PTR=PTR.LINK;
        }
    }
    
}
