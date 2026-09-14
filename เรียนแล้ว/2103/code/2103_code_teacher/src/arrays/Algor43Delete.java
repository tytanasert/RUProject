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
public class Algor43Delete {
      final static int UB=10;
      static int LB=0,K;      
      static int LA[]=new int[UB];       
      static int N;

    public static void main(String args[]){
      //ตัวอย่างการกำหนดข้อมูล
      LA[0]=1; LA[1]=2; LA[2]=3; LA[3]=4; LA[4]=5;       //มีข้อมูล 4 รายการ
      N=5; //ค่าข้อมูลที่มีสูงสุดในอาร์เรย์ชุดนี้
      
      System.out.println("ก่อนลบ");
      for(int i=0;i<N;i++)
        System.out.println(LA[i]); //Apply PROCESS to LA[K]        
      
      K=1;  //กำหนดตำแหน่งสำหรับลบ
      Delete();  //เนื่องจากจาวา เริ่มนับอาเรย์จาก 0
      K=3;  //กำหนดตำแหน่งสำหรับลบ
      Delete();  //เนื่องจากจาวา เริ่มนับอาเรย์จาก 0
      K=1;  //กำหนดตำแหน่งสำหรับลบ
      Delete();  //เนื่องจากจาวา เริ่มนับอาเรย์จาก 0
      System.out.println("หลังลบ");
      for(int i=0;i<N;i++)
        System.out.println(LA[i]); //Apply PROCESS to LA[K] 
    } //จบ main
    
    public static void Delete(){ //(int LA[], int N, int K, int ITEM ){  //Inserting Operation
       int ITEM=LA[K];
       for (int J=K;J<N-1;J++){
           LA[J]=LA[J+1];
       }//end of Step 2 loop       
       N--;
    }  //Exit
    
    
}
