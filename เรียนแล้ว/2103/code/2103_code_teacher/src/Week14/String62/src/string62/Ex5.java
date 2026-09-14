/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string62;

/**
 *
 * @author PC
 */
public class Ex5 {
    
    public static void main(String args[]){
       String s1="Hello World";
       String s2="สวัสดี ชาวโลก";
       String s3=Concatenation(s1,s2);
       System.out.println(s3);       
    }
    
     public static String Concatenation(String S1, String S2){        
        int k=0;
        while(k<S2.length()){
            S1 = S1+S2.charAt(k);
            k++;
        }            
     return S1;
    }
}