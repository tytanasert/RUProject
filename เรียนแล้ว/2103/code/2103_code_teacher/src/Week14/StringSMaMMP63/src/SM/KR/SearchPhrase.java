/*
 * SearchPhrase.java
 *
 * Created on 29 �ԧ�Ҥ� 2547, 22:18 �.
 * Last update 29 �ѹ��¹ 2547,10.20 �.
 */

package SM.KR;
//import stringmatchinglast.BF.*;
import java.io.*;
import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Vector;

/**
 *
 * @author  user
 */
public class SearchPhrase {       
   String pattern;//="abcd", text="abcdeabcdaaabcd"; 
   HashSet key = new HashSet(); 
  // int count=0;
   public SearchPhrase(String p){
       pattern=p;
       key.add(p);
   }
   public void mainSearch(String text) throws IOException{
       int j=0,timecount=0;
       //***************************************
       while(j<text.length()-pattern.length()+1){
           if(key.contains(text.substring(j,j+pattern.length()))){
             //  System.out.println("match at:"+(j+pattern.length()));
           }
           timecount++;
           j++;
       }
         System.out.println("Time count:"+timecount);     
    }
    //*****************************
     public static void main(String args[]) throws Exception{
      SearchPhrase a = new SearchPhrase("aaaa");
      a.mainSearch("aaaaaaaabcdeabcdaaaabcd");
  }
}
