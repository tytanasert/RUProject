/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5_6_array;

/**
 *
 * @author 66944
 */
public class ArrayTraversing1 {

    public static void WhileTraversing(int LA[], int LB, int UB) {
        int K = LB;                 //Step 0
        while (K <= (UB - 1)) {            //Step 2 
            System.out.print(LA[K] + ","); //Apply PROCESS to LA[K] 
            K++;
        }                         //end of Step 2
    }

    public static void main(String args[]) {
        final int UB = 10;
        int LB = 0;
        int LA[] = {11, 22, 33, 44, 55, 66, 77, 88, 99, 1010}; //new int[UB];     //Step 1
        WhileTraversing(LA, LB, UB); 
    }
}
