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
public class Ex3 {
    
    public static void main(String args[]){
       char s1[]={'H','e', 'l', 'l', 'o',' ', 'W', 'o', 'r', 'l','d'}; //=new char[20]; //="Hello World";
       char s2[]={'Ê','Ç', 'Ñ', 'Ê','´','Õ', 'ª', 'Ò', 'Ç', 'â', 'Å', '¡'}; 
       char s3[]={'Ê','Ç','Ñ', 'Ê','´', 'Õ', ' ', '@', '#', '$', '@', ' ', '*', '*', 'a', 'b', 'c',
           'µ', 'è', 'Ò', '§', '´', 'Ò', 'Ç'};
       String st1=Substring(s1,3,5);
       String st2=Substring(s2,2,7);
       String st3=Substring(s3,1,9);        
       System.out.println("String 1:"+st1);
       System.out.println("String 2:"+st2);
       System.out.println("String 3:"+st3);
    }
    public static String Substring(char S[], int begin, int end){        
        String st="";
        int k=0;
        while(k<=end){
            if (k>=begin){
                st=st+S[k];
            }
            k++;
        }
        return st;
    }
}
