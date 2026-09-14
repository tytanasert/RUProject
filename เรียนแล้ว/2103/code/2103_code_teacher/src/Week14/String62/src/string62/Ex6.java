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
public class Ex6 {
    
    public static void main(String args[]){
       String s1="The text for Testing";
       String s2="สวัสดี ชาวโลก";
       int l1=StringLength(s1);
       int l2=StringLength(s2);
       System.out.println("Length of String s1="+l1+" : Length of String s2="+l2);       
    }
    
     public static int StringLength(String S){        
        int k=0;
        int length =0;
        while(k < S.length()){
            length++;
            k++;
        }            
     return length;
    }          
}