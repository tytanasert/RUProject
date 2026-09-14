/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MMP.IVMMP;

import java.util.Hashtable;

/**
 *
 * @author PC
 */
public class Preprocessing1 {
    HT IVLHT = new HT();
  
  public HT createDS(String pattern[],int c){
      for(int i=0;i<pattern.length; i++){
         int pos=1, begin=0, end=c, terminate=0;
         for(int j=0;j<pattern[i].length();j+=c){
            if(end==pattern[i].length()) terminate=1; 
            IVLHT.addPattern(pattern[i].substring(begin, end), pos, terminate,(i+1));
            begin += c; 
            end = begin+c;             
            if(end>=pattern[i].length()){             
              end = pattern[i].length();
            }
           if(end==pattern[i].length()) terminate=1;
             pos++;
      } //end for            
      }
      return IVLHT;
     }
  public Hashtable<String,Hashtable> getIVLHT(){
      return IVLHT.getHT();
  }  
}
