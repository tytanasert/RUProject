/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string62.stringmatching;

//import string62.*;

/**
 *
 * @author PC
 */
public class BF {
    
    public static void main(String args[]){
       String T="Test abcd Text abcd Test";
       String p="abcd";
       BF(T,p);       
    }
    public static void BF(String T, String p){
                  for(int j=0;j<=(T.length() -p.length());j++){
                      int i=0;
                      while((i<p.length())&&(T.charAt(j+i)==p.charAt(i))){
                          i++;
                          
                      }
                          if(i>=p.length()){
                              System.out.println("found at:"+(j+1));
                         }                    
                  }

    }
}
