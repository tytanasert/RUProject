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
public class Ex13 {
     public static void main(String args[]){
        String st="Test String ทดสอบ สตริง";        
        char ch[]=new char[30];
        ch= st.toCharArray();              
        String st1="";
        System.out.println("อักขระที่ 0:"+ch[0]);
        System.out.println("อักขระที่ 11:"+ch[10]);
        System.out.println("อักขระที่ 21:"+ch[20]);
        for(int i=0;i<ch.length;i++)
          st1=st1+ch[i];
        System.out.println("สายอักขระ st1 :"+st1);        
    }
    
}
