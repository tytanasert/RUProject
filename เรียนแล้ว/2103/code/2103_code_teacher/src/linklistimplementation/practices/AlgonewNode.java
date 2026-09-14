/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linklistimplementation.practices;

//import linklistimplementation.*;

/**
 *
 * @author ComSCIv3400
 */
public class AlgonewNode {
        public static void main(String[] args) {
        Node START;//=new Node();
        Node Nodecur;
        Nodecur = new Node(); START = Nodecur; 
           Nodecur.name = "aaaa";
           Nodecur.surname = "bbb";
           Nodecur.age = 20;
           Nodecur.salary = 456.89;
          // currrent 
           
           Nodecur.Link = new Node(); 
           Nodecur = Nodecur.Link;
           Nodecur.name = "zzzaaaa";
           Nodecur.surname = "dddbbb";
           Nodecur.age = 25;
           Nodecur.salary = 4456.89;
           
           Nodecur.Link =new Node(); 
           Nodecur = Nodecur.Link;
           Nodecur.name = "aaaaxx";
           Nodecur.surname = "bbgggb";
           Nodecur.age = 89;
           Nodecur.salary = 4566.89;
           
           //START = NodeA;  
           //NodeA.Link = NodeB;  
           //NodeB.Link = NodeC; 
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
