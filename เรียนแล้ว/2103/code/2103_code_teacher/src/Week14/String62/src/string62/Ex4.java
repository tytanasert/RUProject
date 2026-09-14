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
public class Ex4 {
    
    public static void main(String args[]){
       String s1="Hello World";       
       int pos=Index(s1,"World");
       System.out.println("Index of 'World' :"+pos);
    }
    
    public static int Index(String S, String p){ 
        int pos=-1;
        int s=S.length()-(p.length());        
        int k=0;
        System.out.println(S.length());
        while(k<=s){
            int i=0;
            while ((p.charAt(i) == S.charAt(k+i))) {              
                  i++; 
                  //System.out.println(":-->"+S.charAt(i)+":"); 
              if(i==p.length()-2){
                pos=k+1; return pos;
              }                  
            }
              k++;
            }
        return pos;
        }

}
