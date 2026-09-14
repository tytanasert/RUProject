/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trees;

//import static treeremain.Algor72INORDER.A;

/**
 *
 * @author ComSCIv3400
 */
public class Algor72INORDER {
      static Node A = new Node(); 
      static Node B = new Node(); 
      static Node C = new Node(); 
      static Node D = new Node(); 
      static Node E = new Node(); 
      static Node F = new Node(); 
      static Node G = new Node(); 
      static Node H = new Node(); 
      static Node J = new Node(); 
      static Node K = new Node(); 
      static Node L = new Node(); 
      static Node M = new Node(); 
      
      static Node ROOT;  //กำหนดตัวแปร ROOT
      static Node STACK[]= new Node[10];
      static Node PTR;
      static int TOP;
      
   public static void main(String args[]){
      //กำหนดข้อมูลแต่ละโนด
       A.INFOR = "A";
       B.INFOR = "B";
       C.INFOR = "C";
       D.INFOR = "D";
       E.INFOR = "E";
       F.INFOR = "F";
       G.INFOR = "G";
       H.INFOR = "H";
       J.INFOR = "J";
       K.INFOR = "K";
       L.INFOR = "L";
       M.INFOR = "M";
      //เชื่อมโยงการใช้งานตามรูปภาพที่ 7-6
      A.LEFT = B; A.RIGHT = C;
      B.LEFT = D; B.RIGHT = E;
      E.LEFT = F;
      C.LEFT = G; C.RIGHT = H;
      H.LEFT = J; H.RIGHT = K;
      J.LEFT = L;      
      
      ROOT=A;  // กำหนดค่า Root ชี้ไปยังโนด A
      TOP=1;
      STACK[1]=null;
      INORDER(ROOT); //ส่งทรีเข้าไปเพื่อทำการท่อง
  }  
   
public static void INORDER(Node root){
    PTR=root;
    Step2();    
    PTR = STACK[TOP]; TOP--; 
    while(PTR != null){           //step 4
      System.out.println(PTR.INFOR); //step5
      if(PTR.RIGHT != null){   //step 6
          PTR = PTR.RIGHT;
          Step2();
      }
        PTR = STACK[TOP]; TOP--;       
    }    
}    
 public static void Step2(){
    while(PTR != null){
      TOP++;  STACK[TOP] = PTR;
      PTR = PTR.LEFT;
    }//end of while loop
 }
 
}
