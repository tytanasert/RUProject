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
public class Algor42Insert {
      final static int UB=10;
      static int LB=0,K;      
      static int LA[]=new int[UB];       
      static int N;

    public static void main(String args[]){
      //ตัวอย่างการกำหนดข้อมูล
      LA[0]=1; LA[1]=2; LA[2]=3; LA[3]=4; LA[4]=5;       //มีข้อมูล 4 รายการ
      N=5; //ค่าข้อมูลที่มีสูงสุดในอาร์เรย์ชุดนี้
      
      System.out.println("ก่อนแทรก");
      for(int i=0;i<N;i++)
        System.out.println(LA[i]); //Apply PROCESS to LA[K]        
      
      K=3;  //กำหนดตำแหน่งสำหรับแทรก
      Insert(50);  //เนื่องจากจาวา เริ่มนับอาเรย์จาก 0
      System.out.println("หลังแทรก");
      for(int i=0;i<N;i++)
        System.out.println(LA[i]); //Apply PROCESS to LA[K] 
    } //จบ main
    
    public static void Insert(int ITEM){ //(int LA[], int N, int K, int ITEM ){  //Inserting Operation
       int J=N;
       while(J>=K){
           LA[J+1]=LA[J];
           J--;
       }//end of Step 2 loop
       LA[K]=ITEM;
       N++;
    }  //Exit
    
    
}
