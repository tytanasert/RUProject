/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaADT;

import java.util.*;

public class PriorityQueueDemo {
   public static void main(String args[]) {
      // create priority queue
      PriorityQueue < Integer >  prq = new PriorityQueue < Integer > (); 
       
      // insert values in the queue
      for ( int i = 3; i  <  10; i++ ){  
         prq.add (new Integer (10-i)) ; 
      }
      
      System.out.println ( "Initial priority queue values are: "+ prq);
      
      // get the head from the queue
      Integer head = prq.poll();
      
     
      System.out.println ( "Head of the queue is: "+ head);
      
      System.out.println ( "Priority queue values after poll: "+ prq);
   }
}