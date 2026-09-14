/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Char;

/**
 *
 * @author PC
 */
public class Ex14 {
    public static void main(String args[]){
        String st="Test String ทดสอบ สตริง";
        String st1="Ant Rat Cat Dog";        
        int result1 = st1.compareTo("Ant Rat Cat Dog"); // เปรียบเทียบได้ผลลัพธ์เป็นตัวเลข
        boolean result2 = st.contains("ทดสอบ"); //ตรวจสอบว่ามีหรือไม่ ผลลัพธ์เป็นบูลีน
        int result3 = st1.indexOf("Cat");//ตรวจสอบสายอักขระย่อยอยู่ตำแหน่งใด
        String result4 = st1.substring(5,15); //ตัดเอาเฉพาะตำแหน่งที่ระบุ
        String result5=st1.replace("Rat", "Bird"); //แทนที่สายอักขระย่อยในสายอักขระหลัก
        System.out.println("ผลการเปรียบเทียบ st กับ st1 :"+result1);
        System.out.println("ผลการตรวจสอบว่ามีข้อความ ทดสอบ ใน st หรือไม่ :"+result2);
        System.out.println("ผลการหาตำแหน่ง Cat ใน st1 :"+result3);
        System.out.println("ผลการนำเอาสายอักขระออกมาจาก st1 :"+result4);
        System.out.println("ผลการแทนที่ Rat ด้วย Bird  st1 :"+result5);        
    }
}
