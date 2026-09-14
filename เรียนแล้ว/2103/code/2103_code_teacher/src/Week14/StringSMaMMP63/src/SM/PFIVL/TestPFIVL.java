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
public class TestPFIVL {
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

  public TestPFIVL(String pattern){
      System.out.println("---- Preprocessing ------");
      m=pattern.length();
      last=pattern.charAt(m-1);
      first=pattern.charAt(0);
      HT.add(pattern.substring(1, pattern.length()-1));
      createMax(pattern); 
      System.out.println("HT:"+HT);
      System.out.println("Max:"+Max);
  }
  public void createMax(String pattern){
      for(int i=0;i<m;i++){
        Max.put(pattern.charAt(i), m);  
      }
      for(int i=0;i<m-1;i++){
          char c=pattern.charAt(i);
//          int x=(Integer)Max.get(c);
//          if((x==m)){
//              //if(i)
//              Max.remove(c);
//              Max.put(c, m-(i+1));
//          }else
//          {
              Max.remove(c);
              Max.put(c, m-(i+1));              
//          }
      }
//      System.out.println("Max:"+Max);
  }
  public void search(String text) throws Exception{ 
      int n=text.length(),timecount=0;
      e=m-1;
      b=0;
      System.out.println("---- Searching ------");
      while(e < n ) {
       System.out.println("------ ความพยายามครั้งที่ : "+(timecount+1)+"---- e="+e); 
       System.out.println("c last:"+last+"  c  first:"+first);
       timecount++;  
       System.out.println("text e:"+text.charAt(e));
        if(text.charAt(e)==last){
           System.out.println("e:"+text.charAt(e));
            if (text.charAt(b)==first){
             System.out.println("b:"+text.charAt(e));
                if(HT.contains(text.substring((b+1),e))){
                   System.out.println("substring b-e:"+text.substring((b+1),e)); 
                   System.out.println("match at:"+(e+1));
        }
            }
        }    
       System.out.println("---- Shift Calculation ----");        
        if(Max.get(text.charAt(e))!=null){
            System.out.println("Max.get(text.charAt(e):"+Max.get(text.charAt(e)));
           e+=(Integer)Max.get(text.charAt(e));
           b=e-m+1;
        }
        else{
            System.out.println(" shift value: e+m:"+(e+m));
            e+=m;
            b=e-m+1;
        }
      //  }catch(Exception er){}
      //  System.out.println("e:"+e+"b:"+b);//+ "text:"+text.charAt(e));
     }//end while   
     // System.out.println("Time count:"+timecount);
  }//end method
  
  public static void main(String args[])throws Exception{
  TestPFIVL a=new TestPFIVL("aabcz");
  a.search("aabczefgaabczefgabcdg");
  }
}
