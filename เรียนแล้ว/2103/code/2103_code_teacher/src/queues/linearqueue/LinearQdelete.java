/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linearqueue;


/**
 *
 * @author ComSCIv3400
 */
public class LinearQdelete {
  static final int size=10;  
  static int FRONT=-1,REAR=-1,ITEM,N=size,QUEUE[]=new int[size];  
  
  public static void main(String args[]){
         QINSERT(50);
         QINSERT(60);
         QINSERT(70);
         QINSERT(80);
         showDatainQueue();
         QDELETE(); System.out.println("Deleted Data:"+ITEM);
         QDELETE(); System.out.println("Deleted Data:"+ITEM);
         showDatainQueue();
  }
  
  public static boolean QDELETE(){
    if(FRONT==-1){
      System.out.println("UNDERFLOW");
      return false;
    }
    ITEM=QUEUE[FRONT];
    if(FRONT==REAR){
        FRONT=-1;
        REAR=-1;
    }else
        FRONT++;
    return true;
  }
  
 public static boolean QINSERT(int item){
     ITEM=item; 
    if(REAR==N){
       System.out.println("OVERFLOW");
       return false; //Can not insert
    }
    else
     if(FRONT==-1){   //NULL concept
       FRONT=0; REAR=0;
     }else
       REAR++;
    QUEUE[REAR]=ITEM;
    return true;
  }  
 public static void showDatainQueue(){
     System.out.print("Data in Queue:");
     for(int i=FRONT;i<=REAR;i++){
        System.out.print(QUEUE[i]+","); 
     }   
     System.out.println();
     System.out.println("FRONT:"+FRONT);
     System.out.println("REAR:"+REAR);
 } 
 
}

