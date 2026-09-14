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
public class Ex2 {
    
    public static void main(String args[]){
       char s1[]={'H','e', 'l', 'l', 'o',' ', 'W', 'o', 'r', 'l','d'}; //=new char[20]; //="Hello World";
       char s2[]={'Ê','Ç', 'Ñ', 'Ê','´','Õ', 'ª', 'Ò', 'Ç', 'â', 'Å', '¡'}; 
       char s3[]={'Ê','Ç','Ñ', 'Ê','´', 'Õ', ' ', '@', '#', '$', '@', ' ', '*', '*', 'a', 'b', 'c',
           'µ', 'è', 'Ò', '§', '´', 'Ò', 'Ç'};
       TraverseString(s1);
       TraverseString(s2);
       TraverseString(s3);        
    }
    public static void TraverseString(char s[]){        
        int k=0;
        while(k<s.length){
            System.out.print(s[k]);
            k++;
        }
        System.out.println();
    }
}
