/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5_6_array;

/**
 *
 * @author 66944
 */
public class HelloArray {

    public static void main(String args[]) {
        int DATA[] = new int[10];
        System.out.println("Before Input Data:");
        for (int i = 0; i < 10; i++) {
//            IO.print("DATA[" + i + "]=" + DATA[i] + ", ");
        }
        DATA[0] = 23;
        DATA[1] = 45;
        DATA[2] = 5;
        DATA[3] = 7;
        DATA[4] = 28;
        DATA[5] = 55;
        DATA[6] = 78;
        DATA[7] = 89;
        DATA[8] = 90;
        DATA[9] = 1;
        System.out.println("\nAfter Input Data:");
        for (int i = 0; i < 10; i++) {
//            IO.print("DATA[" + i + "]=" + DATA[i] + ", ");
        }
    }
}
