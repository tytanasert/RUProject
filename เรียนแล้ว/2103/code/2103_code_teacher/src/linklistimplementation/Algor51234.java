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
public class Algor51234 {
        static Node START=new Node();
        static Node LOC=null,LOCP=null, SAVE=null, PTR=null;
        
        public static void main(String[] args) {
 
        Node NodeA = new Node(); NodeA.INFOR = 20;
        Node NodeB = new Node(); NodeB.INFOR = 30;
        Node NodeC = new Node(); NodeC.INFOR = 40;
        START.LINK = NodeA;  NodeA.LINK = NodeB;  NodeB.LINK = NodeC; NodeC.LINK = START;      
        showData(); //แสดงข้อมูล
        
        if(SRCHL(40)!=null) { System.out.println("พบข้อมูลในลิสต์"); } //ตัวอย่างการค้นหา
        DELLOCHL(30); //ลบข้อมูล
        showData(); //แสดงข้อมูล
        }   
    //end main    
  public static void showData(){  //แสดงข้อมูล
        PTR=START.LINK; 
        while(PTR!=START){
            System.out.println(PTR.INFOR);  //Apply PROCESS to INFOR[PTR]
            PTR=PTR.LINK;
        }
    }
   public static Node SRCHL(int ITEM){   //Algorithm 5.12       
       PTR=START.LINK;
      while((int)PTR.INFOR!=ITEM){
          PTR=PTR.LINK;
      } 
      if((int)PTR.INFOR==ITEM) 
          LOC=PTR;
      return LOC;
   }
   
  public static void FINDBHL(int ITEM) { //Algorithm 5.13       
    SAVE=START;
    PTR=START.LINK;
    while(((int)PTR.INFOR!=ITEM)&& (PTR!=START)){
      SAVE=PTR;
      PTR=PTR.LINK;
    } 
    if((int)PTR.INFOR==ITEM){
      LOC=PTR;
      LOCP=SAVE;
    }else
    {
       LOC=null;  
       LOCP=SAVE;
    }
  }
  
 public static void DELLOCHL(int ITEM){ //Algorithm 5.14       
     FINDBHL(ITEM);
     if(LOC==null) {
      System.out.println("ข้อมูล:"+ITEM+" ไม่อยู่ใน List");
     }else
     {
       LOCP.LINK = LOC.LINK;   
     }        
  } 
 
}
