package caseStudy;

//import integretiveQueue.*;

public class RUPriQUEUE {
  
   int FRONT=-1,REAR=-1,N;
  Object PQUEUE[];
  int PRI[];  
  
  
  public RUPriQUEUE(int size){
      PQUEUE = new Object[size];
      PRI = new int[size];
      N=size-1;
  }
  public boolean isFull() {
        if ((FRONT == 0 && REAR == N) || (FRONT == REAR + 1)) {
            return true; //Can not insert
        }
        return false;
    }

    public boolean isEmpty() {
        if (FRONT == -1) {
            return true;
        }
        return false;
    }
  public  Object  QDELETE(){
    if(isEmpty()){
      System.out.println("Queue Empty.");
      return null;
    }
    Object ITEM=PQUEUE[FRONT];
    if(FRONT==REAR){
        FRONT=-1;
        REAR=-1;
    }else
        downwardData();//FRONT=0; 
          REAR--;
    return ITEM;
  }
  public void downwardData(){
      for(int i=0;i<REAR;i++){
          PQUEUE[i]= PQUEUE[i+1];
        PRI[i] = PRI[i+1];
      }
  }
  public boolean QINSERT(Object ITEM, int pri){
    if(isFull()){
       System.out.println("Queue Full.");
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
  
 public int shiftData(int pri){
     int pos=REAR;
     while((pos>0) && (pri<PRI[pos-1])){    
        PQUEUE[pos]= PQUEUE[pos-1];
        PRI[pos] = PRI[pos-1];
        pos--;        
     }
     if(pos<0) pos=0;
     return pos;
 } 
 public void showDatainQueue(){
     System.out.println("Data in Queue:");
     for(int i=FRONT;i<=REAR;i++){
        System.out.println(PQUEUE[i]+","+PRI[i]); 
     }   
     System.out.println("FRONT:"+FRONT +"  REAR:"+REAR);
 } 
 
}

