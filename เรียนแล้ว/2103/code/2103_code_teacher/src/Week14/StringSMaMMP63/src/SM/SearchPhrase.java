/*
 * SearchPhrase.java
 *
 * Created on 29 �ԧ�Ҥ� 2547, 22:18 �.
 * Last update 29 �ѹ��¹ 2547,10.20 �.
 */

package SM;
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
         if(j>-1&&pattern.charAt(i)!=pattern.charAt(j))//{
              j=kmpNext[j];
              
          i++;
          j++;
         // System.out.println("j:"+j+"i:"+i);
          if(pattern.charAt(i)==pattern.charAt(j))
              kmpNext[i]=kmpNext[j];
          else
              kmpNext[j]=j;
         //} 
       //   System.out.println("Data Table:"+i+":"+kmpNext[i]);
      }
      System.out.println("Table:"+kmpNext[0]);
    }
    
    public void mainSearch(String text) throws IOException{
        int i,j;
      
            //***************************************
                  i=j=0;
                  while(j<text.length()){
                    if((i>-1)&&(pattern.charAt(i)!=text.charAt(j)))
                         i=kmpNext[i];
                    else //{ //begin x   
                     i++;
                    
                     j++;
                    
                     if(i>=pattern.length()){
                     //    System.out.println("match at:"+((j)));
                         i=kmpNext[i];
                     }
                   // }//end x
                  }
    
    }
        public static void main(String args[]) throws Exception{
         SearchPhrase a = new SearchPhrase("aaaa");
         a.mainSearch("aaaaaaaabcdeabcdaaaabcd");
  }
    //*****************************

}
