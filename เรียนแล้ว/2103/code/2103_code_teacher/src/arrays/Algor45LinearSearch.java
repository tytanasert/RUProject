/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;

/**
 *
 * @author ComSCIv3400
 */
public class Algor45LinearSearch {
    
    public static void main(String args[]){
       int DATA[]={3,1,7,0,6,9,77,12,15,10,0}; 
       int N=10;
       int ITEM=12;
       //เริ่มอัลกอริทึม
       DATA[N]=ITEM;
       int LOC=0;
       while(DATA[LOC]!=ITEM){
          LOC++; 
       }
       if(LOC==N) {
         LOC=0;
         System.out.println("ไม่พบ"); 
       }
       else
          System.out.println("พบที่ :"+LOC); 
       //จบอัลกอริทึม
    }//end main    
    
}//end class
