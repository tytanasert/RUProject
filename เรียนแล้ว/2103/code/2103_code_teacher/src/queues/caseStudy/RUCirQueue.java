
package caseStudy;

//import integretiveQueue.*;

public class RUCirQueue {   
   int FRONT=-1,REAR=-1,ITEM,N;
   Object QUEUE[];  
  
  public RUCirQueue(int size){
      QUEUE=new Object[size];
      N=size-1;
  }
  public boolean isFull(){
      if((FRONT==0 && REAR==N)|| (FRONT==REAR+1)){       
       return true; //Can not insert
    }
      return false;
  }
  public boolean isEmpty(){
      if(FRONT == -1) return true;
      return false;
  }
  public Object QDELETE(){
    if(isEmpty()){
      System.out.println("Queue Empty.");
      return null;
    }
    Object ITEM=QUEUE[FRONT];
    if(FRONT==REAR){
        FRONT=-1;
        REAR=-1;
    }else
        if(FRONT==N){
           FRONT=0; 
        }else
          FRONT++;
    return ITEM;
  }
  
  public boolean QINSERT(Object ITEM){     
    if(isFull()){
       System.out.println("Queue Full.");
       return false; //Can not insert
    }
    else
     if(isEmpty()){   //NULL concept
       FRONT=0; REAR=0;
     }else
        if(REAR==N) 
            REAR=0;
        else     
           REAR++;
    QUEUE[REAR]=ITEM;
    return true;
  } 
  
 public void showDatainQueue(){
     System.out.print("Data in Queue:");
     if(FRONT<=REAR){
       for(int i=FRONT;i<=REAR;i++){
          System.out.print(QUEUE[i]+","); 
       }   
     }else {
        for(int i=FRONT;i<=N;i++){
          System.out.print(QUEUE[i]+","); 
       }
       for(int i=0;i<=REAR;i++){
          System.out.print(QUEUE[i]+","); 
       } 
     }
     System.out.println();
     System.out.println("FRONT:"+FRONT);
     System.out.println("REAR:"+REAR);
 } 
 
}

