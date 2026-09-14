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
public class Ex12 {
      public static void main(String args[]){
        String st="Test String ทดสอบ สตริง";        
        System.out.println("อัขระที่ 0:"+st.charAt(0));
        System.out.println("อัขระที่ 11:"+st.charAt(10));
        System.out.println("อัขระที่ 21:"+st.charAt(20));
        System.out.println("ตำแหน่งของ ข้อความ ทดสอบ:"+st.indexOf("ทดสอบ"));
        System.out.println("ความยาวของสายอักขระ:"+st.length());
        System.out.println("แปลงเป็นอักขระพิมพ์เล็ก:"+st.toLowerCase());
        System.out.println("แปลงเป็นอักขระพิมพ์เล็ก:"+st.toUpperCase());        
    }
    
}
