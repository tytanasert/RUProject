/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trees;

/**
 *
 * @author ComSCIv3400
 */
public class Algor73POSTORDER {
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
      
      static Node ROOT;  //กำหนดตัวแปร ROOT
      static Node STACK[]= new Node[10];
      static int TOP=1, mark[]={0,0,0,0,0,0,0,0,0,0};
      static int indexmark=0;
      static Node PTR;
      
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
      //เชื่อมโยงการใช้งานตามรูปภาพที่ 7-6
      A.LEFT = B; A.RIGHT = C;
      B.LEFT = D; B.RIGHT = E;
      E.LEFT = F;
      C.LEFT = G; C.RIGHT = H;
      H.LEFT = J; H.RIGHT = K;
      J.LEFT = L;      
      ROOT=A;  // กำหนดค่า Root ชี้ไปยังโนด A
      POSTORDER(ROOT); //ส่งทรีเข้าไปเพื่อทำการท่อง
  }  
   
   
public static void POSTORDER(Node root){
    //int TOP=1, mark[]={0,0,0,0,0,0,0,0,0,0};
    STACK[1]=null;
    PTR=root;   
    
    Step2();
    
//    PTR=STACK[TOP]; indexmark= mark[TOP]; TOP--; //step 6
//    
//    while(indexmark>0){   //Step 7
//      System.out.println(PTR.INFOR);
//      PTR=STACK[TOP]; indexmark= mark[TOP]; TOP--;
//    }   
//      if(indexmark<0){  //step 8
//           Step2();
//      }
       
    
}    
 public static void Step2(){
    while(PTR != null){  //step2
      TOP++;  STACK[TOP] = PTR; mark[TOP] = 1; //step 3
      if(PTR.RIGHT!=null){
          TOP++; STACK[TOP] = PTR.RIGHT; mark[TOP]=-1;  //step 4         
      }
      PTR = PTR.LEFT; //step 5
    }//end of while loop step 2
     Step3();
 }   
 
 public static void Step3(){
        PTR=STACK[TOP]; indexmark= mark[TOP]; TOP--; //step 6
    
    while(indexmark>0){   //Step 7
      System.out.println(PTR.INFOR);
      PTR=STACK[TOP]; indexmark= mark[TOP]; TOP--;
    }   
      if(indexmark<0){  //step 8
           Step2();
      }    
 }
 
}
