/*
 * SearchPhrase.java
 *
 * Created on 29 �ԧ�Ҥ� 2547, 22:18 �.
 * Last update 29 �ѹ��¹ 2547,10.20 �.
 */

package SM.KMP;
import SM.*;
import java.io.*;

/**
 *
 * @author  user
 */
public class SearchPhrase {       
   String pattern;
   int []kmpNext= new int[66];
    /** Creates a new instance of SearchPhrase */
    public SearchPhrase(String str) {
      pattern = str;
      //preprocessing phase
      int m=str.length();
      int i=0;
      int j=kmpNext[0]=-1;
      while(i<m-1){
         // while((j>-1)&&(pattern.charAt(i)!=pattern.charAt(j)))
         while(j>-1&&pattern.charAt(i)!=pattern.charAt(j))//{
              j=kmpNext[j];
              
          i++;
          j++;
          System.out.println("j:"+j+"i:"+i);
          if(pattern.charAt(i)==pattern.charAt(j))
              kmpNext[i]=kmpNext[j];
          else
              kmpNext[j]=j;
         //} 
       //   System.out.println("Data Table:"+i+":"+kmpNext[i]);
      }
      System.out.println("Table 0:"+kmpNext[0]);
      System.out.println("Table 1:"+kmpNext[1]);
      System.out.println("Table 2:"+kmpNext[2]);
      System.out.println("Table 3:"+kmpNext[3]);
      System.out.println("Table 4:"+kmpNext[4]);
      System.out.println("Table 5:"+kmpNext[5]);
      System.out.println("Table 6:"+kmpNext[6]);
      System.out.println("Table 7:"+kmpNext[7]);
      System.out.println("Table 8:"+kmpNext[8]);
    }
    
    public void mainSearch(String text) throws IOException{
        int i,j;
      
            //***************************************
                  i=j=0;
                  while(j<text.length()){
                    while((i>-1)&&(pattern.charAt(i)!=text.charAt(j)))
                         i=kmpNext[i];
                    //else //{ //begin x   
                     i++;
                    
                     j++;
                    
                     if(i>=pattern.length()){
                         System.out.println("match at:"+((j)));
                         i=kmpNext[i];
                     }
                   // }//end x
                  }
    
    }
        public static void main(String args[]) throws Exception{
         SearchPhrase a = new SearchPhrase("GCAGAGAG");
         a.mainSearch("aaaaaaaabcdeabcdaaaabcd");
  }
    //*****************************

}
