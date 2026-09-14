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
public class Algor45LinearSearch1 {

    public static void main(String args[]) {
        int DATA[] = {3, 1, 7, 0, 6, 9, 77, 12, 15, 10};
        int N = 9;
        int ITEM = 12;
        int LOC = -1, I = 1;
        while (I <= N) {
            if (DATA[I] == ITEM) {
                LOC = I;
                break;
            } else {
                I = I + 1;
            }
        } //end while 
        if (LOC == -1) {
           /// LOC = -1;
            System.out.println("ไม่พบ");
        } else {
            System.out.println("พบที่ :" + LOC);
        }

//       //เริ่มอัลกอริทึม
//       DATA[N]=ITEM;
//       int LOC=0;
//       while(DATA[LOC]!=ITEM){
//          LOC++; 
//       }
//       if(LOC==N) {
//         LOC=0;
//         System.out.println("ไม่พบ"); 
//       }
//       else
//          System.out.println("พบที่ :"+LOC); 
//       //จบอัลกอริทึม
    }//end main    

}//end class
