/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

import java.util.Scanner;

/**
 *
 * @author ty
 */
public class Ex_4_11 {

    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in); //ประก าศตัวแปรออบเจ็กต์ Scanner
        String s; //ประก าศตัวแปรสตริงเพื่อรับค ่าก ารป้อนจ ากออบเจ็กต์ Scanner
        System.out.println("Input String :"); //แสดงข้อคว ามให้ผู้ใช้เห็น
        s = stdin.next(); //รับข้ อมูลเก็บไว้ ในตั วแปรสตริง s
        System.out.println("Your Input String :" + s); //แสดงข้อมูลที่รับเข ้าไป
    }
}
