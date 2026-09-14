package integretiveQueue;

public class RUDQueue {
    int FRONT = -1, REAR=-1, N;
    Object DQUEUE[];

    //---------------------
    public RUDQueue(int size){
        DQUEUE = new Object[size];
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
    // Inserts an element at front 

    public void insertfront(int ITEM) {
        // check whether Deque if full or not 
        if (isFull()) {
            System.out.println("Queue Full.");
            return;
        }

        // If queue is initially empty 
        if (isEmpty()) {
            FRONT = 0;
            REAR = 0;
        } // front is at first position of queue 
        else if (FRONT == 0) {
            FRONT = N;
        } else // decrement front end by '1' 
        {
            FRONT = FRONT - 1;
        }

        // insert current element into Deque 
        DQUEUE[FRONT] = ITEM;
    }

    // function to inset element at rear end 
    // of Deque. 
    public void insertrear(int ITEM) {
        // check whether Deque if full or not 
        if (isFull()) {
            System.out.println("Queue Full.");
            return;
        }

        // If queue is initially empty 
        if (isEmpty()) {
            FRONT = 0;
            REAR = 0;
        } // rear is at last position of queue 
        else if (REAR == N) {
            REAR = 0;
        } // increment rear end by '1' 
        else {
            REAR = REAR + 1;
        }

        // insert current element into Deque 
        DQUEUE[REAR] = ITEM;
    }

    // Deletes element at front end of Deque 
    public Object deletefront() {
        // check whether Deque is empty or not 
        if (isEmpty()) {
            System.out.println("Queue Empty.");
            return null;
        }
        Object ITEM = DQUEUE[FRONT];
        // Deque has only one element 
        if (FRONT == REAR) {
            FRONT = -1;
            REAR = -1;
        } else // back to initial position 
        if (FRONT == N) {
            FRONT = 0;
        } else // increment front by '1' to remove current 
        // front value from Deque 
        {
            FRONT = FRONT + 1;
        }

        return ITEM;
    }

    // Delete element at rear end of Deque 
    public Object deleterear() {
        if (isEmpty()) {
            System.out.println("Queue Empty.");
            return null;
        }
        Object ITEM = DQUEUE[REAR];
        // Deque has only one element 
        if (FRONT == REAR) {
            FRONT = -1;
            REAR = -1;
        } else if (REAR == 0) {
            REAR = N;
        } else {
            REAR = REAR - 1;
        }
        return ITEM;
    }

    public void showDatainQueue(){
     System.out.print("Data in Queue:");
     if(FRONT<=REAR){
       for(int i=FRONT;i<=REAR;i++){
          System.out.print(DQUEUE[i]+","); 
       }   
     }else {
        for(int i=FRONT;i<=N;i++){
          System.out.print(DQUEUE[i]+","); 
       }
       for(int i=0;i<=REAR;i++){
          System.out.print(DQUEUE[i]+","); 
       } 
     }
     System.out.println();
     System.out.println("FRONT:"+FRONT);
     System.out.println("REAR:"+REAR);
 } 
}
