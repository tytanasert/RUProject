package integrativeString;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class RUStringApp {
    static RUString rustring = new RUString();
    public static void main(String args[]){
        String s1="ทดสอบการใช้งานสตริง RUString";
        rustring.BF(s1, "งาน");
        String s2 = rustring.Concatenation(s1, " การทำงานที่เพิ่มขึ้น");
        System.out.println(s2);
        System.out.println("ข้อความ การ ปรากฏที่ตำแหน่ง :"+rustring.Index(s1, "การ"));        
    }
    
}
