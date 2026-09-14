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
public class Algor44BubbleSort {
    
    public static void main(String args[]){
       int DATA[]={3,1,7,0,6,9,77,12,15,10}; 
       int N=10;
       
       System.out.println("ก่อนการเรียง");
       for(int i=0;i<N;i++) System.out.println(DATA[i]);
       //เริ่มอัลกอริทึม
       for(int K=0; K<N-1;K++){    //K=0 เพราะจาวา เริ่ม 0 , วนจนถึง N-1 
          int PTR=0;
          while(PTR<((N-1)-K)){   //ต้องลดค่าลง 1 เสมอ
              System.out.println("รอบ :"+K+"N:"+N);
            if(DATA[PTR]>DATA[PTR+1]){
                int temp = DATA[PTR];  //Interchange 
                DATA[PTR]=DATA[PTR+1];
                DATA[PTR+1]=temp;
            }
            PTR++; 
            System.out.println("รอบ :"+PTR+"N:"+N+"PRT:"+PTR);
          }//end while loop
       }//end for loop   
       //จบอัลกอริทึม
       System.out.println("หลังการเรียง");
       for(int i=0;i<N;i++) System.out.println(DATA[i]);             
    }//end main    
    
}//end class
