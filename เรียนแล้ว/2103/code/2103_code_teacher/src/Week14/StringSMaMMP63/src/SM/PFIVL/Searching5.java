/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SM.PFIVL;

//import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;

/**
 *
 * @author user
 */
public class Searching5 {
  //String p="abcd", text="abcdeabcdaaabcd"; 
   //String p="aaaa", text="aaaaaaaabcdeabcdaaaabcd";    
//  PreProcess pre;// = new PreProcess(p);
  int m;//=p.length();
  int e;//=m-1;
  int b;//=0;
   char last;
   char first;
  HashSet HT=new HashSet();
  Hashtable Max = new Hashtable();

  public Searching5(String pattern){
      m=pattern.length();
      last=pattern.charAt(m-1);
      first=pattern.charAt(0);
      HT.add(pattern.substring(1, pattern.length()-1));
      createMax(pattern); 
    //  System.out.println("Max:"+Max);
  }
  public void createMax(String pattern){
      for(int i=0;i<m;i++){
        Max.put(pattern.charAt(i), m);  
      }
      for(int i=0;i<m-1;i++){
          char c=pattern.charAt(i);
          int x=(Integer)Max.get(c);
          if((x==m)){
              //if(i)
              Max.remove(c);
              Max.put(c, m-(i+1));
          }else
          {
              Max.remove(c);
              Max.put(c, m-(i+1));              
          }
      }
  }
  public void search(String text) throws Exception{ 
      int n=text.length(),timecount=0;
      e=m-1;
      b=0;
      while(e < n ) {
      //  timecount++;  
        if(text.charAt(e)==last){
            timecount++;
            if (text.charAt(b)==first){
                timecount++;
                if(HT.contains(text.substring((b+1),e))){
        
            System.out.println("match at:"+(e+1));
        }
            }
        }    
       // try{        
        if(Max.get(text.charAt(e))!=null){
           e+=(Integer)Max.get(text.charAt(e));
           b=e-m+1;
        }
        else{
            e+=m;
            b=e-m+1;
        }
      //  }catch(Exception er){}
      //  System.out.println("e:"+e+"b:"+b);//+ "text:"+text.charAt(e));
     }//end while   
      System.out.println("Time count:"+timecount);
  }//end method
  
  public static void main(String args[])throws Exception{
  Searching5 a=new Searching5("aabcz");
  a.search("aabczefgaabczefgabcdg");
  }
}
