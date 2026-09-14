/*
 * SearchPhrase.java
 *
 * Created on 29 �ԧ�Ҥ� 2547, 22:18 �.
 * Last update 29 �ѹ��¹ 2547,10.20 �.
 */

package SM.QS;
import java.io.*;

/**
 *
 * @author  user
 */
public class SearchPhrase {       
   String pattern;
    /** Creates a new instance of SearchPhrase */
    public SearchPhrase(String str) {
      pattern = str;      
    }
    
    public void preQsBc(String x, int m, int qsBc[]){
      int i;
    //  System.out.println("Preprocessing");
      for(i=0;i<66;++i) qsBc[i]=m+1;
       for(i=0;i<m;++i) qsBc[gotoChar(x.charAt(i))]=m-i; 
//      System.out.println("a:"+qsBc[gotoChar('a')]);
//      System.out.println("b:"+qsBc[gotoChar('b')]);
//      System.out.println("c:"+qsBc[gotoChar('c')]);
//      System.out.println("d:"+qsBc[gotoChar('d')]);
    } 
    public int gotoChar(char c){
        int number=-1;
        switch(c){
           case 'A': {number=0; break;} 
           case 'B': {number=1; break;}
           case 'C': {number=2; break;}
           case 'D': {number=3; break;}
           case 'E': {number=4; break;}
           case 'F': {number=5; break;}
           case 'G': {number=6; break;}
           case 'H': {number=7; break;}
           case 'I': {number=8; break;}
           case 'J': {number=9; break;}
           case 'K': {number=10; break;}
           case 'L': {number=11; break;}
           case 'M': {number=12; break;}
           case 'N': {number=13; break;}
           case 'O': {number=14; break;}
           case 'P': {number=15; break;}
           case 'Q': {number=16; break;}
           case 'R': {number=17; break;}
           case 'S': {number=18; break;}
           case 'T': {number=19; break;}
           case 'U': {number=20; break;}
           case 'V': {number=21; break;}
           case 'W': {number=22; break;}
           case 'X': {number=23; break;}
           case 'Y': {number=24; break;}
           case 'Z': {number=25; break;}
           case 'a': {number=26; break;}
           case 'b': {number=27; break;}
           case 'c': {number=28; break;}
           case 'd': {number=29; break;}
           case 'e': {number=30; break;}
           case 'f': {number=31; break;}
           case 'g': {number=32; break;}
           case 'h': {number=33; break;}
           case 'i': {number=34; break;}
           case 'j': {number=35; break;}
           case 'k': {number=36; break;}
           case 'l': {number=37; break;}
           case 'm': {number=38; break;}
           case 'n': {number=39; break;}
           case 'o': {number=40; break;}
           case 'p': {number=41; break;}
           case 'q': {number=42; break;}
           case 'r': {number=43; break;}
           case 's': {number=44; break;}
           case 't': {number=45; break;}
           case 'u': {number=46; break;}
           case 'v': {number=47; break;}
           case 'w': {number=48; break;}
           case 'x': {number=49; break;}
           case 'y': {number=50; break;}
           case 'z': {number=51; break;}
           case '0': {number=52; break;}
           case '1': {number=53; break;}
           /**************/
            case '@': {number=54; break;}
           case  '#' : {number=55; break;}
           case  '%' :  {number=56; break;}
           case  '&' : {number=57; break;}
           case  '*':  {number=58; break;}
           case '(':{number=59; break;}
           case ')':{number=60; break;}
           case '-': {number=61; break;}
           case '=':{number=62; break;}
           case '<':{number=63; break;}
           case '>': {number=64; break;}
           case '?':{number=65; break;}
           case ' ': {number=66; break;}
           default: {number=66; break;}

       }
       return number;
   }       
    
    
    public long QS(String x, int m, String y,int n) throws Exception{
        int i,j, qsBc[]=new int[67], timecount=0;
        preQsBc(x,m,qsBc);
        //***Seraching***
        j=0;
        long tb=System.nanoTime();
        while(j<=n-m){
             // System.out.println("String y:"+y.substring(j,j+m)+"  j:"+j);
                //String t;
               timecount++;
               if(y.substring(j,j+m).compareTo(x)==0){  j++;}//เพิ่ม j++ เพื่อให้หลุดลูปเดิมไม่มี
                //  System.out.println("match at:"+(j+m));
                  System.out.println("j+m:"+(j+m));
                int oldj=j;
                    if(j+m<n-1){
                      j+=qsBc[gotoChar(y.charAt(j+m))];
                      if(j==oldj) j++;
                     // System.out.println("m="+m);
                    }
                    else
                        j=n;
                    //System.out.println("j:"+j);
          // if(j>=y.length()) break;         
        }
        System.out.println("Time count:"+timecount);
        long te=System.nanoTime();
        return te-tb;
    }
    
    public long mainSearch(String text) throws Exception{                       
                  return QS(pattern,pattern.length(),text,text.length());
    }
        public static void main(String args[]) throws Exception{
         SearchPhrase a = new SearchPhrase("aabcz");//SearchPhrase("abcd");
         a.mainSearch("aabczefgaabczefgabcdg");
        }
}
