/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dqueue;

// Java implementation of De-queue using circular 
// array 

// A structure to represent a Deque 
public class InputDeque 
{ 	
	//---------------------
        static final int size=10;  
        static int FRONT=-1,REAR,ITEM,N=size,DQUEUE[]=new int[size];  

        //---------------------
        
//	// Inserts an element at front 
//	public static void insertfront(int ITEM) 
//	{ 
//		// check whether Deque if full or not 
//		if ((FRONT==0)&& (REAR==size-1)) 
//		{ 
//			System.out.println("Overflow"); 
//			return; 
//		} 
//
//		// If queue is initially empty 
//		if (FRONT == -1) 
//		{ 
//			FRONT = 0; 
//			REAR = 0; 
//		} 
//		
//		// front is at first position of queue 
//		else if (FRONT == 0) 
//			FRONT = size - 1 ; 
//
//		else // decrement front end by '1' 
//			FRONT = FRONT-1; 
//
//		// insert current element into Deque 
//		DQUEUE[FRONT] = ITEM ; 
//	} 
//
	// function to inset element at rear end 
	// of Deque. 
	public static void insertrear(int ITEM) 
	{ 
		// check whether Deque if full or not 
		if ((FRONT==0)&& (REAR==size-1)) 
		{ 
			System.out.println("Overflow"); 
			return; 
		} 

		// If queue is initially empty 
		if (FRONT == -1) 
		{ 
			FRONT = 0; 
			REAR = 0; 
		} 

		// rear is at last position of queue 
		else if (REAR == size-1) 
			REAR = 0; 

		// increment rear end by '1' 
		else
			REAR = REAR+1; 
		
		// insert current element into Deque 
		DQUEUE[REAR] = ITEM ; 
	} 

	// Deletes element at front end of Deque 
	public static int deletefront() 
	{ 
		// check whether Deque is empty or not 
		if (FRONT==-1) 
		{ 
			System.out.println("Queue Underflow\n"); 
			return -1; 
		} 
                ITEM = DQUEUE[FRONT];    
		// Deque has only one element 
		if (FRONT == REAR) 
		{ 
			FRONT = -1; 
			REAR = -1; 
		} 
		else
			// back to initial position 
			if (FRONT == size -1) 
				FRONT = 0; 

			else // increment front by '1' to remove current 
				// front value from Deque 
				FRONT = FRONT+1; 
                
           return ITEM;     
	} 

	// Delete element at rear end of Deque 
	public static int deleterear() 
	{ 
		if (FRONT==-1) 
		{ 
			System.out.println("Queue Underflow\n"); 
			return -1; 
		} 
                ITEM = DQUEUE[REAR];    
		// Deque has only one element 
		if (FRONT == REAR) 
		{ 
			FRONT = -1; 
			REAR = -1; 
		} 
		else if (REAR == 0) 
			REAR = size-1; 
		else
			REAR = REAR-1;
           return ITEM;
	} 

	// Returns front element of Deque 
	// Driver program to test above function 
	public static void main(String[] args) 
	{ 
		
		//InputDeque dq = new InputDeque(5); 
		
		System.out.println("Insert at rear"); 
		insertrear(5); 				
		insertrear(10); 
		insertrear(15); 				
		insertrear(20);
                insertrear(25); 				
		insertrear(30);
		System.out.println("Data in DQueue:");
                System.out.println("FRONT="+FRONT+" REAR:"+REAR);
                for(int i=FRONT;i<=REAR; i++){
                    System.out.print(DQUEUE[i]+" ");
                }
                System.out.println("Delete Data from front:");
                System.out.print(deletefront());
                System.out.print(deletefront());
                System.out.println("FRONT="+FRONT+" REAR:"+REAR);
                System.out.println("Delete Data from rear:");
                System.out.print(deleterear());
                System.out.print(deleterear());
                System.out.println("FRONT="+FRONT+" REAR:"+REAR);
		System.out.println("Data in DQueue:");
                for(int i=FRONT;i<=REAR; i++){
                    System.out.print(DQUEUE[i]+" ");
                }
		
	} 
} 

