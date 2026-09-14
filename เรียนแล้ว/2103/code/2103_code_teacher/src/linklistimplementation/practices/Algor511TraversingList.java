/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linklistimplementation.practices;

import linklistimplementation.*;

/**
 *
 * @author ComSCIv3400
 */
public class Algor511TraversingList {
        public static void main(String[] args) {
        Node START;//=new Node();
        Node NodeA = new Node(); 
           NodeA.name = "aaaa";
           NodeA.surname = "bbb";
           NodeA.age = 20;
           NodeA.salary = 456.89;
           
        Node NodeB = new Node(); 
           NodeB.name = "zzzaaaa";
           NodeB.surname = "dddbbb";
           NodeB.age = 25;
           NodeB.salary = 4456.89;
           
        Node NodeC = new Node(); 
           NodeC.name = "aaaaxx";
           NodeC.surname = "bbgggb";
           NodeC.age = 89;
           NodeC.salary = 4566.89;
           
           START = NodeA;  
           NodeA.Link = NodeB;  
           NodeB.Link = NodeC; 
           //NodeC.Link = START;      
        Node PTR=null;
        PTR=START;
        while(PTR!=null){
            System.out.println(PTR.name);  //Apply PROCESS to INFOR[PTR]
            System.out.println(PTR.surname);
            System.out.println(PTR.age);
            System.out.println(PTR.salary);
            System.out.println("-----------------------------");
            PTR=PTR.Link;
        }
    }

}
