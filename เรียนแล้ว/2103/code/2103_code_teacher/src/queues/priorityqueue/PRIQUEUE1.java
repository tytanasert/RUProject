/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package priorityqueue;

//import queues.*;

/**
 *
 * @author ComSCIv3400
 */
public class PRIQUEUE1 {
  static final int size=10;  
  static int FRONT=-1,REAR=-1,ITEM,N=size-1,PQUEUE[]=new int[size], PRI[]=new int[size];  
  
  public static void main(String args[]){
         QINSERT(50,3);
         QINSERT(60,2);
         QINSERT(70,1);
         QINSERT(80,5);
         QINSERT(90,1);
         QINSERT(90,3);
         QINSERT(90,4);
         showDatainQueue();
         QDELETE(); System.out.println("Deleted Data:"+ITEM);
         QDELETE(); System.out.println("Deleted Data:"+ITEM);
         showDatainQueue();
  }
  
  public static int  QDELETE(){
    if(FRONT==-1){
      System.out.println("UNDERFLOW");
      return -1;
    }
    ITEM=PQUEUE[FRONT];
    if(FRONT==REAR){
        FRONT=-1;
        REAR=-1;
    }else
        downwardData();//FRONT=0; 
          REAR--;
    return ITEM;
  }
  public static void downwardData(){
      for(int i=0;i<REAR;i++){
          PQUEUE[i]= PQUEUE[i+1];
        PRI[i] = PRI[i+1];
      }
  }
  public static boolean QINSERT(int ITEM, int pri){
     //ITEM=item; 
    if((FRONT==0 && REAR==N)|| (FRONT==REAR+1)){
       System.out.println("OVERFLOW");
       return false; //Can not insert
    }
    else
     if(FRONT==-1){   //NULL concept
       FRONT=0; REAR=0;
     }else{
       REAR++;
       //shiftData(pri);
     }
    int p = shiftData(pri);
    //System.out.println("Position after shift:"+p);
    PQUEUE[p]=ITEM;
    PRI[p]=pri;
    return true;
  } 
  
 public static int shiftData(int pri){
     int pos=REAR;
//     if(REAR==0) 
//         return pos=REAR;
//     else
//         pos=REAR;
    // System.out.println("Priory:"+pri+" pos:"+pos);
     while((pos>0) && (pri<PRI[pos-1])){
     //  System.out.println(" While Priory:"+pri+" pos:"+pos+ "PQ:"+PQUEUE[pos]+"pos PRI:"+PRI[pos]);  
        PQUEUE[pos]= PQUEUE[pos-1];
        PRI[pos] = PRI[pos-1];
     //   System.out.println("PQpos+1"+PQUEUE[pos+1]);
        pos--;        
     }
     if(pos<0) pos=0;
     return pos;
 } 
 public static void showDatainQueue(){
     System.out.println("Data in Queue:");
     for(int i=FRONT;i<=REAR;i++){
        System.out.println(PQUEUE[i]+","+PRI[i]); 
     }   
     System.out.println();
     System.out.println("FRONT:"+FRONT);
     System.out.println("REAR:"+REAR);
 } 
 
}

