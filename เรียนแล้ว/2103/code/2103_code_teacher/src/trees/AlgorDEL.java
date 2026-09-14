/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trees;

//import static treeremain.Algor71PREORDER.STACT;

/**
 *
 * @author ComSCIv3400
 */
public class AlgorDEL {
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
      static Node ROOT,LOC,SAVE,PAR,PTR, CHILD, SUC, PARSUC;  //กำหนดตัวแปร ROOT
      static int ITEM;
      static Node STACK[]= new Node[10];
      
    public static void main(String args[]){
          //กำหนดข้อมูลแต่ละโนด
           A.INFOR = 20;
           B.INFOR = 10;
           C.INFOR = 30;
           D.INFOR = 8;
           E.INFOR = 15;
           F.INFOR = 12;
           G.INFOR = 25;
           H.INFOR = 40;
           J.INFOR = 35;
           K.INFOR = 50;
           L.INFOR = 31;
           M.INFOR = 13;
          //เชื่อมโยงการใช้งานตามรูปภาพที่ 7-6
          A.LEFT = B; A.RIGHT = C;
          B.LEFT = D; B.RIGHT = E;
          E.LEFT = F; //E.RIGHT =M;
           // E.RIGHT =M;
          C.LEFT = G; C.RIGHT = H;
          H.LEFT = J; H.RIGHT = K;
          J.LEFT = L;      
          ROOT=A;  // กำหนดค่า Root ชี้ไปยังโนด A
          ITEM=30;
          PREORDER(A);
          if(FIND(ITEM)) System.out.println("ค้นพบ");
          DEL();
          PREORDER(A);
      }
    
  public static boolean FIND(int item){
    if(ROOT==null) {LOC=null; PAR=null;  return false; }
    if(ITEM==(int)ROOT.INFOR) {LOC=ROOT; PAR=null; return true; }
    if(ITEM<(int)ROOT.INFOR) {
       PTR=ROOT.LEFT;
       SAVE=ROOT;
    }else
    {
      PTR=ROOT.RIGHT;
      SAVE=ROOT;
    } //end if
    while(PTR !=null){
        if(item==(int) PTR.INFOR) {
            LOC=PTR;
            PAR=SAVE;
            System.out.println(LOC.INFOR);
            System.out.println(PTR.INFOR);
            return true;
        }
        if(ITEM<(int)PTR.INFOR){
            SAVE=PTR;
            PTR=PTR.LEFT;
        }else
        {
           SAVE=PTR;
           PTR = PTR.RIGHT;
        }
    }//end while
    LOC=null; PAR=SAVE;
    return false;  
  } //end method
     
 public static void DEL(){
     FIND(ITEM);
     if(LOC==null) return;
     if(LOC.RIGHT!=null && LOC.LEFT!=null)
             CASEB();
     else
             CASEA();     
 }   
 
 public static void CASEA(){
     System.out.println("Data LOC:"+LOC.INFOR);
     System.out.println("Data PAR:"+PAR.INFOR);
     if(LOC.LEFT==null && LOC.RIGHT==null)
         CHILD =null;
     else
          if(LOC.LEFT!=null)
              CHILD = LOC.LEFT;
          else
              CHILD = LOC.RIGHT;
     if(PAR!=null)
         if(LOC==PAR.LEFT)
             PAR.LEFT = CHILD;
         else
             PAR.RIGHT = CHILD;
     else
         ROOT = CHILD;
     System.out.println("Del CASE A OK.");
 } 
 public static void CASEB(){
     PTR = LOC.RIGHT; SAVE = LOC;
     while(PTR.LEFT!=null){
         SAVE = PTR;
         PTR = PTR.LEFT;
     }
     SUC = PTR; PARSUC = SAVE;
    Node tempLOC=LOC, tempPAR=PAR; //จำไว้ชั่วคราว
    LOC = SUC; PAR=PARSUC;
     CASEA(); //ลบส่วนที่เป็นการเรียกใช้กรณีแรก A
    LOC = tempLOC; PAR=tempPAR; 
     if(PAR!=null)
         if(LOC == PAR.LEFT)
             PAR.LEFT = SUC;
          else
             PAR.RIGHT = SUC;
     else
         ROOT = SUC;
    SUC.LEFT = LOC.LEFT;
    SUC.RIGHT = LOC.RIGHT;
     System.out.println();
 }
 
 public static void PREORDER(Node root){
    int TOP=1;
    STACK[1]=null;
    PTR=root;
    while(PTR!=null){
        System.out.println(PTR.INFOR); //Apply PROCESS to INFOR[PTR]
        if(PTR.RIGHT != null){
            TOP++;
            STACK[TOP] = PTR.RIGHT;
        }
        if(PTR.LEFT != null){
            PTR = PTR.LEFT;
        }else
        {
            PTR = STACK[TOP];
            TOP--;
        } 
    }//end of while loop
}    

}
